package roles.parcial.Parcial2.servicio;

import org.springframework.stereotype.Service;

import roles.parcial.Parcial2.controladores.UserRegistro;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ApplicationDBContext applicationDBContext;

    @Override
    public List<User> getAllUsers() {
        return applicationDBContext.Users.ToList();
    }

    @Override
    public User saveUser(UserRegistro userRegistrationDTO) throws UserExistsException {
        if (applicationDBContext.Users.Any(u => u.Username == userRegistrationDTO.getUsername())) {
            throw new UserExistsException("The username already exists");
        }
        Rol userRole = applicationDBContext.Roles.FirstOrDefault(r => r.Rol_nombre == "ROLE_USER");
        if (userRole == null) {
            throw new RuntimeException("The ROLE_USER role is not found in the database");
        }
        User user = new User(userRegistrationDTO.Username, userRegistrationDTO.Password, new List<Rol> { userRole });
        applicationDBContext.Users.Add(user);
        applicationDBContext.SaveChanges();
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        return applicationDBContext.Users.FirstOrDefault(u => u.Username == username);
    }

    @Override
    public void assignRoleToUser(Long userId, Long roleId) {
        User user = applicationDBContext.Users.Find(userId);
        Rol role = applicationDBContext.Roles.Find(roleId);
        if (user!= null && role!= null) {
            user.Roles.Add(role);
            applicationDBContext.SaveChanges();
        }
    }

    @Override
    public void removeRoleFromUser(Long userId, Long roleId) {
        User user = applicationDBContext.Users.Find(userId);
        Rol role = applicationDBContext.Roles.Find(roleId);
        if (user!= null && role!= null) {
            user.Roles.Remove(role);
            applicationDBContext.SaveChanges();
        }
    }
}

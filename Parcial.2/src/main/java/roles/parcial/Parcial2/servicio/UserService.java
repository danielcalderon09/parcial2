package roles.parcial.Parcial2.servicio;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService{

	public User guardar(UserRegistro registro) throws UsuarioExistenteException;
	
	public List<User> listarUser();
	
	User findByUsername(String username);

    public List<User> getAllUser();
}

package roles.parcial.Parcial2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import roles.parcial.Parcial2.entidades.User;
import roles.parcial.Parcial2.servicio.UserService;

@Controller
public class LoginController {
  @Autowired
  private UserService userService;
  
  @GetMapping("/login")
  public String loginForm() {
    return "login";
  }
  
  @PostMapping("/login")
  public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
    User user = userService.login(username, password);
    if (user!= null) {
      session.setAttribute("user", user);
      if (user.getRole().equals("RECTOR")) {
        return "redirect:/asignaturas";
      } else {
        return "redirect:/asignaturas/view";
      }
    } else {
      return "login";
    }
  }
}
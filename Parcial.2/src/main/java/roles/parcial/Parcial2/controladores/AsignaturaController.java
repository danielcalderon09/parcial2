package roles.parcial.Parcial2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import roles.parcial.Parcial2.entidades.Asignatura;
import roles.parcial.Parcial2.entidades.User;
import roles.parcial.Parcial2.servicio.AsignaturaService;

@Controller
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        
    }

    @GetMapping("/asignaturas")
    public String showAsignaturas(ModelMap model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user.getRole().equals("RECTOR")) {
            model.put("asignaturas", asignaturaService.getAllAsignaturas());
            return "asignaturas";
        } else {
            model.put("asignaturas", asignaturaService.getAllAsignaturas());
            return "asignaturas-view";
        }
    }

    @GetMapping("/new")
    public String showAddAsignaturaPage(ModelMap model) {
        model.addAttribute("asignatura", new Asignatura());
        return "asignatura-form";
    }

    @PostMapping
    public String addAsignatura(ModelMap model, @Valid Asignatura asignatura, BindingResult result) {
        if (result.hasErrors()) {
            return "asignatura-form";
        }
        asignaturaService.createAsignatura(asignatura);
        return "redirect:/asignaturas";
    }

    @GetMapping("/{id}/delete")
    public String deleteAsignatura(@PathVariable Long id) {
        asignaturaService.deleteAsignatura(id);
        return "redirect:/asignaturas";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateAsignaturaPage(@PathVariable Long id, ModelMap model) {
        Asignatura asignatura = asignaturaService.getAsignatura(id);
        model.put("asignatura", asignatura);
        return "asignatura-form";
    }

    @PostMapping("/{id}")
    public String updateAsignatura(ModelMap model, @Valid Asignatura asignatura, BindingResult result) {
        if (result.hasErrors()) {
            return "asignatura-form";
        }
        asignaturaService.updateAsignatura(asignatura);
        return "redirect:/asignaturas";
    }
}
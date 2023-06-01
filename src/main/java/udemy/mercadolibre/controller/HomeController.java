package udemy.mercadolibre.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import udemy.mercadolibre.model.Vacante;
import udemy.mercadolibre.service.*;

import java.text.*;
import java.util.*;

@Controller
public class HomeController {

    @Autowired
    private IVacantesService serviceVacantes;

    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "tabla";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model){
        Vacante vacante = new Vacante();
        vacante.setNombre("Enfermero");
        vacante.setDescripcion("Se solicita enfermero para cuidar a adulto mayor");
        vacante.setFecha(new Date());
        vacante.setSalario(1000000.0);

        model.addAttribute("vacante", vacante);
        return "detalle";
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model){
        List<String> lista = new LinkedList<String>();
        lista.add("Ingeniero de sistemas");
        lista.add("Auxiliar de contabilidad");
        lista.add("Vendedor");
        lista.add("Arquitecto");

        model.addAttribute("empleos", lista);

        return "listado";
    }
    @GetMapping("/")
    public String mostrarHome(Model model){
      /*model.addAttribute("mensaje", "Bienvenido a Empleos App");
      model.addAttribute("fecha", new Date());*/
      String nombre = "Auxiliar de contabilidad";
      Date fechaPublicacion = new Date();
      double salario = 10000.0;
      boolean vigente = true;

      model.addAttribute("nombre", nombre);
      model.addAttribute("fecha", fechaPublicacion);
      model.addAttribute("salario", salario);
      model.addAttribute("vigente", vigente);

      return "home";
    }


}

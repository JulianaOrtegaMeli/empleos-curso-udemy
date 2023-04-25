package udemy.mercadolibre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import udemy.mercadolibre.model.Vacante;

import java.text.*;
import java.util.*;

@Controller
public class HomeController {

    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = getVacantes();
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

    private List<Vacante> getVacantes() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Vacante> lista = new LinkedList<Vacante>();

        try{
            Vacante v1 = new Vacante();
            v1.setId(1);
            v1.setNombre("Ingeniero Civil");
            v1.setDescripcion("Solicitamos ingeniero civil para diseñar puente peatonal");
            v1.setFecha(sdf.parse("08-02-2023"));
            v1.setSalario(1500000.0);
            v1.setDestacado(1);
            v1.setImage("empresa1.png");

            Vacante v2 = new Vacante();
            v2.setId(2);
            v2.setNombre("Ingeniero ambiental");
            v2.setDescripcion("Solicitamos ingeniero ambiental para dirigir la hornamentacion de un condominio residencial");
            v2.setFecha(sdf.parse("10-03-2023"));
            v2.setSalario(800000.0);
            v2.setDestacado(0);
            v2.setImage("empresa2.png");

            Vacante v3 = new Vacante();
            v3.setId(3);
            v3.setNombre("Abogado");
            v3.setDescripcion("Solicitamos abogado para tramitar herencia");
            v3.setFecha(sdf.parse("31-03-2023"));
            v3.setSalario(2500000.0);
            v3.setDestacado(1);

            lista.add(v1);
            lista.add(v2);
            lista.add(v3);

        }catch(ParseException e){
            System.out.println("ERROR: " + e.getMessage());
        }
        return lista;
    }

}

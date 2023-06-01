package udemy.mercadolibre.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {

    // @GetMapping("/index")
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String mostrarIndex(Model model) {
        return "categorias/listCategorias";
    }
    // @GetMapping("/create")
    @RequestMapping(value="/create", method=RequestMethod.GET)
    public String crear() {
        return "categorias/formCategoria";
    }
    // @PostMapping("/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
        System.out.println("Categoria: " + nombre);
        System.out.println("Descripcion: " + descripcion);
        return "categorias/listCategorias";
    }
}

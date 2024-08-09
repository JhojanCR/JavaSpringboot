package com.apprestaurante.AppRestaurante.controller;

import com.apprestaurante.AppRestaurante.model.Restaurante;
import com.apprestaurante.AppRestaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired

    private final RestauranteRepository restauranteRepository;

    public RestauranteController(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    @GetMapping
    public String listarRestaurantes(Model model){
        List<Restaurante> restaurantes = restauranteRepository.findAll();
        model.addAttribute("restaurantes", restaurantes);
        return "restaurantes";
    }

    @GetMapping("/nuevo")
    public String mostrarRestauranteCreado(Model model){
        model.addAttribute("restaurante", new Restaurante());
        return "registrar_usuario";
    }

    @PostMapping("/nuevo")
    public String registrarRestaurante(@ModelAttribute("restaurante") Restaurante restaurante){
        restauranteRepository.save(restaurante);
        return "redirect:/restaurantes";
    }

    @GetMapping("/modificar/{id}")
    public String mostrarFormularioParaEditar(@PathVariable long id, Model model) {
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
        model.addAttribute("restaurante", restaurante);
        return "modificar_usuario";
    }

    @PostMapping("/{id}")
    public String actualizarRestaurante(@PathVariable Long id, @ModelAttribute("restaurante") Restaurante restauranteActualizado) {
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
        restaurante.setNombreDelNegocio(restauranteActualizado.getNombreDelNegocio());
        restaurante.setCorreo(restauranteActualizado.getCorreo());
        restaurante.setPaginaWeb(restauranteActualizado.getPaginaWeb());
        restaurante.setTelefono(restauranteActualizado.getTelefono());
        restauranteRepository.save(restaurante);
        return "redirect:/restaurantes";
    }

    @GetMapping("/eliminar/{id}")
    public String borrarUsuario(@PathVariable long id){
        restauranteRepository.deleteById(id);
        return "redirect:/restaurantes";
    }
}




/*
@Controller
@RequestMapping("/restaurantes")

public class RestauranteController {

    // Inyección de independecia Autowired

    @Autowired

    // Al realizar la inyección de dependencias crear un contructor con private final y agregar el respectivo
    // constructor

    private final RestauranteRepository restauranteRepository;

    public RestauranteController(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    // Se empiezan a crear los métodos con lso GetMapping y PostMapping

    @GetMapping
    public String listarRestaurantes(Model model){
        List<Restaurante> restaurantes = restauranteRepository.findAll();
        model.addAttribute("restaurantes", new Restaurante());
        return  "restaurantes";
    }

    // Mostrar usuario nuevo tipo restaurante (negocio)

    @GetMapping("/nuevo")
    public String mostrarRestauranteCreado(Model model){
        model.addAttribute("restaurante", new Restaurante());
        return "registro_usuario";
    }

    // Registrar - crear nuevo usuario tipo restaurantr

    @PostMapping("/nuevo")
    public String registrarRestaurante(@ModelAttribute("restaurante") Restaurante restaurante){
        restauranteRepository.save(restaurante);
        return "redirect:/restaurantes";
    }

    @GetMapping("/modificar/{id}")
    public String mostrarFormularioParaEditar(@PathVariable long id, Model model)
    throws Throwable {
        Restaurante restaurante = (Restaurante) restauranteRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Restaurante no encontrado"));
                model.addAttribute("restaurante", restaurante);
                return "editar_usuario";

    }

    @PostMapping("/{id}")
    public String actualizarRestaurante(@PathVariable Long id, @ModelAttribute("restaurante")
    Restaurante restauranteActualizado) throws Throwable{
        Restaurante restaurante = (Restaurante) restauranteRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Restaurante no encontrado"));
        restaurante.setNombreDelNegocio(restauranteActualizado.getNombreDelNegocio());
        restaurante.setCorreo(restauranteActualizado.getCorreo());
        restaurante.setPaginaWeb(restauranteActualizado.getPaginaWeb());
        restaurante.setTelefono(restauranteActualizado.getTelefono());
        restauranteRepository.save(restaurante);
        return "redirect:/restaurantes";
    }

    @GetMapping("/eliminar/{id}")
    public String borrarUsuario(@PathVariable long id){
        restauranteRepository.deleteById(id);
        return "redirect:/restaurantes";
    }

}

*/

package com.apprestaurante.AppRestaurante.controller;

import com.apprestaurante.AppRestaurante.model.Restaurante;
import com.apprestaurante.AppRestaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/registro")

public class RestauranteController {

    // Inyección de independecia Autowired

    @Autowired

    // Tomar la clase interface del Repository

    private RestauranteRepository restauranteRepository;

    public String listarRestaurantes(Model model){
        List<Restaurante> restaurantes = restauranteRepository.findAll();
        model.addAttribute("restaurante", new Restaurante());
        return  "restaurantes";
    }

    // Mostrar usuario nuevo tipo restaurante (negocio)

    @GetMapping("/nuevo")

    public String mostrarRestauranteCreado(Model model){
        model.addAttribute("restaurante", new Restaurante());
        return "registro-restaurante";
    }

    // Registrar - crear nuevo usuario tipo restaurantr

    @PostMapping

    public String registrarRestaurante(@ModelAttribute("restaurante") Restaurante restaurante){
        restauranteRepository.save(restaurante);
        return "redirect:/home";
    }

    @GetMapping("/modificar/{id}")

    public String mostrarFormularioParaEditar(@PathVariable long id, Model model)
    throws Throwable {
        Restaurante restaurante = (Restaurante) restauranteRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Restaurante no encontrado"));
                model.addAttribute("restaurante", restaurante);
                return "editar-restaurante";

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
        return "redirect:/home";
    }

}

package com.proyectoapp.ProyectoApp.controller;

import com.proyectoapp.ProyectoApp.model.Clientes;
import com.proyectoapp.ProyectoApp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/clientes")


public class ClientController {

    // Inyección de dependencias

    @Autowired
    private ClientRepository clientRepository;

    // Manejador de la lista de clientes de los Get

    // Mapeador de atributos

    @GetMapping
    public String listarClientes(Model model){
        List<Clientes> clientes = clientRepository.findAll();
        model.addAttribute("Clientes", clientes);
        return "Clientes";
    }

    // Función Usuario nuevo

    @GetMapping("/nuevo")
    private String mostrarFormularioDeRegistro(Model model){
        model.addAttribute("Client", new Clientes());
        return "registro_cliente";
    }

    // Función que maneja las solicitudes POST a /cliente y crear un nuevo cliente

    @PostMapping
    public String crearCliente(@ModelAttribute("Client") Clientes clientes){
        clientRepository.save(clientes);
        return  "rediret:/clientes";

    }

    // Función mostrar lista clientes de edición

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable long id, Model model){
        Clientes clientes = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        model.addAttribute("clientes", clientes);
        return "editar_cliente";
    }

    @PostMapping("/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("clientes") Clientes clienteActualizado){
        Clientes clientes = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        clientes.setNombre(clienteActualizado.getNombre());
        clientes.setCorreo(clienteActualizado.getCorreo());
        clientes.setTelefono(clienteActualizado.getTelefono());
        clientRepository.save(clientes);
        return "redirect:/clientes";
    }

    @GetMapping("/eliminar/id")
    public String borrarCliente(@PathVariable Long id){
        clientRepository.deleteById(id);
        return "redirect:/clientes";
    }

}









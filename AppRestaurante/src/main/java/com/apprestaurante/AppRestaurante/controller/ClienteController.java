package com.apprestaurante.AppRestaurante.controller;

import com.apprestaurante.AppRestaurante.model.Cliente;
import com.apprestaurante.AppRestaurante.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    // inyeccion de dependencias

    @Autowired
    private ClienteRepository clienteRepository;

    // manejador de la lista de clientes de los GET

    @GetMapping
    public String listarClientes(Model model) {

        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    // funcion Usuario Nuevo mostra usuario

    @GetMapping("/nuevo")
    public String mostrarFomularioDeRegistro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "registro_cliente";
    }

    // Funcion que maneja las solictudes POST a /cliente y crear un nuevo cliente

    @PostMapping
    public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    // funcion mostrar lista clientes edicion

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable long id, Model model) throws Throwable {

        Cliente cliente = (Cliente) clienteRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Cliente no encontrado"));
                model.addAttribute("cliente", cliente);
                return  "editar-cliente";

    }

    @PostMapping("/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente clienteActualizado) throws Throwable {
        Cliente cliente = (Cliente) clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no Encontrado"));
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setCorreo(clienteActualizado.getCorreo());
        cliente.setTelefono(clienteActualizado.getTelefono());
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

}


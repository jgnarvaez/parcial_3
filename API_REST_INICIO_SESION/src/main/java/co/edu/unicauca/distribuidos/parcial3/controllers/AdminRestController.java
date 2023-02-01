package co.edu.unicauca.distribuidos.parcial3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.distribuidos.parcial3.services.IAdminService;
import co.edu.unicauca.distribuidos.parcial3.services.IClienteService;
import co.edu.unicauca.distribuidos.parcial3.services.DTO.AdminDTO;
import co.edu.unicauca.distribuidos.parcial3.services.DTO.ClienteDTO;
import co.edu.unicauca.distribuidos.parcial3.services.DTO.DatosLoginDTO;

@RestController
@RequestMapping("/api")
public class AdminRestController {
    @Autowired
    private IAdminService adminService;
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/login")
    public Object index(@RequestBody DatosLoginDTO log) {
         Object objAdminClient = null; //crea un objeto de tipo object por que no se conoce si sera adminstrador o cliente       
        
        objAdminClient = adminService.findByLoginPassword(log);// busca entre los administradores si no la encuentra es nulo
        if (objAdminClient== null){
            objAdminClient = clienteService.findByLoginPassword(log);// busca entre los clientes si no la encuentra es nulo
        }
        if(objAdminClient!=null){
            AdminDTO prue =new AdminDTO();
            ClienteDTO prue2=new ClienteDTO();
            System.out.println("es Administrador?"+  prue.getClass().equals(objAdminClient.getClass()));
            System.out.println("es cliente?"+  prue2.getClass().equals(objAdminClient.getClass()));
            
        }
        
        return objAdminClient;
    }

    @GetMapping("/admin")
    public List<AdminDTO> index() {
        return adminService.findAll();
    }
    @GetMapping("/cliente")
    public List<ClienteDTO> index2() {
        return clienteService.findAll();
    }

    @GetMapping("/admin/{login}")
    public AdminDTO show(@PathVariable String login) {
        AdminDTO objAdmin = null;
        objAdmin = adminService.findByLogin(login);
        return objAdmin;
    }

    @PostMapping("/admin")
    public AdminDTO create(@RequestBody AdminDTO admin) {
        AdminDTO objAdmin = null;
        objAdmin = adminService.save(admin);
        return objAdmin;
    }
    @PostMapping("/cliente")
    public ClienteDTO create(@RequestBody ClienteDTO cliente) {
        ClienteDTO objCliente = null;
        objCliente = clienteService.save(cliente);
        return objCliente;
    }
    @PutMapping("/admin/{login}")
    public AdminDTO update(@RequestBody AdminDTO admin, @PathVariable String login) {
        AdminDTO objAdmin = null;
        AdminDTO adminActual = adminService.findByLogin(login);
        if (adminActual != null) {
            objAdmin = adminService.update(login, admin);
        }
        return objAdmin;
    }

    @DeleteMapping("/admin/{login}")
    public Boolean delete(@PathVariable String login) {
        Boolean bandera = false;
        AdminDTO adminActual = adminService.findByLogin(login);
        if (adminActual != null) {
            bandera = adminService.delete(login);
        }
        return bandera;

    }
}

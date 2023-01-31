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
import co.edu.unicauca.distribuidos.parcial3.services.DTO.AdminDTO;

@RestController
@RequestMapping("/api")
public class AdminRestController {
    @Autowired
    private IAdminService adminService;

    @GetMapping("/admin")
    public List<AdminDTO> index() {
        return adminService.findAll();
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

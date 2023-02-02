package co.edu.unicauca.distribuidos.parcial3.controllers;

import java.util.List;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.distribuidos.parcial3.services.IAdminService;
import co.edu.unicauca.distribuidos.parcial3.services.IClienteService;
import co.edu.unicauca.distribuidos.parcial3.services.DTO.AdminDTO;
import co.edu.unicauca.distribuidos.parcial3.services.DTO.ClienteDTO;
import co.edu.unicauca.distribuidos.parcial3.services.DTO.DatosLoginDTO;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/api")
@Validated
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
    public AdminDTO create(@Valid @RequestBody AdminDTO admin) {
        AdminDTO objAdmin = null;
        objAdmin = adminService.save(admin);
        return objAdmin;
    }
    @PostMapping("/cliente")
    public ClienteDTO create(@Valid @RequestBody ClienteDTO cliente) {
        ClienteDTO objCliente = null;
        objCliente = clienteService.save(cliente);
        return objCliente;
    }
    @PutMapping("/admin/{login}")
    public AdminDTO update(@Valid @RequestBody AdminDTO admin, @PathVariable String login) {
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


    
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
		return new ResponseEntity<>("nombre del método y parametros erroneos: " + e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;
	}

}

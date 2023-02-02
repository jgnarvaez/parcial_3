package co.edu.unicauca.distribuidos.parcial3.services.DTO;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
@Getter
@Setter
@AllArgsConstructor
public class ClienteDTO {
    @Size(min = 5, max = 50, message = "longitud no valida")
    private String nombre;
    @Size(min = 5, max = 50, message =  "longitud no valida")
    private String apellido;
	@Email(message = "no es direccion de email")
    private String correo;
	@Pattern(message = "debe iniciar con 5 y ser de 9 longitud", regexp = "[5][0-9]{9}")
    private String telefono;    
    @Size(min = 10, max = 20, message =  "longitud no valida")
    private String login;
    @Size(min = 10, max = 20, message =  "longitud no valida")
    private String password;

    public ClienteDTO() {

    }
}

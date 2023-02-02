package co.edu.unicauca.distribuidos.parcial3.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


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
public class AdminDTO {
    @Size(min = 5, max = 50, message = "longitud no valida")
    private String nombre;
    @Size(min = 5, max = 50, message =  "longitud no valida")
    private String apellido;
    @Size(min = 10, max = 20, message =  "longitud no valida")
    private String login;
    @Size(min = 10, max = 20, message =  "longitud no valida")
    private String password;

    public AdminDTO() {

    }
}

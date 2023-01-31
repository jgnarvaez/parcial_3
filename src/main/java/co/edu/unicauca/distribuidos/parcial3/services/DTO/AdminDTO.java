package co.edu.unicauca.distribuidos.parcial3.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class AdminDTO {
    private String nombre;
    private String apellido;
    private String login;
    private String password;

    public AdminDTO() {

    }
}

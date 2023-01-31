package co.edu.unicauca.distribuidos.parcial3.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ClienteDTO {
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String login;
    private String password;

    public ClienteDTO() {

    }
}

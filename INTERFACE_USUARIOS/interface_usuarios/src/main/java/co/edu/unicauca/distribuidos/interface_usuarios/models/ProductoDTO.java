package co.edu.unicauca.distribuidos.interface_usuarios.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductoDTO {
    private String codigo;
    private String nombre;
    private Integer valorInicial;

    public ProductoDTO() {

    }
}

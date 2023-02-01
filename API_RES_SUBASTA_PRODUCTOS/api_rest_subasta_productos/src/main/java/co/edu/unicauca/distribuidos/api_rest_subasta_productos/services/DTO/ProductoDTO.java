package co.edu.unicauca.distribuidos.api_rest_subasta_productos.services.DTO;

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

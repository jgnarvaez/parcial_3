package co.edu.unicauca.distribuidos.api_rest_subasta_productos.controllers;

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

import co.edu.unicauca.distribuidos.api_rest_subasta_productos.services.IProductoService;
import co.edu.unicauca.distribuidos.api_rest_subasta_productos.services.DTO.ProductoDTO;

@RestController
@RequestMapping("/api")
public class APIRestController {
    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<ProductoDTO> index() {
        return productoService.findAll();
    }

    @GetMapping("/subastados")
    public List<ProductoDTO> index2() {
        return productoService.findSubastados();
    }

    @GetMapping("/nosubastados")
    public List<ProductoDTO> index3() {
        return productoService.findNOSubastados();
    }

    @GetMapping("/producto/{codigo}")
    public ProductoDTO show(@PathVariable String codigo) {
        ProductoDTO objProducto = null;
        objProducto = productoService.findByCodigo(codigo);
        return objProducto;
    }

    @PostMapping("/producto")
    public ProductoDTO create(@RequestBody ProductoDTO producto) {
        ProductoDTO objProducto = null;
        objProducto = productoService.save(producto);
        return objProducto;
    }

    @PutMapping("/producto/{codigo}")
    public ProductoDTO update(@RequestBody ProductoDTO producto, @PathVariable String codigo) {
        ProductoDTO objProducto = null;
        ProductoDTO productoActual = productoService.findByCodigo(codigo);
        if (productoActual != null) {
            objProducto = productoService.update(codigo, producto);
        }
        return objProducto;
    }

    @DeleteMapping("/producto/{codigo}")
    public Boolean delete(@PathVariable String codigo) {
        Boolean bandera = false;
        ProductoDTO productoActual = productoService.findByCodigo(codigo);
        if (productoActual != null) {
            bandera = productoService.delete(codigo);
        }
        return bandera;

    }

    @PutMapping("/productoSubastar/{codigo}")
    public Boolean productoSubastar(@RequestBody ProductoDTO producto, @PathVariable String codigo) {
        return productoService.abrirSubastaProducto(codigo);
    }

    @PutMapping("/productoNoSubastar/{codigo}")
    public Boolean productoNoSubastar(@RequestBody ProductoDTO producto, @PathVariable String codigo) {
        return productoService.cerrarSubastaProducto(codigo);
    }

    @GetMapping("/oferta/{codigo}")
    public Integer obtenerOferta(@PathVariable String codigo) {
        return productoService.consultaOfertaProducto(codigo);
    }

    @PutMapping("/ofertar/{codigo}/{valor}")
    public Boolean Ofertar(@RequestBody ProductoDTO producto, @PathVariable String codigo,
            @PathVariable Integer valor) {
        return productoService.nuevaOfertaProducto(codigo, valor);
    }

    @GetMapping("/subastados/{codigo}")
    public ProductoDTO showSubastados(@PathVariable String codigo) {
        ProductoDTO objProducto = null;
        objProducto = productoService.findByCodigoSubastado(codigo);
        return objProducto;
    }
}

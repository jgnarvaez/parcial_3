package co.edu.unicauca.distribuidos.api_rest_subasta_productos.services;

import java.util.List;
import co.edu.unicauca.distribuidos.api_rest_subasta_productos.services.DTO.ProductoDTO;

public interface IProductoService {
    public List<ProductoDTO> findAll();

    public List<ProductoDTO> findSubastados();

    public List<ProductoDTO> findNOSubastados();

    public ProductoDTO findByCodigo(String codigo);

    public ProductoDTO save(ProductoDTO producto);

    public ProductoDTO update(String codigo, ProductoDTO producto);

    public boolean delete(String codigo);

    public boolean abrirSubastaProducto(String codigo);

    public boolean cerrarSubastaProducto(String codigo);

    public boolean nuevaOfertaProducto(String codigo, Integer oferta);

    public Integer consultaOfertaProducto(String codigo);

    public ProductoDTO findByCodigoSubastado(String codigo);
}

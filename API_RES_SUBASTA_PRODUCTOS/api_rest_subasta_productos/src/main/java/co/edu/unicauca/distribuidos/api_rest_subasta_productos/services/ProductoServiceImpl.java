package co.edu.unicauca.distribuidos.api_rest_subasta_productos.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.api_rest_subasta_productos.models.ProductoEntity;
import co.edu.unicauca.distribuidos.api_rest_subasta_productos.repositories.ProductoRepository;
import co.edu.unicauca.distribuidos.api_rest_subasta_productos.services.DTO.ProductoDTO;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductoDTO> findAll() {
        List<ProductoEntity> productoEntity = this.servicioAccesoBaseDatos.findAll();
        List<ProductoDTO> productoDTO = this.modelMapper.map(productoEntity, new TypeToken<List<ProductoDTO>>() {
        }.getType());
        return productoDTO;
    }

    @Override
    public ProductoDTO findByCodigo(String codigo) {
        ProductoEntity objProductoEntity = this.servicioAccesoBaseDatos.findByCodigo(codigo);
        if (objProductoEntity == null) {
            return null;
        }
        ProductoDTO productoDTO = this.modelMapper.map(objProductoEntity, ProductoDTO.class);
        return productoDTO;
    }

    @Override
    public ProductoDTO save(ProductoDTO producto) {
        ProductoEntity productoEntity = this.modelMapper.map(producto, ProductoEntity.class);
        ProductoEntity objProductoEntity = this.servicioAccesoBaseDatos.save(productoEntity);
        ProductoDTO productoDTO = this.modelMapper.map(objProductoEntity, ProductoDTO.class);
        return productoDTO;
    }

    @Override
    public ProductoDTO update(String codigo, ProductoDTO producto) {
        ProductoEntity productoEntity = this.modelMapper.map(producto, ProductoEntity.class);
        ProductoEntity productoEntityActualizado = this.servicioAccesoBaseDatos.update(codigo, productoEntity);
        ProductoDTO productoDTO = this.modelMapper.map(productoEntityActualizado, ProductoDTO.class);
        return productoDTO;
    }

    @Override
    public boolean delete(String codigo) {
        return this.servicioAccesoBaseDatos.delete(codigo);
    }

    @Override
    public List<ProductoDTO> findSubastados() {
        List<ProductoEntity> productoEntity = this.servicioAccesoBaseDatos.findSubastados();
        List<ProductoDTO> productoDTO = this.modelMapper.map(productoEntity, new TypeToken<List<ProductoDTO>>() {
        }.getType());
        return productoDTO;
    }

    @Override
    public List<ProductoDTO> findNOSubastados() {
        List<ProductoEntity> productoEntity = this.servicioAccesoBaseDatos.findNOSubastados();
        List<ProductoDTO> productoDTO = this.modelMapper.map(productoEntity, new TypeToken<List<ProductoDTO>>() {
        }.getType());
        return productoDTO;
    }

    @Override
    public boolean abrirSubastaProducto(String codigo) {
        return this.servicioAccesoBaseDatos.abrirSubastaProducto(codigo);

    }

    @Override
    public boolean cerrarSubastaProducto(String codigo) {
        return this.servicioAccesoBaseDatos.cerrarSubastaProducto(codigo);
    }

    @Override
    public boolean nuevaOfertaProducto(String codigo, Integer oferta) {
        return this.servicioAccesoBaseDatos.NuevaOferta(codigo, oferta);
    }

    @Override
    public Integer consultaOfertaProducto(String codigo) {
        return this.servicioAccesoBaseDatos.getOferta(codigo);
    }

    @Override
    public ProductoDTO findByCodigoSubastado(String codigo) {
        ProductoEntity objProductoEntity = this.servicioAccesoBaseDatos.findByCodigoSubastado(codigo);
        if (objProductoEntity == null) {
            return null;
        }
        ProductoDTO productoDTO = this.modelMapper.map(objProductoEntity, ProductoDTO.class);
        return productoDTO;
    }

}

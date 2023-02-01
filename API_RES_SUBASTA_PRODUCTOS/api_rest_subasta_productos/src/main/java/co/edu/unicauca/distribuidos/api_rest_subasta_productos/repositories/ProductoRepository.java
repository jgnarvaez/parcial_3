package co.edu.unicauca.distribuidos.api_rest_subasta_productos.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.distribuidos.api_rest_subasta_productos.models.ProductoEntity;

@Repository
public class ProductoRepository {
    private ArrayList<ProductoEntity> listaDeProductosSubastados;
    private ArrayList<ProductoEntity> listaDeProductosNOSubastados;

    public ProductoRepository() {
        this.listaDeProductosSubastados = new ArrayList<ProductoEntity>();
        this.listaDeProductosNOSubastados = new ArrayList<ProductoEntity>();
        cargarProductos();
    }

    public List<ProductoEntity> findAll() {
        System.out.println("Invocando a listarproductos");
        ArrayList<ProductoEntity> listaProductos = new ArrayList<ProductoEntity>();
        listaProductos.addAll(listaDeProductosSubastados);
        listaProductos.addAll(listaDeProductosNOSubastados);
        return listaProductos;
    }

    public List<ProductoEntity> findSubastados() {
        System.out.println("Invocando a listarsubastados");
        return this.listaDeProductosSubastados;
    }

    public List<ProductoEntity> findNOSubastados() {
        System.out.println("Invocando a listarnosubastados");
        return this.listaDeProductosNOSubastados;
    }

    public ProductoEntity findByCodigo(String codigo) {
        System.out.println("Invocando a consultar un producto");
        ProductoEntity objProducto = null;

        ArrayList<ProductoEntity> listaProductos = new ArrayList<ProductoEntity>();
        listaProductos.addAll(listaDeProductosSubastados);
        listaProductos.addAll(listaDeProductosNOSubastados);

        for (ProductoEntity producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                objProducto = producto;
                break;
            }
        }

        return objProducto;
    }

    public ProductoEntity save(ProductoEntity producto) {
        System.out.println("Invocando a almacenar producto");
        ProductoEntity objProducto = null;
        if (this.listaDeProductosNOSubastados.add(producto)) {
            objProducto = producto;
        }

        return objProducto;
    }

    public ProductoEntity update(String codigo, ProductoEntity producto) {
        System.out.println("Invocando a actualizar un producto");
        ProductoEntity objProducto = null;

        for (int i = 0; i < this.listaDeProductosNOSubastados.size(); i++) {
            if (this.listaDeProductosNOSubastados.get(i).getCodigo().equals(codigo)) {
                this.listaDeProductosNOSubastados.set(i, producto);
                objProducto = producto;
                return objProducto;
            }
        }

        for (int i = 0; i < this.listaDeProductosSubastados.size(); i++) {
            if (this.listaDeProductosSubastados.get(i).getCodigo().equals(codigo)) {
                this.listaDeProductosSubastados.set(i, producto);
                objProducto = producto;
                break;
            }
        }

        return objProducto;
    }

    public boolean delete(String codigo) {
        System.out.println("Invocando a eliminar un producto");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeProductosNOSubastados.size(); i++) {
            if (this.listaDeProductosNOSubastados.get(i).getCodigo().equals(codigo)) {
                this.listaDeProductosNOSubastados.remove(i);
                bandera = true;
                return bandera;
            }
        }

        for (int i = 0; i < this.listaDeProductosSubastados.size(); i++) {
            if (this.listaDeProductosSubastados.get(i).getCodigo().equals(codigo)) {
                this.listaDeProductosSubastados.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    private void cargarProductos() {
        ProductoEntity objProducto1 = new ProductoEntity("AAA111", "Monalisa", 500000000);
        this.listaDeProductosNOSubastados.add(objProducto1);
        ProductoEntity objProducto2 = new ProductoEntity("BBB222", "Lampara", 2000000);
        this.listaDeProductosSubastados.add(objProducto2);
        ProductoEntity objProducto3 = new ProductoEntity("CCC333", "Portatil", 4500000);
        this.listaDeProductosSubastados.add(objProducto3);
        ProductoEntity objProducto4 = new ProductoEntity("DDD444", "Mansion", 200000000);
        this.listaDeProductosNOSubastados.add(objProducto4);
    }
}

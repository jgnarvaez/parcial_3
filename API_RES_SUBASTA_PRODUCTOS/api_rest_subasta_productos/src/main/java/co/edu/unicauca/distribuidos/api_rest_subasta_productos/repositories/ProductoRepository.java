package co.edu.unicauca.distribuidos.api_rest_subasta_productos.repositories;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.distribuidos.api_rest_subasta_productos.models.ProductoEntity;

@Repository
public class ProductoRepository {
    private ArrayList<ProductoEntity> listaDeProductosSubastados;
    private ArrayList<ProductoEntity> listaDeProductosNOSubastados;
    Hashtable<String, Integer> ofetasProductos = new Hashtable<String, Integer>();
 

    public ProductoRepository() {
        this.listaDeProductosSubastados = new ArrayList<ProductoEntity>();
        this.listaDeProductosNOSubastados = new ArrayList<ProductoEntity>();
        cargarProductos();
        
    }
//////////////////////////////////
/////Funciones para OFETAS
//////////////////////////////////
    public Integer getOferta(String codigo) {
        System.out.println("Invocando consultar oferta de producto ");
        if (ofetasProductos.containsKey(codigo)){
            System.out.println("si hay oferta ");
            return ofetasProductos.get(codigo);
        }
        System.out.println("no hay oferta ");
        return 0;
    }
    public boolean NuevaOferta(String codigo,Integer oferta) {
        System.out.println("Invocando a dar oferta de producto ");
        boolean bandera=false;
        if(this.findByCodigoSubastados(codigo)!=null){//< busca el codigo en los productos subastados
            return this.modificarOferta(codigo, oferta);
        }
        System.out.println("producto no ofrecido en la subasta");
        return bandera;
    }
    private boolean modificarOferta(String codigo,Integer oferta) {
        boolean bandera=false;
        if (ofetasProductos.containsKey(codigo)){
            System.out.println("el prodcto ya posee oferta(s)");
            if(oferta>ofetasProductos.get(codigo)){
                System.out.println("Se ha creado la oferta");
                ofetasProductos.put(codigo, oferta);
                System.out.println(ofetasProductos.get(codigo));
                System.out.println(ofetasProductos.containsKey(codigo));
                bandera=true;
            }
        }else{
            System.out.println("Se ha creado la oferta");
            ofetasProductos.put(codigo, oferta);
            //System.out.println(ofetasProductos.get(codigo));
            //System.out.println(ofetasProductos.containsKey(codigo));
            bandera=true;
        }
        return bandera;
    }



//////////////////////////////////
/////Funciones para cambiar elementos subastados
//////////////////////////////////
    public boolean abrirSubastaProducto(String codigo) {
        System.out.println("Invocando a subastar el producto ");
        ProductoEntity objProducto = this.findByCodigo(codigo);///< crea un objeto que almacena el elemento temporalmente
        boolean bandera=false;
        if(this.deleteNoSubastados(codigo)){///<intentamos elminimar de los no subastados
            this.saveSubastados(objProducto);
            bandera=true;///<se ha agregado a elementos subastados
        }
        return bandera;
    }
    
    public boolean cerrarSubastaProducto(String codigo) {
        System.out.println("Invocando a quitar de la subasta el producto ");
        ProductoEntity objProducto = this.findByCodigo(codigo);///<crea un objeto que almacena el elemento temporalmente
        boolean bandera=false;
        if(this.deleteSubatados(codigo)){///<intentamos elminimar de los  subastados
            this.saveNoSubastados(objProducto);
            bandera=true;////< se ha agregado a elementos no subastados
        }
        return bandera;        
    }

//////////////////////////////////
/////Funciones para hallar un  elemento
//////////////////////////////////
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
    public ProductoEntity findByCodigoSubastados(String codigo) {
        System.out.println("Invocando a consultar un producto Subastado");
        ProductoEntity objProducto = null;
        for (ProductoEntity producto : listaDeProductosSubastados) {
            if (producto.getCodigo().equals(codigo)) {
                objProducto = producto;
                break;
            }
        }
        return objProducto;
    }public ProductoEntity findByCodigoNoSubastados(String codigo) {
        System.out.println("Invocando a consultar un producto NO Subastado");
        ProductoEntity objProducto = null;
        for (ProductoEntity producto : listaDeProductosNOSubastados) {
            if (producto.getCodigo().equals(codigo)) {
                objProducto = producto;
                break;
            }
        }
        return objProducto;
    }

//////////////////////////////////
/////Funciones para almacenar un  elemento
//////////////////////////////////
    public ProductoEntity save(ProductoEntity producto) {
        System.out.println("Invocando a almacenar producto");
        return this.saveNoSubastados(producto);
    }
    public ProductoEntity saveSubastados(ProductoEntity producto) {
        System.out.println("Invocando a almacenar producto en Subastados");
        ProductoEntity objProducto = null;
        if (this.listaDeProductosSubastados.add(producto)) {
            objProducto = producto;
        }

        return objProducto;
    }
    public ProductoEntity saveNoSubastados(ProductoEntity producto) {
        System.out.println("Invocando a almacenar producto en No Subastados");
        ProductoEntity objProducto = null;
        if (this.listaDeProductosNOSubastados.add(producto)) {
            objProducto = producto;
        }
        return objProducto;
    }

//////////////////////////////////
/////Funciones para actualizar un  elemento
//////////////////////////////////
    public ProductoEntity update(String codigo, ProductoEntity producto) {
        System.out.println("Invocando a actualizar un producto");
        ProductoEntity objProducto = null;
        objProducto=this.updateNoSubastados(codigo, producto);
        if (objProducto==null){
            System.out.println("  No se encontro en productos no subastados");
            objProducto=this.updateSubastados(codigo, producto);
        }
        return objProducto;
    }
    public ProductoEntity updateSubastados(String codigo, ProductoEntity producto) {
        System.out.println("Invocando a actualizar un producto Subastado");
        ProductoEntity objProducto = null;
        for (int i = 0; i < this.listaDeProductosSubastados.size(); i++) {
            if (this.listaDeProductosSubastados.get(i).getCodigo().equals(codigo)) {
                this.listaDeProductosSubastados.set(i, producto);
                objProducto = producto;
                break;
            }
        }
        return objProducto;
    }
    public ProductoEntity updateNoSubastados(String codigo, ProductoEntity producto) {
        System.out.println("Invocando a actualizar un producto No Subastado");
        ProductoEntity objProducto = null;

        for (int i = 0; i < this.listaDeProductosNOSubastados.size(); i++) {
            if (this.listaDeProductosNOSubastados.get(i).getCodigo().equals(codigo)) {
                this.listaDeProductosNOSubastados.set(i, producto);
                objProducto = producto;
                break;
            }
        }
        return objProducto;
    }

//////////////////////////////////
/////Funciones para eliminar un  elemento
//////////////////////////////////
    public boolean delete(String codigo) {
        System.out.println("Invocando a eliminar un producto");
        boolean bandera = false;
        bandera=this.deleteNoSubastados(codigo);
        if(!bandera){
            System.out.println("  No se encontro en productos no subastados");
            bandera=this.deleteSubatados(codigo);
        }
        return bandera;
    }
    public boolean deleteSubatados(String codigo) {
        System.out.println("Invocando a eliminar un producto Subastado");
        boolean bandera = false;
        for (int i = 0; i < this.listaDeProductosSubastados.size(); i++) {
            if (this.listaDeProductosSubastados.get(i).getCodigo().equals(codigo)) {
                this.listaDeProductosSubastados.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;    }
     public boolean deleteNoSubastados(String codigo) {
        System.out.println("Invocando a eliminar un producto No Subastado");
        boolean bandera = false;
        for (int i = 0; i < this.listaDeProductosNOSubastados.size(); i++) {
            if (this.listaDeProductosNOSubastados.get(i).getCodigo().equals(codigo)) {
                this.listaDeProductosNOSubastados.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

//////////////////////////////////
/////Datos quemados
//////////////////////////////////
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

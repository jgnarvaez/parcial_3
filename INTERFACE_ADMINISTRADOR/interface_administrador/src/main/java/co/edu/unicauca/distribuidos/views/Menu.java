package co.edu.unicauca.distribuidos.views;

import co.edu.unicauca.distribuidos.models.*;
import co.edu.unicauca.distribuidos.services.*;

public class Menu {

    public static void main(String[] args) {

        UsuarioServices objAdminServices = new UsuarioServices();

        AdminDTO objAdmin = new AdminDTO("Daniel", "Paz", "dpaz", "123");

        System.out.println("\n registrar un administrador");
        AdminDTO objAdminRegistrado = objAdminServices.registrarAdmin(objAdmin);
        System.out.println(objAdminRegistrado.toString());

        /*
         * System.out.println("\n listando clientes que contiene el cliente eliminado");
         * List<Cliente> listaDeClientes = objClienteServices.listarClientes();
         * 
         * for (Cliente cliente : listaDeClientes) {
         * imprimirCliente(cliente);
         * }
         */

    }

}

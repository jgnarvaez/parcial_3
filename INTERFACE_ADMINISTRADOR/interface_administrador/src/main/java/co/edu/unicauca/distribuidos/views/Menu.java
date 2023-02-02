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

        ClienteDTO objCliente = new ClienteDTO("Daniel2", "Paz2", "dpaz2","asdfadf","dpaz2", "1234");

        System.out.println("\n registrar un Cliente");
        ClienteDTO objClienteRegistrado = objAdminServices.registrarCliente(objCliente);
        System.out.println(objClienteRegistrado.toString());


        System.out.println("\n log Usuario");
        DatosLoginDTO datos=  new DatosLoginDTO( "cjaneth","123");
        Object usuarioRecuperado = objAdminServices.ingresar(datos);
        System.out.println(usuarioRecuperado.toString());

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

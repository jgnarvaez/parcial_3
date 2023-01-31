package co.edu.unicauca.distribuidos.parcial3.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.distribuidos.parcial3.models.ClienteEntity;;

@Repository
public class ClienteRepository {
    private ArrayList<ClienteEntity> listaDeClientes;

    public ClienteRepository() {
        this.listaDeClientes = new ArrayList<ClienteEntity>();
        cargarClientes();
    }

    public List<ClienteEntity> findAll() {
        System.out.println("Invocando a listar clientes");
        return this.listaDeClientes;
    }

    public ClienteEntity findByLogin(String login) {
        System.out.println("Invocando a consultar un clientes");
        ClienteEntity objAdmin = null;

        for (ClienteEntity cliente : listaDeClientes) {
            if (cliente.getLogin().equals(login)) {
                objAdmin = cliente;
                break;
            }
        }

        return objAdmin;
    }

    public ClienteEntity save(ClienteEntity cliente) {
        System.out.println("Invocando a almacenar cliente");
        ClienteEntity objCliente = null;
        if (this.listaDeClientes.add(cliente)) {
            objCliente = cliente;
        }

        return objCliente;
    }

    public ClienteEntity update(String login, ClienteEntity cliente) {
        System.out.println("Invocando a actualizar un cliente");
        ClienteEntity objCliente = null;

        for (int i = 0; i < this.listaDeClientes.size(); i++) {
            if (this.listaDeClientes.get(i).getLogin().equals(login)) {
                this.listaDeClientes.set(i, cliente);
                objCliente = cliente;
                break;
            }
        }

        return objCliente;
    }

    public boolean delete(String login) {
        System.out.println("Invocando a eliminar un cliente");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeClientes.size(); i++) {
            if (this.listaDeClientes.get(i).getLogin().equals(login)) {
                this.listaDeClientes.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    private void cargarClientes() {
        ClienteEntity objAdmin1 = new ClienteEntity("Janeth", "Cifuentes","email1","1234567", "cjaneth", "12345");
        this.listaDeClientes.add(objAdmin1);
        ClienteEntity objAdmin2 = new ClienteEntity("Jose", "Narvaez","email2","1111222333", "jgnarvaez", "67890");
        this.listaDeClientes.add(objAdmin2);
    }
}

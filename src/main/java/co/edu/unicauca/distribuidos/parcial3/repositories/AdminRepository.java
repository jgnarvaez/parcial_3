package co.edu.unicauca.distribuidos.parcial3.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.distribuidos.parcial3.models.AdminEntity;;

@Repository
public class AdminRepository {
    private ArrayList<AdminEntity> listaDeAdmin;

    public AdminRepository() {
        this.listaDeAdmin = new ArrayList<AdminEntity>();
        cargarClientes();
    }

    public List<AdminEntity> findAll() {
        System.out.println("Invocando a listaradmin");
        return this.listaDeAdmin;
    }

    public AdminEntity findByLogin(String login) {
        System.out.println("Invocando a consultar un admin");
        AdminEntity objAdmin = null;

        for (AdminEntity admin : listaDeAdmin) {
            if (admin.getLogin().equals(login)) {
                objAdmin = admin;
                break;
            }
        }

        return objAdmin;
    }

    public AdminEntity save(AdminEntity admin) {
        System.out.println("Invocando a almacenar admin");
        AdminEntity objAdmin = null;
        if (this.listaDeAdmin.add(admin)) {
            objAdmin = admin;
        }

        return objAdmin;
    }

    public AdminEntity update(String login, AdminEntity admin) {
        System.out.println("Invocando a actualizar un admin");
        AdminEntity objAdmin = null;

        for (int i = 0; i < this.listaDeAdmin.size(); i++) {
            if (this.listaDeAdmin.get(i).getLogin().equals(login)) {
                this.listaDeAdmin.set(i, admin);
                objAdmin = admin;
                break;
            }
        }

        return objAdmin;
    }

    public boolean delete(String login) {
        System.out.println("Invocando a eliminar un admin");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeAdmin.size(); i++) {
            if (this.listaDeAdmin.get(i).getLogin().equals(login)) {
                this.listaDeAdmin.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    private void cargarClientes() {
        AdminEntity objAdmin1 = new AdminEntity("Janeth", "Cifuentes", "cjaneth", "12345");
        this.listaDeAdmin.add(objAdmin1);
        AdminEntity objAdmin2 = new AdminEntity("Jose", "Narvaez", "jgnarvaez", "67890");
        this.listaDeAdmin.add(objAdmin2);
    }
}

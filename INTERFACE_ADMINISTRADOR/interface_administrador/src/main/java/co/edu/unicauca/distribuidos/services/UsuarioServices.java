package co.edu.unicauca.distribuidos.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

import co.edu.unicauca.distribuidos.models.*;

public class UsuarioServices {
    private String endPoint;
    private Client objClientePeticiones;

    public UsuarioServices() {
        this.endPoint = "http://localhost:5000/api/admin";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public ClienteDTO registrarCliente(ClienteDTO objClienteRegistar) {
        ClienteDTO objCliente = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint);

        Entity<ClienteDTO> data = Entity.entity(objClienteRegistar, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objCliente = objPeticion.post(data, ClienteDTO.class);

        return objCliente;
    }

    public AdminDTO registrarAdmin(AdminDTO objClienteRegistar) {
        AdminDTO objAdmin = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint);

        Entity<AdminDTO> data = Entity.entity(objClienteRegistar, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objAdmin = objPeticion.post(data, AdminDTO.class);

        return objAdmin;
    }

}

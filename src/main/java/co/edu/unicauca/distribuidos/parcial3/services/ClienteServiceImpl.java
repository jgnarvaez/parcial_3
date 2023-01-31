package co.edu.unicauca.distribuidos.parcial3.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.parcial3.models.ClienteEntity;
import co.edu.unicauca.distribuidos.parcial3.repositories.ClienteRepository;
import co.edu.unicauca.distribuidos.parcial3.services.DTO.ClienteDTO;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ClienteDTO> findAll() {
        List<ClienteEntity> ClienteEntity = this.servicioAccesoBaseDatos.findAll();
        List<ClienteDTO> ClienteDTO = this.modelMapper.map(ClienteEntity, new TypeToken<List<ClienteDTO>>() {
        }.getType());
        return ClienteDTO;
    }

    @Override
    public ClienteDTO findByLogin(String login) {
        ClienteEntity objClienteEntity = this.servicioAccesoBaseDatos.findByLogin(login);
        ClienteDTO clienteDTO = this.modelMapper.map(objClienteEntity, ClienteDTO.class);
        return clienteDTO;
    }

    @Override
    public ClienteDTO save(ClienteDTO cliente) {
        ClienteEntity clienteEntity = this.modelMapper.map(cliente, ClienteEntity.class);
        ClienteEntity objClienteEntity = this.servicioAccesoBaseDatos.save(clienteEntity);
        ClienteDTO clienteDTO = this.modelMapper.map(objClienteEntity, ClienteDTO.class);
        return clienteDTO;
    }

    @Override
    public ClienteDTO update(String login, ClienteDTO cliente) {
        ClienteEntity clienteEntity = this.modelMapper.map(cliente, ClienteEntity.class);
        ClienteEntity clienteEntityActualizado = this.servicioAccesoBaseDatos.update(login, clienteEntity);
        ClienteDTO clienteDTO = this.modelMapper.map(clienteEntityActualizado, ClienteDTO.class);
        return clienteDTO;
    }

    @Override
    public boolean delete(String login) {
        return this.servicioAccesoBaseDatos.delete(login);
    }


}

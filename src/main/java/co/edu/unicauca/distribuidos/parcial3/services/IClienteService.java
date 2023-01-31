package co.edu.unicauca.distribuidos.parcial3.services;

import java.util.List;
import co.edu.unicauca.distribuidos.parcial3.services.DTO.ClienteDTO;

public interface IClienteService {
    public List<ClienteDTO> findAll();

    public ClienteDTO findByLogin(String login);

    public ClienteDTO save(ClienteDTO cliente);

    public ClienteDTO update(String login, ClienteDTO cliente);

    public boolean delete(String login);
}

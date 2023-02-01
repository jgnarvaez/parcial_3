package co.edu.unicauca.distribuidos.parcial3.services;

import java.util.List;
import co.edu.unicauca.distribuidos.parcial3.services.DTO.AdminDTO;
import co.edu.unicauca.distribuidos.parcial3.services.DTO.DatosLoginDTO;

public interface IAdminService {
    public List<AdminDTO> findAll();

    public AdminDTO findByLogin(String login);

    public AdminDTO findByLoginPassword(DatosLoginDTO loginPassword);

    public AdminDTO save(AdminDTO admin);

    public AdminDTO update(String login, AdminDTO admin);

    public boolean delete(String login);
}

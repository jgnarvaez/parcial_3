package co.edu.unicauca.distribuidos.parcial3.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.parcial3.models.AdminEntity;
import co.edu.unicauca.distribuidos.parcial3.repositories.AdminRepository;
import co.edu.unicauca.distribuidos.parcial3.services.DTO.AdminDTO;
import co.edu.unicauca.distribuidos.parcial3.services.DTO.DatosLoginDTO;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AdminDTO> findAll() {
        List<AdminEntity> adminEntity = this.servicioAccesoBaseDatos.findAll();
        List<AdminDTO> adminDTO = this.modelMapper.map(adminEntity, new TypeToken<List<AdminDTO>>() {
        }.getType());
        return adminDTO;
    }

    @Override
    public AdminDTO findByLogin(String login) {
        AdminEntity objAdminEntity = this.servicioAccesoBaseDatos.findByLogin(login);
        if (objAdminEntity==null){
            return null;
        }
        AdminDTO adminDTO = this.modelMapper.map(objAdminEntity, AdminDTO.class);
        return adminDTO;
    }

    @Override
    public AdminDTO findByLoginPassword(DatosLoginDTO loginPassword) {
        AdminEntity objAdminEntity = this.servicioAccesoBaseDatos.findByLoginPassword(loginPassword);
        if (objAdminEntity==null){
            return null;
        }
        AdminDTO adminDTO = this.modelMapper.map(objAdminEntity, AdminDTO.class);
        return adminDTO;
    }


    @Override
    public AdminDTO save(AdminDTO admin) {
        AdminEntity adminEntity = this.modelMapper.map(admin, AdminEntity.class);
        AdminEntity objAdminEntity = this.servicioAccesoBaseDatos.save(adminEntity);
        AdminDTO adminDTO = this.modelMapper.map(objAdminEntity, AdminDTO.class);
        return adminDTO;
    }

    @Override
    public AdminDTO update(String login, AdminDTO admin) {
        AdminEntity adminEntity = this.modelMapper.map(admin, AdminEntity.class);
        AdminEntity adminEntityActualizado = this.servicioAccesoBaseDatos.update(login, adminEntity);
        AdminDTO adminDTO = this.modelMapper.map(adminEntityActualizado, AdminDTO.class);
        return adminDTO;
    }

    @Override
    public boolean delete(String login) {
        return this.servicioAccesoBaseDatos.delete(login);
    }

}

package dgtic.core.service.Cliente;

import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.ClienteDTO;
import dgtic.core.model.entity.Cliente;
import dgtic.core.repository.usuarios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream().map(Mapper::toClienteDTO).toList();
    }

    @Override
    public List<ClienteDTO> obtenerTodos() {
        return List.of();
    }

    @Override
    public ClienteDTO findById(Long id) {
        return null;
    }

    @Override
    public ClienteDTO guardar(ClienteDTO clienteDTO) {
        Cliente cliente = null;
        if(clienteDTO.getIdCliente()==null){
            cliente=Cliente.builder()
                    .nombre(clienteDTO.getNombre())
                    .segundoNombre(clienteDTO.getSegundonombre())
                    .apellido_paterno(clienteDTO.getApellidoPaterno())
                    .apellido_materno(clienteDTO.getApellidoMaterno())
                    .fnac(clienteDTO.getFechaNacimiento())
                    .genero(clienteDTO.getGenero())
                    .numero(clienteDTO.getNumero())
                    .correo(clienteDTO.getCorreo())
                    .build();

        }else{
            cliente = Cliente.builder()
                    .id(clienteDTO.getIdCliente())
                    .nombre(clienteDTO.getNombre())
                    .segundoNombre(clienteDTO.getSegundonombre())
                    .apellido_paterno(clienteDTO.getApellidoPaterno())
                    .apellido_materno(clienteDTO.getApellidoMaterno())
                    .fnac(clienteDTO.getFechaNacimiento())
                    .genero(clienteDTO.getGenero())
                    .numero(clienteDTO.getNumero())
                    .correo(clienteDTO.getCorreo())
                    .build();
        }
        Cliente guardado = clienteRepository.save(cliente);
        return Mapper.toClienteDTO(guardado);
    }

    @Override
    public Cliente deleteById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No se encontro el cliente con el id: " + id));
        clienteRepository.delete(cliente);
        return cliente;
    }
}

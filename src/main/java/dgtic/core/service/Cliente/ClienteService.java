package dgtic.core.service.Cliente;

import dgtic.core.model.dto.ClienteDTO;
import dgtic.core.model.entity.Cliente;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> findAll();
    List<ClienteDTO> obtenerTodos();
    ClienteDTO findById(Long id);
    ClienteDTO guardar(ClienteDTO clienteDTO);
    Cliente deleteById(Long id);
}

package dgtic.core.security.service;

import dgtic.core.model.entity.Asesor;
import dgtic.core.repository.usuarios.AsesorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AsesorRepository asesorRepository;

    public UserDetailsServiceImpl(AsesorRepository asesorRepository) {
        this.asesorRepository = asesorRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Security - UserDetailsServiceImpl.loadUserByUsername {}", username);
        Asesor asesor = asesorRepository.findByUsuario(username).orElseThrow(()->new RuntimeException("El Asesor no esta dado de alta en el sistema"));
        return User.builder()
                .username(asesor.getUsuario())
                .password(asesor.getPassword())
                .roles("Asesor")
                .disabled(!asesor.isActivo())
                .build();
    }
}

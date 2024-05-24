package com.bdcuadernillo2.SGNC.service;

import com.bdcuadernillo2.SGNC.domain.Roles;
import com.bdcuadernillo2.SGNC.domain.User;
import com.bdcuadernillo2.SGNC.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca el usuario en el repositorio por nombre de usuario
        User user = userRepository.findByUsername(username);

        // Si el usuario no existe, lanza una excepción
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Conjunto de autoridades otorgadas al usuario
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        // Recorre los roles del usuario y añade cada rol como una autoridad
        for (Roles role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        // Devuelve una instancia de org.springframework.security.core.userdetails.User
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}

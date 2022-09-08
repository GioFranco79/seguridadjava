package com.edutecno.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edutecno.model.Users;

@Service
public class UserDetailsServiceImp  implements UserDetailsService {
	@Autowired
	private UserService userServ;
	
	@Override   
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
 
        Users usuario = userServ.findUsersByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException(email);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(usuario.getRole().toString()));
        return new User(usuario.getUsername(), usuario.getPassword(), authorities);
    }

}

package com.yassine.lafryhi.jee.seance8.security.services;

import com.yassine.lafryhi.jee.seance8.security.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private SecurityService securityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = securityService.loadUserByUsername(username);

        /*
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        appUser.getRoles().forEach( appRole -> {
                authorities.add( new SimpleGrantedAuthority( appRole.getRoleName() ) );
            }
        );
         */

        Collection<GrantedAuthority> authorities = appUser.getRoles().stream().map(
                appRole -> new SimpleGrantedAuthority(appRole.getRoleName())
        ).collect(Collectors.toList());

        return new User(appUser.getUsername(), appUser.getPassword(), authorities);
    }
}

package com.mercadolibre.bootcamp.projeto_integrador.authentication.security;

import com.mercadolibre.bootcamp.projeto_integrador.model.Buyer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BuyerPrincipal implements UserDetails {

    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public BuyerPrincipal(Buyer buyer) {
        this.username = buyer.getUsername();
        this.password = buyer.getPassword();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority("ROLE_USER");

        authorities.add(userAuthority);

        this.authorities = authorities;
    }

    public static BuyerPrincipal create(Buyer buyer) {
        return new BuyerPrincipal(buyer);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

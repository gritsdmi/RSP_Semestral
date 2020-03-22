package cz.cvut.fel.rsp.tripguide.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, DELEGATE, TOURIST;

    @Override
    public String getAuthority() {
        return name();
    }
}
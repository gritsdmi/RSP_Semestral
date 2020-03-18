package cz.cvut.fel.rsp.tripguide.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER1, USER2, USER3;

    @Override
    public String getAuthority() {
        return name();
    }
}
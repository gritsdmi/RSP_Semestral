package cz.cvut.fel.rsp.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Tomen
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAllUsers", query = "SELECT e FROM User e")
public class User extends AbstractEntity implements UserDetails {

    @NotNull
    private String username;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;

    private String phoneNumber;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonIgnore
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "userid"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private Set<Event> events = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Message> messages = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "tourist")
    private Set<Incident> incidents = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private Set<Tour> tours = new HashSet<>();

    @JsonIgnore
    @OneToOne(mappedBy = "delegate")
    private Tour tourToDelegate;

    @NotNull
    private String fullName;

    private boolean active;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
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
        return false;
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
        return isActive();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Set<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(Set<Incident> incidents) {
        this.incidents = incidents;
    }

    public Set<Tour> getTours() {
        return tours;
    }

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

    public void addTour(Tour t) {
        this.tours.add(t);
    }

    public Tour getTourToDelegate() {
        return tourToDelegate;
    }

    public void setTourToDelegate(Tour tourToDelegate) {
        this.tourToDelegate = tourToDelegate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return active == user.active &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(events, user.events) &&
                Objects.equals(messages, user.messages) &&
                Objects.equals(incidents, user.incidents) &&
                Objects.equals(tourToDelegate, user.tourToDelegate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, password, phoneNumber, roles, active);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", roles=" + roles +
                ", active=" + active +
                '}';
    }

    public boolean isAdmin() {
        return getAuthorities().contains(Role.ADMIN);
    }

    public boolean isDelegate() {
        return getAuthorities().contains(Role.DELEGATE);
    }

    public boolean isTourist() {
        return getAuthorities().contains(Role.TOURIST);
    }
}


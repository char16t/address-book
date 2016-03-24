package com.vmanenkov.addressbook.model.user;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany
    @JoinTable(name="user_role", joinColumns = {
            @JoinColumn(name = "role_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<User> userset;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUser() {
        return userset;
    }

    public void setUser(Set<User> user) {
        this.userset = user;
    }
}

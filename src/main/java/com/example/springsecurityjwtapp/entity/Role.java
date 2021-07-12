package com.example.springsecurityjwtapp.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "roles")
public class Role extends BaseEntity {

    private String name;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
    private List<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;

        return Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return 1179619963;
    }
}

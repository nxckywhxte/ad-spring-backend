package ru.nw.ad.spring.backend;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id
    private UUID id;

    @Column()
    private String username;

    @Column()
    private String email;

    @Column(name = "hashed_password")
    private String hashedPassword;

    @ManyToOne(targetEntity = RoleEntity.class)
    private RoleEntity role;
}

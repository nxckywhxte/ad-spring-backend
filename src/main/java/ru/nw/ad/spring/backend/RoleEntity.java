package ru.nw.ad.spring.backend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RoleEntity {
    @Id
    private UUID id;

    @Column()
    private String name;

}

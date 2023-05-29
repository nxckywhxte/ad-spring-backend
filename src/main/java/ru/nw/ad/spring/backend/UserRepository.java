package ru.nw.ad.spring.backend;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}

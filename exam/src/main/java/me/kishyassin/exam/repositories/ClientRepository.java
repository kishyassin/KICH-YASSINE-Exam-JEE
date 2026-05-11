package me.kishyassin.exam.repositories;

import me.kishyassin.exam.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

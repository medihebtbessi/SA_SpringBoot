package tech.chillo.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.chillo.sa.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByEmail(String email);

}

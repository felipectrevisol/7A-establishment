package br.com.sev7aura.establishment;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoEstablishmentTable extends JpaRepository<Establishment, UUID> {
    List<Establishment> findByFantasyName(String fantasyName);
}
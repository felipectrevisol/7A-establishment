package br.com.sev7aura.establishment;

import java.util.UUID;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoRepository extends JpaRepository<Establishment, UUID> {
    List<Establishment> findByFantasyName(String fantasyName);
}
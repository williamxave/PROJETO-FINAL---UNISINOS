package br.com.xavero.projetofinal.repositories.hour;

import br.com.xavero.projetofinal.domain.Hour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HourRepository extends JpaRepository<Hour, Long> {

    Optional<Hour> findHourByExternalId(UUID externalId);

}

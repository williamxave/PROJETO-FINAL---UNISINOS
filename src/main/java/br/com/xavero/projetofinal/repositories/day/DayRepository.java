package br.com.xavero.projetofinal.repositories.day;

import br.com.xavero.projetofinal.domain.Day;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

    Optional<Day> findDayByExternalId(UUID externalId);
    Page<Day> findAll(Pageable pageable);

}

package br.ifpe.web2missao1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalEventoDAO extends JpaRepository<LocalEvento, Integer> {

}

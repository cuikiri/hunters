package br.com.jhisolution.user.hunters.repository;

import br.com.jhisolution.user.hunters.domain.Documento;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Documento entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {}

package Gestion.RendezVousEnLigne.Repositories;

import Gestion.RendezVousEnLigne.Entities.Malades;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaladeRepositories extends JpaRepository<Malades,Long> {
    Page<Malades> findByNomContains(String kw, Pageable pageable);
}

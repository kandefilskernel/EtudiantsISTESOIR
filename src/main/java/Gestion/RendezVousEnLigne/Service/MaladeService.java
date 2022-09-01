package Gestion.RendezVousEnLigne.Service;

import Gestion.RendezVousEnLigne.Entities.Malades;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MaladeService {
    List<Malades>getAllMalades();
    void saveMalade(Malades malades);
    Malades getMaladesById(long id);
    void deleteMaladeById(long id);
    Page<Malades>findPaginated(int pageN, int sizeN);

}

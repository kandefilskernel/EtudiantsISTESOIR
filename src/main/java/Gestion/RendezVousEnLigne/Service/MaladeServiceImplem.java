package Gestion.RendezVousEnLigne.Service;

import Gestion.RendezVousEnLigne.Entities.Malades;
import Gestion.RendezVousEnLigne.Repositories.MaladeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaladeServiceImplem implements MaladeService{
    @Autowired
    private MaladeRepositories maladeRepositories;
    @Override
    public List<Malades> getAllMalades() {
        return maladeRepositories.findAll();
    }

    @Override
    public void saveMalade(Malades malades) {
        this.maladeRepositories.save(malades);
    }

    @Override
    public Malades getMaladesById(long id) {
        Optional<Malades> optional=maladeRepositories.findById(id);
        Malades malades=null;
        if(optional.isPresent())
        {
           malades=optional.get();
        }
        else
        {
            throw new RuntimeException("L'Id du malade non trouvé ::"+id);
        }
        return malades;
    }

    @Override
    public void deleteMaladeById(long id) {
        this.maladeRepositories.deleteById(id);
    }

    @Override
    public Page<Malades> findPaginated(int pageN, int sizeN) {
        Pageable pageable = PageRequest.of(pageN-1,sizeN);
        return this.maladeRepositories.findAll(pageable);
    }
}
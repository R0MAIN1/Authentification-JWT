package chillo.tech.avis.service;


import chillo.tech.avis.Repository.AvisRepository;
import chillo.tech.avis.entite.Avis;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AvisService {

        private final AvisRepository avisRepository;
    public void creer(Avis avis){
        this.avisRepository.save(avis);
    }

}

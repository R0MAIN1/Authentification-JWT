package chillo.tech.avis.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import chillo.tech.avis.entite.Avis;

@Repository
public interface AvisRepository extends CrudRepository<Avis, Integer>{

}

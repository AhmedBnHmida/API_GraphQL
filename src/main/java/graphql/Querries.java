package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.RendezVous;
import repository.RendezVousRepository;

import java.util.List;

public class Querries implements GraphQLRootResolver {

    public RendezVousRepository rdvRepo;
    public Querries(RendezVousRepository rdvRepo) {
        this.rdvRepo = rdvRepo;
    }

    public List<RendezVous> listRendezVous(){
        return rdvRepo.getListeRendezVous();
    }
}

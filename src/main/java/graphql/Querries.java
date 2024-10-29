package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Querries implements GraphQLRootResolver {

    public RendezVousRepository rdvRepo;
    private LogementRepository logRepo;
    public Querries(RendezVousRepository rdvRepo,LogementRepository logRepo) {

        this.logRepo = logRepo;
        this.rdvRepo = rdvRepo;
    }

    public List<RendezVous> listRendezVous(){
        return rdvRepo.getListeRendezVous();
    }

    public List<RendezVous> getListeRendezVousByLogementRef(int reference) {
        return rdvRepo.getListeRendezVousByLogementRef(reference);
    }
    public  RendezVous rendezVousById(int id){
        return  rdvRepo.getRendezVousById(id);
    }

    /****************************************-LOGEMENT-***********************************************/

    public List<Logement> listLogements(){return logRepo.getAllLogements();}

    public Logement getLogementsByRef(int reference) {
        return logRepo.getLogementsByReference(reference);
    }
    public List<Logement> getLogementsByType(Logement.Type type){
        return logRepo.getLogementsByType(type);
    }
}

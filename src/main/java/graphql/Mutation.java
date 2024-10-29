package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;
import java.util.Set;

public class Mutation implements GraphQLRootResolver {
    public RendezVousRepository rdv;
    private LogementRepository logementRepository;

    public Mutation(RendezVousRepository rdv, LogementRepository logementRepository) {
        this.rdv = rdv;
        this.logementRepository = logementRepository;
    }

    public RendezVous createRendezVous(int id, String date, String heure, int refLog,String num){
        Logement l=logementRepository.getLogementsByReference(refLog);
        RendezVous r=new RendezVous(id,date,heure,l,num);
       rdv.addRendezVous(r);
           return r;

   }
   public String updateRendezVous(int id, String date, String heure,String numTel){
       Logement l=logementRepository.getLogementsByReference(id);
        RendezVous r=new RendezVous( id, date, heure,l, numTel);
        if(rdv.updateRendezVous(r))
            return "succes";
            return "echec";

   }
    public boolean deleteRendezVous(int id){
        return rdv.deleteRendezVous(id);
    }


    /***************************************************************************************/


    public List<Logement> createLogement(int reference, String adresse) {
        Logement l = new Logement(reference, adresse);
        logementRepository.saveLogement(l);
        return logementRepository.getAllLogements();
    }

}

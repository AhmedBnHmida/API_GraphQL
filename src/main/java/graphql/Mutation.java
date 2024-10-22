package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Mutation implements GraphQLRootResolver {
    public RendezVousRepository rdv;
    private LogementRepository logementRepository;

    public Mutation(RendezVousRepository rdv, LogementRepository logementRepository) {
        this.rdv = rdv;
        this.logementRepository = logementRepository;
    }

    public RendezVous addRendezVous(int id, String date, String heure, int refLog,String num){
        Logement l=logementRepository.getLogementsByReference(refLog);
        RendezVous r=new RendezVous(id,date,heure,l,num);
       rdv.addRendezVous(r);
           return r;

   }
   public String updateRendezVous(int id, String date, String heure,String num){
       Logement l=logementRepository.getLogementsByReference(id);
        RendezVous r=new RendezVous( id, date, heure,l, num);
        if(rdv.updateRendezVous(r))
            return "succes";
            return "echec";

   }
    public boolean deleteRendezVous(int id){
        return rdv.deleteRendezVous(id);
    }

}

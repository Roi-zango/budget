package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Tache.class)
public class Tache_ {
  public static volatile SingularAttribute<Tache, Integer> numordre;
  
  public static volatile SingularAttribute<Tache, String> resultprocess;
  
  public static volatile SingularAttribute<Tache, Double> montantpayeht;
  
  public static volatile SingularAttribute<Tache, NatureT> idnatureT;
  
  public static volatile SingularAttribute<Tache, Naturetache> idnaturetache;
  
  public static volatile SingularAttribute<Tache, Boolean> m11;
  
  public static volatile SingularAttribute<Tache, String> nom;
  
  public static volatile SingularAttribute<Tache, String> etat;
  
  public static volatile SingularAttribute<Tache, Boolean> m10;
  
  public static volatile SingularAttribute<Tache, Boolean> m12;
  
  public static volatile SingularAttribute<Tache, Risque> idrisque;
  
  public static volatile SingularAttribute<Tache, Double> napOrdonne;
  
  public static volatile ListAttribute<Tache, Moyens> moyensList;
  
  public static volatile SingularAttribute<Tache, Double> totalmontantaloue;
  
  public static volatile SingularAttribute<Tache, Double> taxeOrdonne;
  
  public static volatile SingularAttribute<Tache, String> indicateurspoursuivis;
  
  public static volatile SingularAttribute<Tache, Double> montantengage;
  
  public static volatile SingularAttribute<Tache, Date> derniereModif;
  
  public static volatile SingularAttribute<Tache, Annee> idannee;
  
  public static volatile SingularAttribute<Tache, String> indicateurs2014;
  
  public static volatile SingularAttribute<Tache, Structure> idstructure;
  
  public static volatile SingularAttribute<Tache, Boolean> m1;
  
  public static volatile SingularAttribute<Tache, Boolean> m2;
  
  public static volatile SingularAttribute<Tache, Boolean> m3;
  
  public static volatile SingularAttribute<Tache, Boolean> m4;
  
  public static volatile SingularAttribute<Tache, Boolean> m5;
  
  public static volatile SingularAttribute<Tache, String> indicateurresult;
  
  public static volatile SingularAttribute<Tache, Boolean> m6;
  
  public static volatile SingularAttribute<Tache, Boolean> m7;
  
  public static volatile SingularAttribute<Tache, Double> cpanneeplus1;
  
  public static volatile SingularAttribute<Tache, Double> aeencours;
  
  public static volatile SingularAttribute<Tache, Boolean> m8;
  
  public static volatile SingularAttribute<Tache, Typefinancement> idtypefinancement;
  
  public static volatile SingularAttribute<Tache, String> moyensnecessaires;
  
  public static volatile SingularAttribute<Tache, Boolean> m9;
  
  public static volatile SingularAttribute<Tache, Bailleurfond> idbailleurfond;
  
  public static volatile SingularAttribute<Tache, Double> cpanneeplus2;
  
  public static volatile SingularAttribute<Tache, Activite> idactivite;
  
  public static volatile SingularAttribute<Tache, Date> dateEnregistre;
  
  public static volatile ListAttribute<Tache, Tacheindicateurperformance> tacheindicateurperformanceList;
  
  public static volatile SingularAttribute<Tache, Double> montantpayettc;
  
  public static volatile SingularAttribute<Tache, Double> cpconsommee;
  
  public static volatile ListAttribute<Tache, Semaine> semaineList;
  
  public static volatile SingularAttribute<Tache, Double> montantOrdonne;
  
  public static volatile SingularAttribute<Tache, CodeAnalytique> codeAnalytique;
  
  public static volatile SingularAttribute<Tache, Long> idtache;
  
  public static volatile SingularAttribute<Tache, Double> montantliquide;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Tache_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Revueprogramme.class)
public class Revueprogramme_ {
  public static volatile SingularAttribute<Revueprogramme, String> produits;
  
  public static volatile ListAttribute<Revueprogramme, Revueperformance> revueperformanceList;
  
  public static volatile SingularAttribute<Revueprogramme, String> implications;
  
  public static volatile SingularAttribute<Revueprogramme, RevueprogrammePK> revueprogrammePK;
  
  public static volatile ListAttribute<Revueprogramme, Revueaction> revueactionList;
  
  public static volatile SingularAttribute<Revueprogramme, Double> cout;
  
  public static volatile SingularAttribute<Revueprogramme, Revue> revue;
  
  public static volatile ListAttribute<Revueprogramme, Revuefait> revuefaitList;
  
  public static volatile SingularAttribute<Revueprogramme, String> faits;
  
  public static volatile SingularAttribute<Revueprogramme, String> ajustementactions;
  
  public static volatile SingularAttribute<Revueprogramme, String> etat;
  
  public static volatile SingularAttribute<Revueprogramme, Date> dateEnregistre;
  
  public static volatile ListAttribute<Revueprogramme, Revuedifficilte> revuedifficilteList;
  
  public static volatile SingularAttribute<Revueprogramme, String> perspectives;
  
  public static volatile SingularAttribute<Revueprogramme, String> observations;
  
  public static volatile SingularAttribute<Revueprogramme, Date> derniereModif;
  
  public static volatile ListAttribute<Revueprogramme, Revueactivite> revueactiviteList;
  
  public static volatile SingularAttribute<Revueprogramme, String> contextmeo;
  
  public static volatile SingularAttribute<Revueprogramme, String> difficultes;
  
  public static volatile SingularAttribute<Revueprogramme, String> priseencompte;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revueprogramme_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
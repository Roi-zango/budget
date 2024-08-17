package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Revueaction.class)
public class Revueaction_ {
  public static volatile SingularAttribute<Revueaction, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Revueaction, Revueprogramme> revueprogramme;
  
  public static volatile SingularAttribute<Revueaction, Integer> idrevueaction;
  
  public static volatile SingularAttribute<Revueaction, String> observation;
  
  public static volatile SingularAttribute<Revueaction, Date> derniereModif;
  
  public static volatile SingularAttribute<Revueaction, String> activitesupprimes;
  
  public static volatile SingularAttribute<Revueaction, Action> idaction;
  
  public static volatile SingularAttribute<Revueaction, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revueaction_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
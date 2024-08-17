package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Revueactivite.class)
public class Revueactivite_ {
  public static volatile SingularAttribute<Revueactivite, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Revueactivite, Revueprogramme> revueprogramme;
  
  public static volatile SingularAttribute<Revueactivite, Integer> idrevueactivite;
  
  public static volatile SingularAttribute<Revueactivite, Double> cout;
  
  public static volatile SingularAttribute<Revueactivite, String> observations;
  
  public static volatile SingularAttribute<Revueactivite, Date> derniereModif;
  
  public static volatile SingularAttribute<Revueactivite, String> activites;
  
  public static volatile SingularAttribute<Revueactivite, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revueactivite_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
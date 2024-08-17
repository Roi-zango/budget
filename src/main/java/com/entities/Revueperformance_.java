package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Revueperformance.class)
public class Revueperformance_ {
  public static volatile SingularAttribute<Revueperformance, String> indicateur;
  
  public static volatile SingularAttribute<Revueperformance, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Revueperformance, Revueprogramme> revueprogramme;
  
  public static volatile SingularAttribute<Revueperformance, Double> valeurrealise;
  
  public static volatile SingularAttribute<Revueperformance, Integer> idrevueperformance;
  
  public static volatile SingularAttribute<Revueperformance, String> observation;
  
  public static volatile SingularAttribute<Revueperformance, Date> derniereModif;
  
  public static volatile SingularAttribute<Revueperformance, String> etat;
  
  public static volatile SingularAttribute<Revueperformance, Double> valeurcible;
  
  public static volatile SingularAttribute<Revueperformance, String> tauxrealise;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revueperformance_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Revuefait.class)
public class Revuefait_ {
  public static volatile SingularAttribute<Revuefait, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Revuefait, Revueprogramme> revueprogramme;
  
  public static volatile SingularAttribute<Revuefait, String> implication;
  
  public static volatile SingularAttribute<Revuefait, String> observation;
  
  public static volatile SingularAttribute<Revuefait, Date> derniereModif;
  
  public static volatile SingularAttribute<Revuefait, String> fait;
  
  public static volatile SingularAttribute<Revuefait, Integer> idrevuefait;
  
  public static volatile SingularAttribute<Revuefait, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revuefait_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
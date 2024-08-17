package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Revuedifficilte.class)
public class Revuedifficilte_ {
  public static volatile SingularAttribute<Revuedifficilte, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Revuedifficilte, Revueprogramme> revueprogramme;
  
  public static volatile SingularAttribute<Revuedifficilte, String> solution;
  
  public static volatile SingularAttribute<Revuedifficilte, Rubriquedifficulte> idrubriquedifficulte;
  
  public static volatile SingularAttribute<Revuedifficilte, String> observation;
  
  public static volatile SingularAttribute<Revuedifficilte, Date> derniereModif;
  
  public static volatile SingularAttribute<Revuedifficilte, Integer> idrevuedifficilte;
  
  public static volatile SingularAttribute<Revuedifficilte, String> difficulte;
  
  public static volatile SingularAttribute<Revuedifficilte, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revuedifficilte_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
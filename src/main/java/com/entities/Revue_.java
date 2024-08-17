package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Revue.class)
public class Revue_ {
  public static volatile SingularAttribute<Revue, Long> idrevue;
  
  public static volatile SingularAttribute<Revue, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Revue, Date> derniereModif;
  
  public static volatile SingularAttribute<Revue, Annee> idannee;
  
  public static volatile SingularAttribute<Revue, String> nom;
  
  public static volatile SingularAttribute<Revue, String> etat;
  
  public static volatile ListAttribute<Revue, Revueprogramme> revueprogrammeList;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Revue_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Reglage.class)
public class Reglage_ {
  public static volatile SingularAttribute<Reglage, Long> idReglage;
  
  public static volatile SingularAttribute<Reglage, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Reglage, String> valeur;
  
  public static volatile SingularAttribute<Reglage, String> libelle;
  
  public static volatile SingularAttribute<Reglage, Date> derniereModif;
  
  public static volatile SingularAttribute<Reglage, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Reglage_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
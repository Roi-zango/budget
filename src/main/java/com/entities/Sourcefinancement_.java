package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Sourcefinancement.class)
public class Sourcefinancement_ {
  public static volatile ListAttribute<Sourcefinancement, Bailleurfond> bailleurfondList;
  
  public static volatile SingularAttribute<Sourcefinancement, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Sourcefinancement, Long> idsourcefinancement;
  
  public static volatile SingularAttribute<Sourcefinancement, Date> derniereModif;
  
  public static volatile SingularAttribute<Sourcefinancement, String> nom;
  
  public static volatile SingularAttribute<Sourcefinancement, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Sourcefinancement_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
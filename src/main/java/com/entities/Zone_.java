package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Zone.class)
public class Zone_ {
  public static volatile SingularAttribute<Zone, Long> idzone;
  
  public static volatile SingularAttribute<Zone, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Zone, Date> derniereModif;
  
  public static volatile ListAttribute<Zone, Action> actionList;
  
  public static volatile SingularAttribute<Zone, String> nom;
  
  public static volatile SingularAttribute<Zone, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Zone_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
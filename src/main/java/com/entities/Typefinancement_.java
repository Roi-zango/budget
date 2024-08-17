package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Typefinancement.class)
public class Typefinancement_ {
  public static volatile SingularAttribute<Typefinancement, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Typefinancement, Date> derniereModif;
  
  public static volatile ListAttribute<Typefinancement, Tache> tacheList;
  
  public static volatile SingularAttribute<Typefinancement, Long> idtypefinancement;
  
  public static volatile SingularAttribute<Typefinancement, String> nom;
  
  public static volatile SingularAttribute<Typefinancement, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Typefinancement_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
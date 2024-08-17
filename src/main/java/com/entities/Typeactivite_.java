package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Typeactivite.class)
public class Typeactivite_ {
  public static volatile SingularAttribute<Typeactivite, Date> dateEnregistre;
  
  public static volatile ListAttribute<Typeactivite, Activite> activiteList;
  
  public static volatile SingularAttribute<Typeactivite, Integer> numero;
  
  public static volatile SingularAttribute<Typeactivite, Date> derniereModif;
  
  public static volatile SingularAttribute<Typeactivite, Long> idtypeactivite;
  
  public static volatile SingularAttribute<Typeactivite, String> nom;
  
  public static volatile SingularAttribute<Typeactivite, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Typeactivite_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Rang.class)
public class Rang_ {
  public static volatile SingularAttribute<Rang, Long> idrang;
  
  public static volatile SingularAttribute<Rang, Date> dateEnregistre;
  
  public static volatile ListAttribute<Rang, Activite> activiteList;
  
  public static volatile SingularAttribute<Rang, Integer> numero;
  
  public static volatile SingularAttribute<Rang, Date> derniereModif;
  
  public static volatile SingularAttribute<Rang, String> nom;
  
  public static volatile SingularAttribute<Rang, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Rang_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
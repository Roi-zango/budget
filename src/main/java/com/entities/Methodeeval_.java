package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Methodeeval.class)
public class Methodeeval_ {
  public static volatile SingularAttribute<Methodeeval, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Methodeeval, Date> derniereModif;
  
  public static volatile SingularAttribute<Methodeeval, String> description;
  
  public static volatile SingularAttribute<Methodeeval, Long> idmethodeeval;
  
  public static volatile ListAttribute<Methodeeval, Extrant> extrantList;
  
  public static volatile SingularAttribute<Methodeeval, String> nom;
  
  public static volatile SingularAttribute<Methodeeval, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Methodeeval_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Axestrategique.class)
public class Axestrategique_ {
  public static volatile ListAttribute<Axestrategique, Programme> programmeList;
  
  public static volatile SingularAttribute<Axestrategique, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Axestrategique, Long> idaxestrategique;
  
  public static volatile SingularAttribute<Axestrategique, Date> derniereModif;
  
  public static volatile SingularAttribute<Axestrategique, String> nom;
  
  public static volatile SingularAttribute<Axestrategique, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Axestrategique_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
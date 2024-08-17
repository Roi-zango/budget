package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Risque.class)
public class Risque_ {
  public static volatile SingularAttribute<Risque, Long> idrisque;
  
  public static volatile SingularAttribute<Risque, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Risque, Date> derniereModif;
  
  public static volatile ListAttribute<Risque, Tache> tacheList;
  
  public static volatile SingularAttribute<Risque, String> nom;
  
  public static volatile SingularAttribute<Risque, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Risque_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
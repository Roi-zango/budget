package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Statutstructure.class)
public class Statutstructure_ {
  public static volatile SingularAttribute<Statutstructure, Long> idstatutstructure;
  
  public static volatile SingularAttribute<Statutstructure, Date> dateEnregistre;
  
  public static volatile ListAttribute<Statutstructure, Structure> structureList;
  
  public static volatile SingularAttribute<Statutstructure, Date> derniereModif;
  
  public static volatile SingularAttribute<Statutstructure, String> nom;
  
  public static volatile SingularAttribute<Statutstructure, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Statutstructure_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
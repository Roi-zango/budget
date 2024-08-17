package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Typestructure.class)
public class Typestructure_ {
  public static volatile SingularAttribute<Typestructure, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Typestructure, Long> idtypestructure;
  
  public static volatile ListAttribute<Typestructure, Indicateurperformance> indicateurperformanceList;
  
  public static volatile ListAttribute<Typestructure, Activitetypestructure> activitetypestructureList;
  
  public static volatile ListAttribute<Typestructure, Structure> structureList;
  
  public static volatile SingularAttribute<Typestructure, Date> derniereModif;
  
  public static volatile SingularAttribute<Typestructure, String> designation;
  
  public static volatile SingularAttribute<Typestructure, String> nom;
  
  public static volatile SingularAttribute<Typestructure, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Typestructure_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
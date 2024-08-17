package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Pyramide.class)
public class Pyramide_ {
  public static volatile SingularAttribute<Pyramide, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Pyramide, Long> idpyramide;
  
  public static volatile SingularAttribute<Pyramide, Double> superficie;
  
  public static volatile ListAttribute<Pyramide, Structure> structureList;
  
  public static volatile SingularAttribute<Pyramide, Date> derniereModif;
  
  public static volatile SingularAttribute<Pyramide, Long> idpyramideratachement;
  
  public static volatile SingularAttribute<Pyramide, String> nom;
  
  public static volatile SingularAttribute<Pyramide, String> etat;
  
  public static volatile SingularAttribute<Pyramide, Niveaupyramide> idniveaupyramide;
  
  public static volatile SingularAttribute<Pyramide, Double> population;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Pyramide_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
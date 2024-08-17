package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Semaine.class)
public class Semaine_ {
  public static volatile SingularAttribute<Semaine, Boolean> s3;
  
  public static volatile SingularAttribute<Semaine, Boolean> s4;
  
  public static volatile SingularAttribute<Semaine, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Semaine, Long> idsemaine;
  
  public static volatile SingularAttribute<Semaine, Mois> idmois;
  
  public static volatile SingularAttribute<Semaine, Date> derniereModif;
  
  public static volatile SingularAttribute<Semaine, Tache> idtache;
  
  public static volatile SingularAttribute<Semaine, String> nom;
  
  public static volatile SingularAttribute<Semaine, String> etat;
  
  public static volatile SingularAttribute<Semaine, Boolean> s1;
  
  public static volatile SingularAttribute<Semaine, Boolean> s2;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Semaine_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
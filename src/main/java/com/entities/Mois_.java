package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Mois.class)
public class Mois_ {
  public static volatile SingularAttribute<Mois, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Mois, Long> idmois;
  
  public static volatile SingularAttribute<Mois, Date> derniereModif;
  
  public static volatile ListAttribute<Mois, Semaine> semaineList;
  
  public static volatile SingularAttribute<Mois, String> nom;
  
  public static volatile SingularAttribute<Mois, Integer> rang;
  
  public static volatile SingularAttribute<Mois, String> choix;
  
  public static volatile SingularAttribute<Mois, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Mois_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Action.class)
public class Action_ {
  public static volatile SingularAttribute<Action, Zone> idzone;
  
  public static volatile SingularAttribute<Action, String> objectifs;
  
  public static volatile ListAttribute<Action, Activite> activiteList;
  
  public static volatile SingularAttribute<Action, String> code;
  
  public static volatile SingularAttribute<Action, Indicateurprogramme> idindicateurprogramme;
  
  public static volatile ListAttribute<Action, Revueaction> revueactionList;
  
  public static volatile ListAttribute<Action, Indicateuraction> indicateuractionList;
  
  public static volatile SingularAttribute<Action, Long> idaction;
  
  public static volatile SingularAttribute<Action, String> effet;
  
  public static volatile SingularAttribute<Action, Double> baseline;
  
  public static volatile SingularAttribute<Action, String> nom;
  
  public static volatile SingularAttribute<Action, String> etat;
  
  public static volatile SingularAttribute<Action, String> respomeo;
  
  public static volatile SingularAttribute<Action, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Action, String> indicateur;
  
  public static volatile SingularAttribute<Action, Double> cible;
  
  public static volatile SingularAttribute<Action, String> cadremeo;
  
  public static volatile SingularAttribute<Action, Date> derniereModif;
  
  public static volatile SingularAttribute<Action, Programme> idprogramme;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Action_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Activite.class)
public class Activite_ {
  public static volatile SingularAttribute<Activite, Rang> idrang;
  
  public static volatile SingularAttribute<Activite, Structure> idstructure;
  
  public static volatile SingularAttribute<Activite, String> code;
  
  public static volatile ListAttribute<Activite, Indicateuractivite> indicateuractiviteList;
  
  public static volatile SingularAttribute<Activite, String> responsables;
  
  public static volatile ListAttribute<Activite, Activitetypestructure> activitetypestructureList;
  
  public static volatile SingularAttribute<Activite, Indicateuraction> idindicateuraction;
  
  public static volatile SingularAttribute<Activite, Action> idaction;
  
  public static volatile SingularAttribute<Activite, String> nom;
  
  public static volatile SingularAttribute<Activite, String> etat;
  
  public static volatile SingularAttribute<Activite, String> cumulindicateurs;
  
  public static volatile SingularAttribute<Activite, Long> idactivite;
  
  public static volatile SingularAttribute<Activite, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Activite, String> autreconcerne;
  
  public static volatile SingularAttribute<Activite, Date> derniereModif;
  
  public static volatile SingularAttribute<Activite, String> objectif;
  
  public static volatile ListAttribute<Activite, Tache> tacheList;
  
  public static volatile SingularAttribute<Activite, Typeactivite> idtypeactivite;
  
  public static volatile SingularAttribute<Activite, String> justification;
  
  public static volatile SingularAttribute<Activite, String> partisprenantes;
  
  public static volatile SingularAttribute<Activite, String> cumulextrants;
  
  public static volatile ListAttribute<Activite, Structuremissionactivite> structuremissionactiviteList;
  
  public static volatile SingularAttribute<Activite, Boolean> prio;
  
  public static volatile ListAttribute<Activite, Extrant> extrantList;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Activite_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
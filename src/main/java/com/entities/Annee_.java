package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Annee.class)
public class Annee_ {
  public static volatile ListAttribute<Annee, Exercice> exerciceList;
  
  public static volatile ListAttribute<Annee, Indicateuractiviteannee> indicateuractiviteanneeList;
  
  public static volatile ListAttribute<Annee, Indicateuraction> indicateuractionList;
  
  public static volatile SingularAttribute<Annee, String> nom;
  
  public static volatile SingularAttribute<Annee, String> etat;
  
  public static volatile SingularAttribute<Annee, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Annee, Date> derniereModif;
  
  public static volatile ListAttribute<Annee, Revue> revueList;
  
  public static volatile ListAttribute<Annee, Indicateurprogrammeannee> indicateurprogrammeanneeList;
  
  public static volatile ListAttribute<Annee, Tache> tacheList;
  
  public static volatile ListAttribute<Annee, Recette> recetteList;
  
  public static volatile SingularAttribute<Annee, Long> idannee;
  
  public static volatile ListAttribute<Annee, Extrant> extrantList;
  
  public static volatile SingularAttribute<Annee, String> choix;
  
  public static volatile SingularAttribute<Annee, Boolean> fc;
  
  public static volatile ListAttribute<Annee, Indicateuractionannee> indicateuractionanneeList;
  
  public static volatile SingularAttribute<Annee, Boolean> budget;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Annee_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
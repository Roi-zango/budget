package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Typedonnees.class)
public class Typedonnees_ {
  public static volatile ListAttribute<Typedonnees, Indicateurprogramme> indicateurprogrammeList;
  
  public static volatile SingularAttribute<Typedonnees, Date> dateEnregistre;
  
  public static volatile ListAttribute<Typedonnees, Indicateurperformance> indicateurperformanceList;
  
  public static volatile ListAttribute<Typedonnees, Indicateuractivite> indicateuractiviteList;
  
  public static volatile ListAttribute<Typedonnees, Indicateuractiviteannee> indicateuractiviteanneeList;
  
  public static volatile SingularAttribute<Typedonnees, Date> derniereModif;
  
  public static volatile SingularAttribute<Typedonnees, Long> idtypedonnees;
  
  public static volatile ListAttribute<Typedonnees, Indicateuraction> indicateuractionList;
  
  public static volatile ListAttribute<Typedonnees, Indicateurprogrammeannee> indicateurprogrammeanneeList;
  
  public static volatile SingularAttribute<Typedonnees, String> nom;
  
  public static volatile SingularAttribute<Typedonnees, String> etat;
  
  public static volatile ListAttribute<Typedonnees, Indicateuractionannee> indicateuractionanneeList;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Typedonnees_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
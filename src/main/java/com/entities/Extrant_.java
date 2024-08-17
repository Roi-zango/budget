package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Extrant.class)
public class Extrant_ {
  public static volatile SingularAttribute<Extrant, Activite> idactivite;
  
  public static volatile SingularAttribute<Extrant, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Extrant, Long> idextrant;
  
  public static volatile SingularAttribute<Extrant, Double> cout;
  
  public static volatile SingularAttribute<Extrant, Date> derniereModif;
  
  public static volatile SingularAttribute<Extrant, String> indicateurs;
  
  public static volatile SingularAttribute<Extrant, Methodeeval> idmethodeeval;
  
  public static volatile SingularAttribute<Extrant, Annee> idannee;
  
  public static volatile SingularAttribute<Extrant, String> nom;
  
  public static volatile SingularAttribute<Extrant, String> etat;
  
  public static volatile ListAttribute<Extrant, Indicateurextrant> indicateurextrantList;
  
  public static volatile SingularAttribute<Extrant, Indicateurperformance> idindicateurperformance;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Extrant_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
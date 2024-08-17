package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Origineindicateur.class)
public class Origineindicateur_ {
  public static volatile SingularAttribute<Origineindicateur, Long> idorigineindicateur;
  
  public static volatile SingularAttribute<Origineindicateur, Date> dateEnregistre;
  
  public static volatile ListAttribute<Origineindicateur, Indicateurperformance> indicateurperformanceList;
  
  public static volatile SingularAttribute<Origineindicateur, Date> derniereModif;
  
  public static volatile SingularAttribute<Origineindicateur, String> nom;
  
  public static volatile SingularAttribute<Origineindicateur, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Origineindicateur_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Basejuridique.class)
public class Basejuridique_ {
  public static volatile SingularAttribute<Basejuridique, Date> dateEnregistre;
  
  public static volatile ListAttribute<Basejuridique, Mission> missionList;
  
  public static volatile SingularAttribute<Basejuridique, Date> derniereModif;
  
  public static volatile SingularAttribute<Basejuridique, Long> idbasejuridique;
  
  public static volatile SingularAttribute<Basejuridique, String> nom;
  
  public static volatile SingularAttribute<Basejuridique, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Basejuridique_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
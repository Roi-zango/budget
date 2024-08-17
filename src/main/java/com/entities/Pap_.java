package entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Pap.class)
public class Pap_ {
  public static volatile SingularAttribute<Pap, String> idpap;
  
  public static volatile SingularAttribute<Pap, String> libelle;
  
  public static volatile SingularAttribute<Pap, Integer> anneefin;
  
  public static volatile SingularAttribute<Pap, Integer> duree;
  
  public static volatile SingularAttribute<Pap, Integer> annedebut;
  
  public static volatile SingularAttribute<Pap, Boolean> actif;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Pap_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
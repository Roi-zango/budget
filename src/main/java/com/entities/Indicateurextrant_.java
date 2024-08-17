package entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Indicateurextrant.class)
public class Indicateurextrant_ {
  public static volatile SingularAttribute<Indicateurextrant, Double> cible;
  
  public static volatile SingularAttribute<Indicateurextrant, Extrant> extrant;
  
  public static volatile SingularAttribute<Indicateurextrant, String> observation;
  
  public static volatile SingularAttribute<Indicateurextrant, IndicateurextrantPK> indicateurextrantPK;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Indicateurextrant_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
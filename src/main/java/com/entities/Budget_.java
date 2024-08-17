package entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Budget.class)
public class Budget_ {
  public static volatile SingularAttribute<Budget, Integer> idbudget;
  
  public static volatile SingularAttribute<Budget, String> annee;
  
  public static volatile SingularAttribute<Budget, String> nom;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Budget_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
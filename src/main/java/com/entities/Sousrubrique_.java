package entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Sousrubrique.class)
public class Sousrubrique_ {
  public static volatile SingularAttribute<Sousrubrique, String> code;
  
  public static volatile SingularAttribute<Sousrubrique, Rubrique> idrubrique;
  
  public static volatile SingularAttribute<Sousrubrique, Integer> idsousrubrique;
  
  public static volatile SingularAttribute<Sousrubrique, String> nom;
  
  public static volatile ListAttribute<Sousrubrique, Imputation> imputationList;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Sousrubrique_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
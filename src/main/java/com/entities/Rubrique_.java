package entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Rubrique.class)
public class Rubrique_ {
  public static volatile SingularAttribute<Rubrique, String> code;
  
  public static volatile ListAttribute<Rubrique, Sousrubrique> sousrubriqueList;
  
  public static volatile SingularAttribute<Rubrique, Integer> idrubrique;
  
  public static volatile SingularAttribute<Rubrique, String> nom;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Rubrique_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
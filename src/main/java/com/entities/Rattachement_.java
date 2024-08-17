package entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Rattachement.class)
public class Rattachement_ {
  public static volatile ListAttribute<Rattachement, Structure> structureList;
  
  public static volatile SingularAttribute<Rattachement, String> nom;
  
  public static volatile SingularAttribute<Rattachement, Integer> idrattachement;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Rattachement_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
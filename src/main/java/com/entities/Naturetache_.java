package entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Naturetache.class)
public class Naturetache_ {
  public static volatile ListAttribute<Naturetache, ExerciceNature> exerciceNatureList;
  
  public static volatile ListAttribute<Naturetache, NatureT> natureTList;
  
  public static volatile SingularAttribute<Naturetache, Integer> idnaturetache;
  
  public static volatile ListAttribute<Naturetache, Tache> tacheList;
  
  public static volatile SingularAttribute<Naturetache, String> nom;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Naturetache_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
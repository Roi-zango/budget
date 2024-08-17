package entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(NatureT.class)
public class NatureT_ {
  public static volatile SingularAttribute<NatureT, Integer> idnatureT;
  
  public static volatile SingularAttribute<NatureT, Naturetache> idnaturetache;
  
  public static volatile ListAttribute<NatureT, Tache> tacheList;
  
  public static volatile ListAttribute<NatureT, ExerciceNatureT> exerciceNatureTList;
  
  public static volatile SingularAttribute<NatureT, String> nom;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\NatureT_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
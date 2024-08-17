package entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ExerciceNature.class)
public class ExerciceNature_ {
  public static volatile SingularAttribute<ExerciceNature, Double> pourcentage;
  
  public static volatile SingularAttribute<ExerciceNature, Integer> idexercice;
  
  public static volatile SingularAttribute<ExerciceNature, Double> montant;
  
  public static volatile SingularAttribute<ExerciceNature, Integer> idexercicenature;
  
  public static volatile SingularAttribute<ExerciceNature, Naturetache> idnature;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\ExerciceNature_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
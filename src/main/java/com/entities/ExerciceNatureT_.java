package entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ExerciceNatureT.class)
public class ExerciceNatureT_ {
  public static volatile SingularAttribute<ExerciceNatureT, Double> pourcentage;
  
  public static volatile SingularAttribute<ExerciceNatureT, NatureT> idnatureT;
  
  public static volatile SingularAttribute<ExerciceNatureT, Exercice> idexercice;
  
  public static volatile SingularAttribute<ExerciceNatureT, Double> montant;
  
  public static volatile SingularAttribute<ExerciceNatureT, Integer> idexercicenatureT;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\ExerciceNatureT_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
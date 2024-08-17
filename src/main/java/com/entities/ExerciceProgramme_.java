package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ExerciceProgramme.class)
public class ExerciceProgramme_ {
  public static volatile SingularAttribute<ExerciceProgramme, Date> dateEnregistre;
  
  public static volatile SingularAttribute<ExerciceProgramme, Double> coutprog;
  
  public static volatile SingularAttribute<ExerciceProgramme, Integer> idexerciceprogramme;
  
  public static volatile SingularAttribute<ExerciceProgramme, Date> derniereModif;
  
  public static volatile SingularAttribute<ExerciceProgramme, Long> idexercice;
  
  public static volatile SingularAttribute<ExerciceProgramme, String> nom;
  
  public static volatile SingularAttribute<ExerciceProgramme, Double> poidprog;
  
  public static volatile SingularAttribute<ExerciceProgramme, String> etat;
  
  public static volatile SingularAttribute<ExerciceProgramme, Long> idprogramme;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\ExerciceProgramme_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Exercice.class)
public class Exercice_ {
  public static volatile SingularAttribute<Exercice, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Exercice, Double> coutglobal;
  
  public static volatile SingularAttribute<Exercice, Boolean> ispublic;
  
  public static volatile SingularAttribute<Exercice, Institution> idinstitution;
  
  public static volatile SingularAttribute<Exercice, Date> derniereModif;
  
  public static volatile SingularAttribute<Exercice, Integer> idexercice;
  
  public static volatile SingularAttribute<Exercice, Double> montantaccorde;
  
  public static volatile ListAttribute<Exercice, ExerciceNatureT> exerciceNatureTList;
  
  public static volatile SingularAttribute<Exercice, Annee> idannee;
  
  public static volatile SingularAttribute<Exercice, String> propbudgetsante;
  
  public static volatile SingularAttribute<Exercice, String> etat;
  
  public static volatile SingularAttribute<Exercice, String> nomExercice;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Exercice_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
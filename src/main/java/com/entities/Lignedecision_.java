package entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Lignedecision.class)
public class Lignedecision_ {
  public static volatile SingularAttribute<Lignedecision, Double> total;
  
  public static volatile SingularAttribute<Lignedecision, String> code;
  
  public static volatile SingularAttribute<Lignedecision, String> libelle;
  
  public static volatile SingularAttribute<Lignedecision, Double> coutunitaire;
  
  public static volatile SingularAttribute<Lignedecision, Boncommande> boncommande;
  
  public static volatile SingularAttribute<Lignedecision, Long> idligneDecision;
  
  public static volatile SingularAttribute<Lignedecision, Boolean> verif;
  
  public static volatile SingularAttribute<Lignedecision, Integer> quantite;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Lignedecision_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
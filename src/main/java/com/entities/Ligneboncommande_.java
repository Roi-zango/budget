package entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Ligneboncommande.class)
public class Ligneboncommande_ {
  public static volatile SingularAttribute<Ligneboncommande, String> reference;
  
  public static volatile SingularAttribute<Ligneboncommande, Double> total;
  
  public static volatile SingularAttribute<Ligneboncommande, Double> prixmercurial;
  
  public static volatile SingularAttribute<Ligneboncommande, Elementcout> elementcout;
  
  public static volatile SingularAttribute<Ligneboncommande, Double> prixunitaire;
  
  public static volatile SingularAttribute<Ligneboncommande, Boncommande> boncommande;
  
  public static volatile SingularAttribute<Ligneboncommande, Boolean> verif;
  
  public static volatile SingularAttribute<Ligneboncommande, Long> idligneboncommande;
  
  public static volatile SingularAttribute<Ligneboncommande, Double> quantite;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Ligneboncommande_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
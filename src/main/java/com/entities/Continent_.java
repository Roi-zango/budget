package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Continent.class)
public class Continent_ {
  public static volatile SingularAttribute<Continent, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Continent, String> libelle;
  
  public static volatile SingularAttribute<Continent, Date> derniereModif;
  
  public static volatile SingularAttribute<Continent, Long> idContinent;
  
  public static volatile ListAttribute<Continent, Pays> paysList;
  
  public static volatile SingularAttribute<Continent, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Continent_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
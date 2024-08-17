package entities;

import java.math.BigInteger;
import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Region.class)
public class Region_ {
  public static volatile SingularAttribute<Region, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Region, BigInteger> superficie;
  
  public static volatile ListAttribute<Region, Departement> departementList;
  
  public static volatile SingularAttribute<Region, Pays> idPays;
  
  public static volatile ListAttribute<Region, Structure> structureList;
  
  public static volatile SingularAttribute<Region, Date> derniereModif;
  
  public static volatile SingularAttribute<Region, Long> idregion;
  
  public static volatile SingularAttribute<Region, String> nom;
  
  public static volatile SingularAttribute<Region, String> etat;
  
  public static volatile SingularAttribute<Region, BigInteger> population;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Region_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Departement.class)
public class Departement_ {
  public static volatile SingularAttribute<Departement, Date> dateEnregistre;
  
  public static volatile ListAttribute<Departement, Structure> structureList;
  
  public static volatile SingularAttribute<Departement, Date> derniereModif;
  
  public static volatile ListAttribute<Departement, Arrondissement> arrondissementList;
  
  public static volatile SingularAttribute<Departement, Long> iddepartement;
  
  public static volatile SingularAttribute<Departement, String> nom;
  
  public static volatile SingularAttribute<Departement, String> etat;
  
  public static volatile SingularAttribute<Departement, Region> idregion;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Departement_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
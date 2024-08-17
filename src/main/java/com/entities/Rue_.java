package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Rue.class)
public class Rue_ {
  public static volatile SingularAttribute<Rue, Long> idRue;
  
  public static volatile SingularAttribute<Rue, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Rue, String> libelle;
  
  public static volatile SingularAttribute<Rue, Date> derniereModif;
  
  public static volatile SingularAttribute<Rue, Quartier> idQuartier;
  
  public static volatile ListAttribute<Rue, Adresse> adresseList;
  
  public static volatile SingularAttribute<Rue, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Rue_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
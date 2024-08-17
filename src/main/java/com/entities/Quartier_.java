package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Quartier.class)
public class Quartier_ {
  public static volatile ListAttribute<Quartier, Rue> rueList;
  
  public static volatile SingularAttribute<Quartier, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Quartier, Long> idQuartier;
  
  public static volatile SingularAttribute<Quartier, String> libelle;
  
  public static volatile SingularAttribute<Quartier, Date> derniereModif;
  
  public static volatile SingularAttribute<Quartier, Ville> idVille;
  
  public static volatile ListAttribute<Quartier, Adresse> adresseList;
  
  public static volatile SingularAttribute<Quartier, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Quartier_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
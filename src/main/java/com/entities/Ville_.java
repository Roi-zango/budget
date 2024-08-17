package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Ville.class)
public class Ville_ {
  public static volatile SingularAttribute<Ville, Date> dateEnregistre;
  
  public static volatile ListAttribute<Ville, Quartier> quartierList;
  
  public static volatile SingularAttribute<Ville, Pays> idPays;
  
  public static volatile SingularAttribute<Ville, Long> idVille;
  
  public static volatile SingularAttribute<Ville, String> libelle;
  
  public static volatile SingularAttribute<Ville, Date> derniereModif;
  
  public static volatile ListAttribute<Ville, Adresse> adresseList;
  
  public static volatile SingularAttribute<Ville, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Ville_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
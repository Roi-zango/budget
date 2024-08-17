package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Secteur.class)
public class Secteur_ {
  public static volatile SingularAttribute<Secteur, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Secteur, Long> idsecteur;
  
  public static volatile ListAttribute<Secteur, Soussecteur> soussecteurList;
  
  public static volatile SingularAttribute<Secteur, Date> derniereModif;
  
  public static volatile SingularAttribute<Secteur, String> nom;
  
  public static volatile SingularAttribute<Secteur, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Secteur_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
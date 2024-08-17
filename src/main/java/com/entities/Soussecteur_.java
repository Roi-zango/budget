package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Soussecteur.class)
public class Soussecteur_ {
  public static volatile ListAttribute<Soussecteur, Programme> programmeList;
  
  public static volatile SingularAttribute<Soussecteur, Date> dateEnregistre;
  
  public static volatile ListAttribute<Soussecteur, Institution> institutionList;
  
  public static volatile SingularAttribute<Soussecteur, Secteur> idsecteur;
  
  public static volatile SingularAttribute<Soussecteur, Date> derniereModif;
  
  public static volatile SingularAttribute<Soussecteur, Long> idsoussecteur;
  
  public static volatile SingularAttribute<Soussecteur, String> nom;
  
  public static volatile SingularAttribute<Soussecteur, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Soussecteur_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
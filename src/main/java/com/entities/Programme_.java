package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Programme.class)
public class Programme_ {
  public static volatile SingularAttribute<Programme, String> objectifs;
  
  public static volatile SingularAttribute<Programme, String> code;
  
  public static volatile SingularAttribute<Programme, String> impact;
  
  public static volatile SingularAttribute<Programme, Axestrategique> idaxestrategique;
  
  public static volatile SingularAttribute<Programme, Double> baseline;
  
  public static volatile SingularAttribute<Programme, String> nom;
  
  public static volatile SingularAttribute<Programme, String> etat;
  
  public static volatile SingularAttribute<Programme, String> respomeo;
  
  public static volatile SingularAttribute<Programme, String> objectifstrategique;
  
  public static volatile SingularAttribute<Programme, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Programme, String> indicateur;
  
  public static volatile SingularAttribute<Programme, Double> cible;
  
  public static volatile SingularAttribute<Programme, String> stratrgieprogramme;
  
  public static volatile SingularAttribute<Programme, String> cadremeo;
  
  public static volatile SingularAttribute<Programme, Institution> idinstitution;
  
  public static volatile SingularAttribute<Programme, Date> derniereModif;
  
  public static volatile SingularAttribute<Programme, String> fonction;
  
  public static volatile SingularAttribute<Programme, Soussecteur> idsoussecteur;
  
  public static volatile SingularAttribute<Programme, Long> idprogramme;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Programme_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
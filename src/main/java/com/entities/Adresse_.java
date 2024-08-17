package entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Adresse.class)
public class Adresse_ {
  public static volatile SingularAttribute<Adresse, Rue> idRue;
  
  public static volatile SingularAttribute<Adresse, Long> idAdresse;
  
  public static volatile SingularAttribute<Adresse, String> siteWeb;
  
  public static volatile ListAttribute<Adresse, Structure> structureList;
  
  public static volatile SingularAttribute<Adresse, String> contact;
  
  public static volatile SingularAttribute<Adresse, Quartier> idQuartier;
  
  public static volatile SingularAttribute<Adresse, Ville> idVille;
  
  public static volatile SingularAttribute<Adresse, String> fax;
  
  public static volatile SingularAttribute<Adresse, String> bp;
  
  public static volatile SingularAttribute<Adresse, String> email;
  
  public static volatile ListAttribute<Adresse, Utilisateur> utilisateurList;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Adresse_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
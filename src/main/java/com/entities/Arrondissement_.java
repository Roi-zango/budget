package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Arrondissement.class)
public class Arrondissement_ {
  public static volatile SingularAttribute<Arrondissement, Date> dateEnregistre;
  
  public static volatile ListAttribute<Arrondissement, Structure> structureList;
  
  public static volatile SingularAttribute<Arrondissement, Date> derniereModif;
  
  public static volatile SingularAttribute<Arrondissement, Long> idarrondissement;
  
  public static volatile SingularAttribute<Arrondissement, Departement> iddepartement;
  
  public static volatile SingularAttribute<Arrondissement, String> nom;
  
  public static volatile SingularAttribute<Arrondissement, String> etat;
  
  public static volatile ListAttribute<Arrondissement, Utilisateur> utilisateurList;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Arrondissement_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
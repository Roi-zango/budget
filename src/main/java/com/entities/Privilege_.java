package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Privilege.class)
public class Privilege_ {
  public static volatile SingularAttribute<Privilege, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Privilege, String> configuration;
  
  public static volatile SingularAttribute<Privilege, Compte> idCompte;
  
  public static volatile SingularAttribute<Privilege, Date> derniereModif;
  
  public static volatile SingularAttribute<Privilege, GroupeUtilisateur> idGroupeUtilisateur;
  
  public static volatile SingularAttribute<Privilege, Long> idPrivilege;
  
  public static volatile SingularAttribute<Privilege, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Privilege_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
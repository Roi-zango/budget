package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Compte.class)
public class Compte_ {
  public static volatile ListAttribute<Compte, GroupeUtilisateur> groupeUtilisateurList;
  
  public static volatile SingularAttribute<Compte, String> connexion;
  
  public static volatile SingularAttribute<Compte, Utilisateur> idUtilisateur;
  
  public static volatile SingularAttribute<Compte, String> langue;
  
  public static volatile SingularAttribute<Compte, String> login;
  
  public static volatile SingularAttribute<Compte, String> etat;
  
  public static volatile SingularAttribute<Compte, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Compte, Date> heurecondecon;
  
  public static volatile SingularAttribute<Compte, Date> dernieremodif;
  
  public static volatile ListAttribute<Compte, Operations> operationsList;
  
  public static volatile SingularAttribute<Compte, Long> idCompte;
  
  public static volatile SingularAttribute<Compte, String> mdp;
  
  public static volatile ListAttribute<Compte, Privilege> privilegeList;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Compte_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
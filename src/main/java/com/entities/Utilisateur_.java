package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ {
  public static volatile SingularAttribute<Utilisateur, StatutMatrimonial> idStatutMatrimonial;
  
  public static volatile SingularAttribute<Utilisateur, String> photoRelatif;
  
  public static volatile SingularAttribute<Utilisateur, Adresse> idAdresse;
  
  public static volatile SingularAttribute<Utilisateur, Date> dateNaissance;
  
  public static volatile ListAttribute<Utilisateur, Structure> structureList;
  
  public static volatile SingularAttribute<Utilisateur, String> photo;
  
  public static volatile SingularAttribute<Utilisateur, Long> idUtilisateur;
  
  public static volatile SingularAttribute<Utilisateur, String> sexe;
  
  public static volatile ListAttribute<Utilisateur, Compte> compteList;
  
  public static volatile SingularAttribute<Utilisateur, String> nom;
  
  public static volatile SingularAttribute<Utilisateur, String> etat;
  
  public static volatile SingularAttribute<Utilisateur, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Utilisateur, Pays> idPays;
  
  public static volatile SingularAttribute<Utilisateur, Date> derniereModif;
  
  public static volatile SingularAttribute<Utilisateur, Arrondissement> idarrondissement;
  
  public static volatile SingularAttribute<Utilisateur, String> prenom;
  
  public static volatile SingularAttribute<Utilisateur, String> cni;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Utilisateur_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
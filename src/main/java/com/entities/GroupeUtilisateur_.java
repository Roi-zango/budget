package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(GroupeUtilisateur.class)
public class GroupeUtilisateur_ {
  public static volatile SingularAttribute<GroupeUtilisateur, Date> dateEnregistre;
  
  public static volatile SingularAttribute<GroupeUtilisateur, String> libelle;
  
  public static volatile SingularAttribute<GroupeUtilisateur, Date> derniereModif;
  
  public static volatile SingularAttribute<GroupeUtilisateur, Long> idGroupeUtilisateur;
  
  public static volatile ListAttribute<GroupeUtilisateur, Compte> compteList;
  
  public static volatile SingularAttribute<GroupeUtilisateur, String> etat;
  
  public static volatile ListAttribute<GroupeUtilisateur, Privilege> privilegeList;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\GroupeUtilisateur_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
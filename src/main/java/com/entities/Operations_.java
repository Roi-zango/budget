package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Operations.class)
public class Operations_ {
  public static volatile SingularAttribute<Operations, String> cible;
  
  public static volatile SingularAttribute<Operations, String> adressenom;
  
  public static volatile SingularAttribute<Operations, Long> idOperations;
  
  public static volatile SingularAttribute<Operations, Compte> idCompte;
  
  public static volatile SingularAttribute<Operations, String> libelle;
  
  public static volatile SingularAttribute<Operations, Date> heureOpration;
  
  public static volatile SingularAttribute<Operations, String> adresseIp;
  
  public static volatile SingularAttribute<Operations, String> adresseMac;
  
  public static volatile SingularAttribute<Operations, String> etat;
  
  public static volatile SingularAttribute<Operations, Date> dateOpration;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Operations_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
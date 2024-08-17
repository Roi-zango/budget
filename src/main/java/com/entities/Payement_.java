package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Payement.class)
public class Payement_ {
  public static volatile SingularAttribute<Payement, Long> idpayement;
  
  public static volatile SingularAttribute<Payement, Boolean> bc;
  
  public static volatile SingularAttribute<Payement, String> ribbeneficiaire;
  
  public static volatile SingularAttribute<Payement, String> code;
  
  public static volatile SingularAttribute<Payement, Date> datesaisie;
  
  public static volatile SingularAttribute<Payement, Boolean> decision;
  
  public static volatile SingularAttribute<Payement, OrdrePayement> odrePayement;
  
  public static volatile SingularAttribute<Payement, Double> montant;
  
  public static volatile SingularAttribute<Payement, Boolean> salaire;
  
  public static volatile SingularAttribute<Payement, String> objet;
  
  public static volatile SingularAttribute<Payement, Date> datevalidation;
  
  public static volatile SingularAttribute<Payement, String> reference;
  
  public static volatile SingularAttribute<Payement, Boolean> mission;
  
  public static volatile SingularAttribute<Payement, Integer> virementId;
  
  public static volatile SingularAttribute<Payement, Boolean> lc;
  
  public static volatile SingularAttribute<Payement, Boolean> facture;
  
  public static volatile SingularAttribute<Payement, Boncommande> boncommande;
  
  public static volatile SingularAttribute<Payement, String> nombeneficiaire;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Payement_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
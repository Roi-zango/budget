package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(OrdrePayement.class)
public class OrdrePayement_ {
  public static volatile SingularAttribute<OrdrePayement, String> code;
  
  public static volatile SingularAttribute<OrdrePayement, Double> detailNap;
  
  public static volatile SingularAttribute<OrdrePayement, String> modePaiement;
  
  public static volatile SingularAttribute<OrdrePayement, Boolean> paye;
  
  public static volatile SingularAttribute<OrdrePayement, Double> montant;
  
  public static volatile SingularAttribute<OrdrePayement, String> beneficiaire;
  
  public static volatile SingularAttribute<OrdrePayement, Double> detailTva;
  
  public static volatile SingularAttribute<OrdrePayement, Boolean> taxe;
  
  public static volatile SingularAttribute<OrdrePayement, String> objet;
  
  public static volatile SingularAttribute<OrdrePayement, Integer> nombre_verification;
  
  public static volatile SingularAttribute<OrdrePayement, Boolean> etat;
  
  public static volatile SingularAttribute<OrdrePayement, String> pieces;
  
  public static volatile SingularAttribute<OrdrePayement, Date> dateOrdonnation;
  
  public static volatile SingularAttribute<OrdrePayement, Long> idOrdrePayement;
  
  public static volatile SingularAttribute<OrdrePayement, Boncommande> boncommande;
  
  public static volatile SingularAttribute<OrdrePayement, String> montantEnLettre;
  
  public static volatile SingularAttribute<OrdrePayement, Boolean> nap;
  
  public static volatile SingularAttribute<OrdrePayement, Double> detailAir;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\OrdrePayement_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
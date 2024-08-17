package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Boncommande.class)
public class Boncommande_ {
  public static volatile SingularAttribute<Boncommande, Boolean> bc;
  
  public static volatile SingularAttribute<Boncommande, String> code;
  
  public static volatile SingularAttribute<Boncommande, Long> idboncommande;
  
  public static volatile SingularAttribute<Boncommande, Boolean> virement;
  
  public static volatile SingularAttribute<Boncommande, Integer> delailivraison;
  
  public static volatile SingularAttribute<Boncommande, Boolean> paye;
  
  public static volatile SingularAttribute<Boncommande, Boolean> lettrecommande;
  
  public static volatile SingularAttribute<Boncommande, Boolean> greAgre;
  
  public static volatile SingularAttribute<Boncommande, Boolean> valide;
  
  public static volatile SingularAttribute<Boncommande, Double> tauxtva;
  
  public static volatile SingularAttribute<Boncommande, String> imputations;
  
  public static volatile SingularAttribute<Boncommande, String> reference;
  
  public static volatile SingularAttribute<Boncommande, Double> napOrdonne;
  
  public static volatile SingularAttribute<Boncommande, Double> totalair;
  
  public static volatile SingularAttribute<Boncommande, Double> taxeOrdonne;
  
  public static volatile SingularAttribute<Boncommande, Imputation> imputation;
  
  public static volatile SingularAttribute<Boncommande, Boolean> liquide;
  
  public static volatile SingularAttribute<Boncommande, Integer> nombreverif;
  
  public static volatile SingularAttribute<Boncommande, Double> coefficientreducteur;
  
  public static volatile SingularAttribute<Boncommande, Date> dateemission;
  
  public static volatile SingularAttribute<Boncommande, Double> totalht;
  
  public static volatile SingularAttribute<Boncommande, Double> tva;
  
  public static volatile SingularAttribute<Boncommande, Double> netapayer;
  
  public static volatile SingularAttribute<Boncommande, Budget> budget;
  
  public static volatile SingularAttribute<Boncommande, Date> datelivraison;
  
  public static volatile SingularAttribute<Boncommande, Double> ttc;
  
  public static volatile SingularAttribute<Boncommande, String> montantenlettre;
  
  public static volatile SingularAttribute<Boncommande, Boolean> decision;
  
  public static volatile SingularAttribute<Boncommande, Boolean> espece;
  
  public static volatile SingularAttribute<Boncommande, Signataire> signataire;
  
  public static volatile SingularAttribute<Boncommande, Moyens> moyens;
  
  public static volatile SingularAttribute<Boncommande, Boolean> salaire;
  
  public static volatile SingularAttribute<Boncommande, String> objet;
  
  public static volatile SingularAttribute<Boncommande, Boolean> verif;
  
  public static volatile SingularAttribute<Boncommande, Structure> structure;
  
  public static volatile SingularAttribute<Boncommande, Societe> societe;
  
  public static volatile ListAttribute<Boncommande, Ligneboncommande> ligneboncommandes;
  
  public static volatile SingularAttribute<Boncommande, Boolean> mission;
  
  public static volatile SingularAttribute<Boncommande, Double> avance;
  
  public static volatile SingularAttribute<Boncommande, Boolean> engage;
  
  public static volatile SingularAttribute<Boncommande, Boolean> attentepayement;
  
  public static volatile SingularAttribute<Boncommande, Boolean> cheque;
  
  public static volatile SingularAttribute<Boncommande, Double> montantOrdonne;
  
  public static volatile SingularAttribute<Boncommande, Double> tauxair;
  
  public static volatile SingularAttribute<Boncommande, Double> montantPaye;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Boncommande_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
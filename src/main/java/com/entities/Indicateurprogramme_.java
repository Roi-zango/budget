package entities;

import java.math.BigInteger;
import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Indicateurprogramme.class)
public class Indicateurprogramme_ {
  public static volatile SingularAttribute<Indicateurprogramme, Double> coutcollecte;
  
  public static volatile SingularAttribute<Indicateurprogramme, Long> idindicateurprogramme;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> unite;
  
  public static volatile SingularAttribute<Indicateurprogramme, Integer> annecible;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> limite;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> nom;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> etat;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> explication;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> modecollecte;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> reference;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> analyses;
  
  public static volatile SingularAttribute<Indicateurprogramme, Double> cible;
  
  public static volatile SingularAttribute<Indicateurprogramme, Date> derniereModif;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> commentaire;
  
  public static volatile SingularAttribute<Indicateurprogramme, BigInteger> idprogramme;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> difficultes;
  
  public static volatile SingularAttribute<Indicateurprogramme, Boolean> pap;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> serviceanalyse;
  
  public static volatile SingularAttribute<Indicateurprogramme, Double> pourcentage;
  
  public static volatile SingularAttribute<Indicateurprogramme, Double> valeurrealise;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> observation;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> moyens;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> sourcedonnees;
  
  public static volatile SingularAttribute<Indicateurprogramme, Typedonnees> idtypedonnees;
  
  public static volatile ListAttribute<Indicateurprogramme, Action> actionList;
  
  public static volatile SingularAttribute<Indicateurprogramme, Boolean> actif;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> periodicitecollecte;
  
  public static volatile SingularAttribute<Indicateurprogramme, Double> baseline;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> periodicitemesure;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> servicesynthese;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> servicerespo;
  
  public static volatile SingularAttribute<Indicateurprogramme, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> servicevalidation;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> denominateur;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> interpretation;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> objectif;
  
  public static volatile SingularAttribute<Indicateurprogramme, Integer> annebaseline;
  
  public static volatile ListAttribute<Indicateurprogramme, Indicateurprogrammeannee> indicateurprogrammeanneeList;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> modecalcul;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> numerateur;
  
  public static volatile SingularAttribute<Indicateurprogramme, String> sourceverification;
  
  public static volatile SingularAttribute<Indicateurprogramme, Double> coefmulti;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Indicateurprogramme_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
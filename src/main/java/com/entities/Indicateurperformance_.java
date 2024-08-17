package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Indicateurperformance.class)
public class Indicateurperformance_ {
  public static volatile SingularAttribute<Indicateurperformance, Double> coutcollecte;
  
  public static volatile SingularAttribute<Indicateurperformance, String> unite;
  
  public static volatile SingularAttribute<Indicateurperformance, String> limite;
  
  public static volatile SingularAttribute<Indicateurperformance, String> nom;
  
  public static volatile SingularAttribute<Indicateurperformance, String> etat;
  
  public static volatile SingularAttribute<Indicateurperformance, String> explication;
  
  public static volatile SingularAttribute<Indicateurperformance, String> modecollecte;
  
  public static volatile SingularAttribute<Indicateurperformance, String> analyses;
  
  public static volatile SingularAttribute<Indicateurperformance, Date> derniereModif;
  
  public static volatile SingularAttribute<Indicateurperformance, String> commentaire;
  
  public static volatile SingularAttribute<Indicateurperformance, String> difficultes;
  
  public static volatile SingularAttribute<Indicateurperformance, Boolean> pap;
  
  public static volatile SingularAttribute<Indicateurperformance, String> serviceanalyse;
  
  public static volatile SingularAttribute<Indicateurperformance, Typestructure> idtypestructure;
  
  public static volatile SingularAttribute<Indicateurperformance, String> moyens;
  
  public static volatile SingularAttribute<Indicateurperformance, String> sourcedonnees;
  
  public static volatile SingularAttribute<Indicateurperformance, Typedonnees> idtypedonnees;
  
  public static volatile SingularAttribute<Indicateurperformance, String> periodicitecollecte;
  
  public static volatile SingularAttribute<Indicateurperformance, String> periodicitemesure;
  
  public static volatile ListAttribute<Indicateurperformance, Performance> performanceList;
  
  public static volatile SingularAttribute<Indicateurperformance, Origineindicateur> idorigineindicateur;
  
  public static volatile SingularAttribute<Indicateurperformance, String> servicesynthese;
  
  public static volatile SingularAttribute<Indicateurperformance, String> servicerespo;
  
  public static volatile SingularAttribute<Indicateurperformance, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Indicateurperformance, String> servicevalidation;
  
  public static volatile SingularAttribute<Indicateurperformance, String> denominateur;
  
  public static volatile SingularAttribute<Indicateurperformance, String> interpretation;
  
  public static volatile ListAttribute<Indicateurperformance, Tacheindicateurperformance> tacheindicateurperformanceList;
  
  public static volatile SingularAttribute<Indicateurperformance, String> modecalcul;
  
  public static volatile SingularAttribute<Indicateurperformance, String> numerateur;
  
  public static volatile ListAttribute<Indicateurperformance, Extrant> extrantList;
  
  public static volatile SingularAttribute<Indicateurperformance, Long> idindicateurperformance;
  
  public static volatile SingularAttribute<Indicateurperformance, Niveaupyramide> idniveaupyramide;
  
  public static volatile SingularAttribute<Indicateurperformance, Double> coefmulti;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Indicateurperformance_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
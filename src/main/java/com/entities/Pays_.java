package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Pays.class)
public class Pays_ {
  public static volatile SingularAttribute<Pays, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Pays, Integer> code;
  
  public static volatile ListAttribute<Pays, Region> regionList;
  
  public static volatile SingularAttribute<Pays, Long> idPays;
  
  public static volatile ListAttribute<Pays, Ville> villeList;
  
  public static volatile SingularAttribute<Pays, String> libelle;
  
  public static volatile SingularAttribute<Pays, Date> derniereModif;
  
  public static volatile SingularAttribute<Pays, Continent> idContinent;
  
  public static volatile SingularAttribute<Pays, String> etat;
  
  public static volatile SingularAttribute<Pays, String> drapeau;
  
  public static volatile SingularAttribute<Pays, String> drapeauRelatif;
  
  public static volatile ListAttribute<Pays, Utilisateur> utilisateurList;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Pays_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
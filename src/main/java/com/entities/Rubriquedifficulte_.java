package entities;

import java.math.BigInteger;
import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Rubriquedifficulte.class)
public class Rubriquedifficulte_ {
  public static volatile SingularAttribute<Rubriquedifficulte, Date> dateEnregistre;
  
  public static volatile ListAttribute<Rubriquedifficulte, Revuedifficilte> revuedifficilteList;
  
  public static volatile SingularAttribute<Rubriquedifficulte, Long> idrubriquedifficulte;
  
  public static volatile SingularAttribute<Rubriquedifficulte, Date> derniereModif;
  
  public static volatile SingularAttribute<Rubriquedifficulte, String> nom;
  
  public static volatile SingularAttribute<Rubriquedifficulte, String> etat;
  
  public static volatile SingularAttribute<Rubriquedifficulte, BigInteger> idprogramme;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Rubriquedifficulte_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
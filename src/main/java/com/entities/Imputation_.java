package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Imputation.class)
public class Imputation_ {
  public static volatile SingularAttribute<Imputation, String> code;
  
  public static volatile SingularAttribute<Imputation, String> description;
  
  public static volatile SingularAttribute<Imputation, Section> section;
  
  public static volatile SingularAttribute<Imputation, String> nom;
  
  public static volatile SingularAttribute<Imputation, String> etat;
  
  public static volatile SingularAttribute<Imputation, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Imputation, Sousrubriquemercurial> sousrubriquemercurial;
  
  public static volatile ListAttribute<Imputation, Moyens> moyensList;
  
  public static volatile SingularAttribute<Imputation, Long> idimputation;
  
  public static volatile SingularAttribute<Imputation, Date> derniereModif;
  
  public static volatile SingularAttribute<Imputation, Typeimputation> idtypeimputation;
  
  public static volatile ListAttribute<Imputation, Recette> recetteList;
  
  public static volatile SingularAttribute<Imputation, Sousrubrique> idsousrubrique;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Imputation_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
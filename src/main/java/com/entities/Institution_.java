package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Institution.class)
public class Institution_ {
  public static volatile SingularAttribute<Institution, String> code;
  
  public static volatile ListAttribute<Institution, Exercice> exerciceList;
  
  public static volatile ListAttribute<Institution, Structure> structureList;
  
  public static volatile SingularAttribute<Institution, String> photo;
  
  public static volatile SingularAttribute<Institution, String> chapitre;
  
  public static volatile SingularAttribute<Institution, String> nom;
  
  public static volatile SingularAttribute<Institution, String> etat;
  
  public static volatile SingularAttribute<Institution, String> sigle;
  
  public static volatile ListAttribute<Institution, Programme> programmeList;
  
  public static volatile SingularAttribute<Institution, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Institution, String> choixstrategique;
  
  public static volatile SingularAttribute<Institution, String> photoInstitutionMere;
  
  public static volatile SingularAttribute<Institution, Long> idinstitution;
  
  public static volatile SingularAttribute<Institution, Date> derniereModif;
  
  public static volatile SingularAttribute<Institution, String> nomEn;
  
  public static volatile SingularAttribute<Institution, Soussecteur> idsoussecteur;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Institution_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
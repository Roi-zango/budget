package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(StatutMatrimonial.class)
public class StatutMatrimonial_ {
  public static volatile SingularAttribute<StatutMatrimonial, Long> idStatutMatrimonial;
  
  public static volatile SingularAttribute<StatutMatrimonial, Date> dateEnregistre;
  
  public static volatile SingularAttribute<StatutMatrimonial, String> libelle;
  
  public static volatile SingularAttribute<StatutMatrimonial, Date> derniereModif;
  
  public static volatile SingularAttribute<StatutMatrimonial, String> etat;
  
  public static volatile ListAttribute<StatutMatrimonial, Utilisateur> utilisateurList;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\StatutMatrimonial_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
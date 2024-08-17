package entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Signataire.class)
public class Signataire_ {
  public static volatile SingularAttribute<Signataire, Integer> idsignataire;
  
  public static volatile SingularAttribute<Signataire, String> adresse;
  
  public static volatile SingularAttribute<Signataire, String> telephone;
  
  public static volatile SingularAttribute<Signataire, String> nom;
  
  public static volatile SingularAttribute<Signataire, String> prenom;
  
  public static volatile SingularAttribute<Signataire, Structure> structure;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Signataire_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
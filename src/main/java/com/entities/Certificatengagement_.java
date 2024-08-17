package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Certificatengagement.class)
public class Certificatengagement_ {
  public static volatile SingularAttribute<Certificatengagement, Date> dateengagement;
  
  public static volatile SingularAttribute<Certificatengagement, Moyens> moyens;
  
  public static volatile SingularAttribute<Certificatengagement, Boncommande> boncommande;
  
  public static volatile SingularAttribute<Certificatengagement, Long> idcertificatengagement;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Certificatengagement_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
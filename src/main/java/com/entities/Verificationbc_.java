package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Verificationbc.class)
public class Verificationbc_ {
  public static volatile SingularAttribute<Verificationbc, Long> idverificationbc;
  
  public static volatile SingularAttribute<Verificationbc, String> observation;
  
  public static volatile SingularAttribute<Verificationbc, Boncommande> boncommande;
  
  public static volatile SingularAttribute<Verificationbc, Boolean> valide;
  
  public static volatile SingularAttribute<Verificationbc, Date> dateverification;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Verificationbc_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
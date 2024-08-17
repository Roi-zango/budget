package entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(VerificationOp.class)
public class VerificationOp_ {
  public static volatile SingularAttribute<VerificationOp, OrdrePayement> odrePayement;
  
  public static volatile SingularAttribute<VerificationOp, Long> idverificationOp;
  
  public static volatile SingularAttribute<VerificationOp, String> observation;
  
  public static volatile SingularAttribute<VerificationOp, Date> dateVerification;
  
  public static volatile SingularAttribute<VerificationOp, Boolean> valide;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\VerificationOp_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
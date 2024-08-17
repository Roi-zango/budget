package sessions;

import entities.VerificationOp;
import java.util.List;
import javax.ejb.Local;

@Local
public interface VerificationOpFacadeLocal {
  void create(VerificationOp paramVerificationOp);
  
  void edit(VerificationOp paramVerificationOp);
  
  void remove(VerificationOp paramVerificationOp);
  
  VerificationOp find(Object paramObject);
  
  List<VerificationOp> findAll();
  
  List<VerificationOp> findRange(int[] paramArrayOfint);
  
  int count();
  
  long nextId();
  
  List<VerificationOp> findByIdBudget(long paramLong, int paramInt);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\VerificationOpFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
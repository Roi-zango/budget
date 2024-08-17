package sessions;

import entities.Ligneverificationbc;
import java.util.List;
import javax.ejb.Local;

@Local
public interface LigneverificationbcFacadeLocal {
  void create(Ligneverificationbc paramLigneverificationbc);
  
  void edit(Ligneverificationbc paramLigneverificationbc);
  
  void remove(Ligneverificationbc paramLigneverificationbc);
  
  Ligneverificationbc find(Object paramObject);
  
  List<Ligneverificationbc> findAll();
  
  List<Ligneverificationbc> findRange(int[] paramArrayOfint);
  
  int count();
  
  long nextId();
  
  void deleteByIdVerificationBc(long paramLong);
  
  List<Ligneverificationbc> findByIdVerificationBc(long paramLong);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\LigneverificationbcFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
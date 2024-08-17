package sessions;

import entities.Operations;
import java.util.List;
import javax.ejb.Local;

@Local
public interface OperationsFacadeLocal {
  void create(Operations paramOperations);
  
  void edit(Operations paramOperations);
  
  void remove(Operations paramOperations);
  
  Operations find(Object paramObject);
  
  List<Operations> findAll();
  
  List<Operations> findRange(int[] paramArrayOfint);
  
  int count();
  
  Long nextId();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\OperationsFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
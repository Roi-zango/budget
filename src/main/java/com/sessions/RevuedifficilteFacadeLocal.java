package sessions;

import entities.Revuedifficilte;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RevuedifficilteFacadeLocal {
  void create(Revuedifficilte paramRevuedifficilte);
  
  void edit(Revuedifficilte paramRevuedifficilte);
  
  void remove(Revuedifficilte paramRevuedifficilte);
  
  Revuedifficilte find(Object paramObject);
  
  List<Revuedifficilte> findAll();
  
  List<Revuedifficilte> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RevuedifficilteFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
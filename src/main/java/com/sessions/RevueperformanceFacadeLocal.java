package sessions;

import entities.Revueperformance;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RevueperformanceFacadeLocal {
  void create(Revueperformance paramRevueperformance);
  
  void edit(Revueperformance paramRevueperformance);
  
  void remove(Revueperformance paramRevueperformance);
  
  Revueperformance find(Object paramObject);
  
  List<Revueperformance> findAll();
  
  List<Revueperformance> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RevueperformanceFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
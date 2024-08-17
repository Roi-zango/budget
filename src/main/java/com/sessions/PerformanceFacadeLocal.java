package sessions;

import entities.Performance;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PerformanceFacadeLocal {
  void create(Performance paramPerformance);
  
  void edit(Performance paramPerformance);
  
  void remove(Performance paramPerformance);
  
  Performance find(Object paramObject);
  
  List<Performance> findAll();
  
  List<Performance> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\PerformanceFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
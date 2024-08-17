package sessions;

import entities.Revue;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RevueFacadeLocal {
  void create(Revue paramRevue);
  
  void edit(Revue paramRevue);
  
  void remove(Revue paramRevue);
  
  Revue find(Object paramObject);
  
  List<Revue> findAll();
  
  List<Revue> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RevueFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
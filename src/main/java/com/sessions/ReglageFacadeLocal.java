package sessions;

import entities.Reglage;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ReglageFacadeLocal {
  void create(Reglage paramReglage);
  
  void edit(Reglage paramReglage);
  
  void remove(Reglage paramReglage);
  
  Reglage find(Object paramObject);
  
  List<Reglage> findAll();
  
  List<Reglage> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ReglageFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
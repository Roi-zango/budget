package sessions;

import entities.Revuefait;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RevuefaitFacadeLocal {
  void create(Revuefait paramRevuefait);
  
  void edit(Revuefait paramRevuefait);
  
  void remove(Revuefait paramRevuefait);
  
  Revuefait find(Object paramObject);
  
  List<Revuefait> findAll();
  
  List<Revuefait> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RevuefaitFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
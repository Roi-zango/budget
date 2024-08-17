package sessions;

import entities.Extrant;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ExtrantFacadeLocal {
  void create(Extrant paramExtrant);
  
  void edit(Extrant paramExtrant);
  
  void remove(Extrant paramExtrant);
  
  Extrant find(Object paramObject);
  
  List<Extrant> findAll();
  
  List<Extrant> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ExtrantFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
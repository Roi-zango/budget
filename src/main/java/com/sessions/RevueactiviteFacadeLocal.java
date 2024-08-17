package sessions;

import entities.Revueactivite;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RevueactiviteFacadeLocal {
  void create(Revueactivite paramRevueactivite);
  
  void edit(Revueactivite paramRevueactivite);
  
  void remove(Revueactivite paramRevueactivite);
  
  Revueactivite find(Object paramObject);
  
  List<Revueactivite> findAll();
  
  List<Revueactivite> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RevueactiviteFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
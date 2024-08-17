package sessions;

import entities.Revueaction;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RevueactionFacadeLocal {
  void create(Revueaction paramRevueaction);
  
  void edit(Revueaction paramRevueaction);
  
  void remove(Revueaction paramRevueaction);
  
  Revueaction find(Object paramObject);
  
  List<Revueaction> findAll();
  
  List<Revueaction> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RevueactionFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
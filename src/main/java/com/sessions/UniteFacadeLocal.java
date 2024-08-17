package sessions;

import entities.Unite;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UniteFacadeLocal {
  void create(Unite paramUnite);
  
  void edit(Unite paramUnite);
  
  void remove(Unite paramUnite);
  
  Unite find(Object paramObject);
  
  List<Unite> findAll();
  
  List<Unite> findRange(int[] paramArrayOfint);
  
  int count();
  
  int nextId();
  
  List<Unite> findAllRange();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\UniteFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package sessions;

import entities.Activitetypestructure;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ActivitetypestructureFacadeLocal {
  void create(Activitetypestructure paramActivitetypestructure);
  
  void edit(Activitetypestructure paramActivitetypestructure);
  
  void remove(Activitetypestructure paramActivitetypestructure);
  
  Activitetypestructure find(Object paramObject);
  
  List<Activitetypestructure> findAll();
  
  List<Activitetypestructure> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ActivitetypestructureFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
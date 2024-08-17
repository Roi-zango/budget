package sessions;

import entities.Typeimputation;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TypeimputationFacadeLocal {
  void create(Typeimputation paramTypeimputation);
  
  void edit(Typeimputation paramTypeimputation);
  
  void remove(Typeimputation paramTypeimputation);
  
  Typeimputation find(Object paramObject);
  
  List<Typeimputation> findAll();
  
  List<Typeimputation> findRange(int[] paramArrayOfint);
  
  int count();
  
  int nextId();
  
  List<Typeimputation> findAllRageCode();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\TypeimputationFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
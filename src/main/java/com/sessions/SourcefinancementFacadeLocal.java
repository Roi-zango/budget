package sessions;

import entities.Sourcefinancement;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SourcefinancementFacadeLocal {
  void create(Sourcefinancement paramSourcefinancement);
  
  void edit(Sourcefinancement paramSourcefinancement);
  
  void remove(Sourcefinancement paramSourcefinancement);
  
  Sourcefinancement find(Object paramObject);
  
  List<Sourcefinancement> findAll();
  
  List<Sourcefinancement> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SourcefinancementFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
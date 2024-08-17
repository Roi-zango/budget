package sessions;

import entities.Typefinancement;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TypefinancementFacadeLocal {
  void create(Typefinancement paramTypefinancement);
  
  void edit(Typefinancement paramTypefinancement);
  
  void remove(Typefinancement paramTypefinancement);
  
  Typefinancement find(Object paramObject);
  
  List<Typefinancement> findAll();
  
  List<Typefinancement> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\TypefinancementFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
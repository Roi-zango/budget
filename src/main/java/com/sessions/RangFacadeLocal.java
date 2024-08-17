package sessions;

import entities.Rang;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RangFacadeLocal {
  void create(Rang paramRang);
  
  void edit(Rang paramRang);
  
  void remove(Rang paramRang);
  
  Rang find(Object paramObject);
  
  List<Rang> findAll();
  
  List<Rang> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RangFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
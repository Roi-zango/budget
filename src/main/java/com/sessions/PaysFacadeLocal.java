package sessions;

import entities.Pays;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PaysFacadeLocal {
  void create(Pays paramPays);
  
  void edit(Pays paramPays);
  
  void remove(Pays paramPays);
  
  Pays find(Object paramObject);
  
  List<Pays> findAll();
  
  List<Pays> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\PaysFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
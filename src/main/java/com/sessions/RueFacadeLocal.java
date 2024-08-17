package sessions;

import entities.Rue;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RueFacadeLocal {
  void create(Rue paramRue);
  
  void edit(Rue paramRue);
  
  void remove(Rue paramRue);
  
  Rue find(Object paramObject);
  
  List<Rue> findAll();
  
  List<Rue> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RueFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
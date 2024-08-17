package sessions;

import entities.Bailleurfond;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BailleurfondFacadeLocal {
  void create(Bailleurfond paramBailleurfond);
  
  void edit(Bailleurfond paramBailleurfond);
  
  void remove(Bailleurfond paramBailleurfond);
  
  Bailleurfond find(Object paramObject);
  
  List<Bailleurfond> findAll();
  
  List<Bailleurfond> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\BailleurfondFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
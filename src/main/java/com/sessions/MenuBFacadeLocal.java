package sessions;

import entities.MenuB;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MenuBFacadeLocal {
  void create(MenuB paramMenuB);
  
  void edit(MenuB paramMenuB);
  
  void remove(MenuB paramMenuB);
  
  MenuB find(Object paramObject);
  
  List<MenuB> findAll();
  
  List<MenuB> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\MenuBFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
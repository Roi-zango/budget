package sessions;

import entities.Menu;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MenuFacadeLocal {
  void create(Menu paramMenu);
  
  void edit(Menu paramMenu);
  
  void remove(Menu paramMenu);
  
  Menu find(Object paramObject);
  
  List<Menu> findAll();
  
  List<Menu> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\MenuFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
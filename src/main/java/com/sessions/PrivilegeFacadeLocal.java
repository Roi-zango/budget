package sessions;

import entities.Privilege;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PrivilegeFacadeLocal {
  void create(Privilege paramPrivilege);
  
  void edit(Privilege paramPrivilege);
  
  void remove(Privilege paramPrivilege);
  
  Privilege find(Object paramObject);
  
  List<Privilege> findAll();
  
  List<Privilege> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\PrivilegeFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
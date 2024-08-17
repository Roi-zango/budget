package sessions;

import entities.PrivilegeB;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PrivilegeBFacadeLocal {
  void create(PrivilegeB paramPrivilegeB);
  
  void edit(PrivilegeB paramPrivilegeB);
  
  void remove(PrivilegeB paramPrivilegeB);
  
  PrivilegeB find(Object paramObject);
  
  List<PrivilegeB> findAll();
  
  List<PrivilegeB> findRange(int[] paramArrayOfint);
  
  int count();
  
  Long nextVal();
  
  List<PrivilegeB> findByUser(long paramLong);
  
  PrivilegeB findByUser(long paramLong, int paramInt);
  
  void delete(int paramInt, long paramLong);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\PrivilegeBFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
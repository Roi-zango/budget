package sessions;

import entities.Methodeeval;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MethodeevalFacadeLocal {
  void create(Methodeeval paramMethodeeval);
  
  void edit(Methodeeval paramMethodeeval);
  
  void remove(Methodeeval paramMethodeeval);
  
  Methodeeval find(Object paramObject);
  
  List<Methodeeval> findAll();
  
  List<Methodeeval> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\MethodeevalFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
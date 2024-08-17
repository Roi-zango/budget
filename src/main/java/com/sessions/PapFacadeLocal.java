package sessions;

import entities.Pap;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PapFacadeLocal {
  void create(Pap paramPap);
  
  void edit(Pap paramPap);
  
  void remove(Pap paramPap);
  
  Pap find(Object paramObject);
  
  List<Pap> findAll();
  
  List<Pap> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\PapFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
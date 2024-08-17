package sessions;

import entities.Naturetache;
import java.util.List;
import javax.ejb.Local;

@Local
public interface NaturetacheFacadeLocal {
  void create(Naturetache paramNaturetache);
  
  void edit(Naturetache paramNaturetache);
  
  void remove(Naturetache paramNaturetache);
  
  Naturetache find(Object paramObject);
  
  List<Naturetache> findAll();
  
  List<Naturetache> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\NaturetacheFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
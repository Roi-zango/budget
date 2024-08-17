package sessions;

import entities.NatureT;
import java.util.List;
import javax.ejb.Local;

@Local
public interface NatureTFacadeLocal {
  void create(NatureT paramNatureT);
  
  void edit(NatureT paramNatureT);
  
  void remove(NatureT paramNatureT);
  
  NatureT find(Object paramObject);
  
  List<NatureT> findAll();
  
  List<NatureT> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\NatureTFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
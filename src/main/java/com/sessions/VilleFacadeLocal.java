package sessions;

import entities.Ville;
import java.util.List;
import javax.ejb.Local;

@Local
public interface VilleFacadeLocal {
  void create(Ville paramVille);
  
  void edit(Ville paramVille);
  
  void remove(Ville paramVille);
  
  Ville find(Object paramObject);
  
  List<Ville> findAll();
  
  List<Ville> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\VilleFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
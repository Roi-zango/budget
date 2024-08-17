package sessions;

import entities.Quartier;
import java.util.List;
import javax.ejb.Local;

@Local
public interface QuartierFacadeLocal {
  void create(Quartier paramQuartier);
  
  void edit(Quartier paramQuartier);
  
  void remove(Quartier paramQuartier);
  
  Quartier find(Object paramObject);
  
  List<Quartier> findAll();
  
  List<Quartier> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\QuartierFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
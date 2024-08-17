package sessions;

import entities.Continent;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ContinentFacadeLocal {
  void create(Continent paramContinent);
  
  void edit(Continent paramContinent);
  
  void remove(Continent paramContinent);
  
  Continent find(Object paramObject);
  
  List<Continent> findAll();
  
  List<Continent> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ContinentFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
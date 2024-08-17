package sessions;

import entities.Region;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RegionFacadeLocal {
  void create(Region paramRegion);
  
  void edit(Region paramRegion);
  
  void remove(Region paramRegion);
  
  Region find(Object paramObject);
  
  List<Region> findAll();
  
  List<Region> findRange(int[] paramArrayOfint);
  
  int count();
  
  List<Region> findAllRange();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RegionFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
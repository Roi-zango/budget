package sessions;

import entities.Zone;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ZoneFacadeLocal {
  void create(Zone paramZone);
  
  void edit(Zone paramZone);
  
  void remove(Zone paramZone);
  
  Zone find(Object paramObject);
  
  List<Zone> findAll();
  
  List<Zone> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ZoneFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
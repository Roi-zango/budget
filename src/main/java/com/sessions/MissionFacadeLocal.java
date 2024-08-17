package sessions;

import entities.Mission;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MissionFacadeLocal {
  void create(Mission paramMission);
  
  void edit(Mission paramMission);
  
  void remove(Mission paramMission);
  
  Mission find(Object paramObject);
  
  List<Mission> findAll();
  
  List<Mission> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\MissionFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
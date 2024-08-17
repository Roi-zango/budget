package sessions;

import entities.Action;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ActionFacadeLocal {
  void create(Action paramAction);
  
  void edit(Action paramAction);
  
  void remove(Action paramAction);
  
  Action find(Object paramObject);
  
  List<Action> findAll();
  
  List<Action> findRange(int[] paramArrayOfint);
  
  int count();
  
  Long nextId();
  
  List<Action> findByProgramme(Long paramLong) throws Exception;
  
  List<Action> findByInstitution(Long paramLong) throws Exception;
  
  Action findByInstitution(Long paramLong, String paramString) throws Exception;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ActionFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
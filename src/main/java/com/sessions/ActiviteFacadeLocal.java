package sessions;

import entities.Activite;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ActiviteFacadeLocal {
  void create(Activite paramActivite);
  
  void edit(Activite paramActivite);
  
  void remove(Activite paramActivite);
  
  Activite find(Object paramObject);
  
  List<Activite> findAll();
  
  List<Activite> findRange(int[] paramArrayOfint);
  
  int count();
  
  Long nextId();
  
  List<Activite> findByAction(Long paramLong) throws Exception;
  
  List<Activite> findByIdStructure(Long paramLong);
  
  List<Activite> findByIdInstitution(Long paramLong);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ActiviteFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package sessions;

import entities.Rattachement;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RattachementFacadeLocal {
  void create(Rattachement paramRattachement);
  
  void edit(Rattachement paramRattachement);
  
  void remove(Rattachement paramRattachement);
  
  Rattachement find(Object paramObject);
  
  List<Rattachement> findAll();
  
  List<Rattachement> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RattachementFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package sessions;

import entities.Semaine;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SemaineFacadeLocal {
  void create(Semaine paramSemaine);
  
  void edit(Semaine paramSemaine);
  
  void remove(Semaine paramSemaine);
  
  Semaine find(Object paramObject);
  
  List<Semaine> findAll();
  
  List<Semaine> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SemaineFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
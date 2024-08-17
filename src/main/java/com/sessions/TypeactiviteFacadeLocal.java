package sessions;

import entities.Typeactivite;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TypeactiviteFacadeLocal {
  void create(Typeactivite paramTypeactivite);
  
  void edit(Typeactivite paramTypeactivite);
  
  void remove(Typeactivite paramTypeactivite);
  
  Typeactivite find(Object paramObject);
  
  List<Typeactivite> findAll();
  
  List<Typeactivite> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\TypeactiviteFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
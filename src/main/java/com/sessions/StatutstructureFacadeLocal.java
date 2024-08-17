package sessions;

import entities.Statutstructure;
import java.util.List;
import javax.ejb.Local;

@Local
public interface StatutstructureFacadeLocal {
  void create(Statutstructure paramStatutstructure);
  
  void edit(Statutstructure paramStatutstructure);
  
  void remove(Statutstructure paramStatutstructure);
  
  Statutstructure find(Object paramObject);
  
  List<Statutstructure> findAll();
  
  List<Statutstructure> findRange(int[] paramArrayOfint);
  
  int count();
  
  List<Statutstructure> findAllRange();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\StatutstructureFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
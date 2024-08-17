package sessions;

import entities.Pyramide;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PyramideFacadeLocal {
  void create(Pyramide paramPyramide);
  
  void edit(Pyramide paramPyramide);
  
  void remove(Pyramide paramPyramide);
  
  Pyramide find(Object paramObject);
  
  List<Pyramide> findAll();
  
  List<Pyramide> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\PyramideFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
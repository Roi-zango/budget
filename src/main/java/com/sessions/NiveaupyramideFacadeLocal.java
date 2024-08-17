package sessions;

import entities.Niveaupyramide;
import java.util.List;
import javax.ejb.Local;

@Local
public interface NiveaupyramideFacadeLocal {
  void create(Niveaupyramide paramNiveaupyramide);
  
  void edit(Niveaupyramide paramNiveaupyramide);
  
  void remove(Niveaupyramide paramNiveaupyramide);
  
  Niveaupyramide find(Object paramObject);
  
  List<Niveaupyramide> findAll();
  
  List<Niveaupyramide> findRange(int[] paramArrayOfint);
  
  int count();
  
  List<Niveaupyramide> findAllRange();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\NiveaupyramideFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package sessions;

import entities.Rubrique;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RubriqueFacadeLocal {
  void create(Rubrique paramRubrique);
  
  void edit(Rubrique paramRubrique);
  
  void remove(Rubrique paramRubrique);
  
  Rubrique find(Object paramObject);
  
  List<Rubrique> findRange(int[] paramArrayOfint);
  
  int count();
  
  List<Rubrique> findAllRangeCode();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RubriqueFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package sessions;

import entities.Axestrategique;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AxestrategiqueFacadeLocal {
  void create(Axestrategique paramAxestrategique);
  
  void edit(Axestrategique paramAxestrategique);
  
  void remove(Axestrategique paramAxestrategique);
  
  Axestrategique find(Object paramObject);
  
  List<Axestrategique> findAll();
  
  List<Axestrategique> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\AxestrategiqueFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
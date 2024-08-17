package sessions;

import entities.Risque;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RisqueFacadeLocal {
  void create(Risque paramRisque);
  
  void edit(Risque paramRisque);
  
  void remove(Risque paramRisque);
  
  Risque find(Object paramObject);
  
  List<Risque> findAll();
  
  List<Risque> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RisqueFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
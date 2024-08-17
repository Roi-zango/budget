package sessions;

import entities.Indicateurperformance;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IndicateurperformanceFacadeLocal {
  void create(Indicateurperformance paramIndicateurperformance);
  
  void edit(Indicateurperformance paramIndicateurperformance);
  
  void remove(Indicateurperformance paramIndicateurperformance);
  
  Indicateurperformance find(Object paramObject);
  
  List<Indicateurperformance> findAll();
  
  List<Indicateurperformance> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateurperformanceFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
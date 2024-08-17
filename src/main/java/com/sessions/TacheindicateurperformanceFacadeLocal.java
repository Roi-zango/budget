package sessions;

import entities.Tacheindicateurperformance;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TacheindicateurperformanceFacadeLocal {
  void create(Tacheindicateurperformance paramTacheindicateurperformance);
  
  void edit(Tacheindicateurperformance paramTacheindicateurperformance);
  
  void remove(Tacheindicateurperformance paramTacheindicateurperformance);
  
  Tacheindicateurperformance find(Object paramObject);
  
  List<Tacheindicateurperformance> findAll();
  
  List<Tacheindicateurperformance> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\TacheindicateurperformanceFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
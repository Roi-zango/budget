package sessions;

import entities.Indicateuractionannee;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IndicateuractionanneeFacadeLocal {
  void create(Indicateuractionannee paramIndicateuractionannee);
  
  void edit(Indicateuractionannee paramIndicateuractionannee);
  
  void remove(Indicateuractionannee paramIndicateuractionannee);
  
  Indicateuractionannee find(Object paramObject);
  
  List<Indicateuractionannee> findAll();
  
  List<Indicateuractionannee> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateuractionanneeFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
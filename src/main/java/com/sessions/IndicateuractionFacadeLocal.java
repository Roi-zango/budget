package sessions;

import entities.Indicateuraction;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IndicateuractionFacadeLocal {
  void create(Indicateuraction paramIndicateuraction);
  
  void edit(Indicateuraction paramIndicateuraction);
  
  void remove(Indicateuraction paramIndicateuraction);
  
  Indicateuraction find(Object paramObject);
  
  List<Indicateuraction> findAll();
  
  List<Indicateuraction> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateuractionFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
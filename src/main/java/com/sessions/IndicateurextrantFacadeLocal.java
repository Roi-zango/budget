package sessions;

import entities.Indicateurextrant;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IndicateurextrantFacadeLocal {
  void create(Indicateurextrant paramIndicateurextrant);
  
  void edit(Indicateurextrant paramIndicateurextrant);
  
  void remove(Indicateurextrant paramIndicateurextrant);
  
  Indicateurextrant find(Object paramObject);
  
  List<Indicateurextrant> findAll();
  
  List<Indicateurextrant> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateurextrantFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
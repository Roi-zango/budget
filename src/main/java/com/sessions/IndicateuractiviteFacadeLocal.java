package sessions;

import entities.Indicateuractivite;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IndicateuractiviteFacadeLocal {
  void create(Indicateuractivite paramIndicateuractivite);
  
  void edit(Indicateuractivite paramIndicateuractivite);
  
  void remove(Indicateuractivite paramIndicateuractivite);
  
  Indicateuractivite find(Object paramObject);
  
  List<Indicateuractivite> findAll();
  
  List<Indicateuractivite> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateuractiviteFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
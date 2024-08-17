package sessions;

import entities.Indicateuractiviteannee;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IndicateuractiviteanneeFacadeLocal {
  void create(Indicateuractiviteannee paramIndicateuractiviteannee);
  
  void edit(Indicateuractiviteannee paramIndicateuractiviteannee);
  
  void remove(Indicateuractiviteannee paramIndicateuractiviteannee);
  
  Indicateuractiviteannee find(Object paramObject);
  
  List<Indicateuractiviteannee> findAll();
  
  List<Indicateuractiviteannee> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateuractiviteanneeFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
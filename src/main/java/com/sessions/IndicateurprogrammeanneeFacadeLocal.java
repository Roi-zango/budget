package sessions;

import entities.Indicateurprogrammeannee;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IndicateurprogrammeanneeFacadeLocal {
  void create(Indicateurprogrammeannee paramIndicateurprogrammeannee);
  
  void edit(Indicateurprogrammeannee paramIndicateurprogrammeannee);
  
  void remove(Indicateurprogrammeannee paramIndicateurprogrammeannee);
  
  Indicateurprogrammeannee find(Object paramObject);
  
  List<Indicateurprogrammeannee> findAll();
  
  List<Indicateurprogrammeannee> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateurprogrammeanneeFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
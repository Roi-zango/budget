package sessions;

import entities.Indicateurprogramme;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IndicateurprogrammeFacadeLocal {
  void create(Indicateurprogramme paramIndicateurprogramme);
  
  void edit(Indicateurprogramme paramIndicateurprogramme);
  
  void remove(Indicateurprogramme paramIndicateurprogramme);
  
  Indicateurprogramme find(Object paramObject);
  
  List<Indicateurprogramme> findAll();
  
  List<Indicateurprogramme> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\IndicateurprogrammeFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
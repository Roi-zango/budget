package sessions;

import entities.Revueprogramme;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RevueprogrammeFacadeLocal {
  void create(Revueprogramme paramRevueprogramme);
  
  void edit(Revueprogramme paramRevueprogramme);
  
  void remove(Revueprogramme paramRevueprogramme);
  
  Revueprogramme find(Object paramObject);
  
  List<Revueprogramme> findAll();
  
  List<Revueprogramme> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RevueprogrammeFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
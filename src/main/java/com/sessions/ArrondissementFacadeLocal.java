package sessions;

import entities.Arrondissement;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ArrondissementFacadeLocal {
  void create(Arrondissement paramArrondissement);
  
  void edit(Arrondissement paramArrondissement);
  
  void remove(Arrondissement paramArrondissement);
  
  Arrondissement find(Object paramObject);
  
  List<Arrondissement> findAll();
  
  List<Arrondissement> findRange(int[] paramArrayOfint);
  
  int count();
  
  List<Arrondissement> findByIddepartement(Long paramLong);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ArrondissementFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
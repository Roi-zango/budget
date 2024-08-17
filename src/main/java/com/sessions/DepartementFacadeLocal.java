package sessions;

import entities.Departement;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DepartementFacadeLocal {
  void create(Departement paramDepartement);
  
  void edit(Departement paramDepartement);
  
  void remove(Departement paramDepartement);
  
  Departement find(Object paramObject);
  
  List<Departement> findAll();
  
  List<Departement> findRange(int[] paramArrayOfint);
  
  int count();
  
  List<Departement> findByIdregion(Long paramLong);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\DepartementFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
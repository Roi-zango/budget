package sessions;

import entities.Institution;
import java.util.List;
import javax.ejb.Local;

@Local
public interface InstitutionFacadeLocal {
  void create(Institution paramInstitution);
  
  void edit(Institution paramInstitution);
  
  void remove(Institution paramInstitution);
  
  Institution find(Object paramObject);
  
  List<Institution> findAll();
  
  List<Institution> findRange(int[] paramArrayOfint);
  
  int count();
  
  Long nextId();
  
  List<Institution> findAllEtatIsActif();
  
  List<Institution> findAllRange();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\InstitutionFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
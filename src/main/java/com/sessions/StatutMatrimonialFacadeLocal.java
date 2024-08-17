package sessions;

import entities.StatutMatrimonial;
import java.util.List;
import javax.ejb.Local;

@Local
public interface StatutMatrimonialFacadeLocal {
  void create(StatutMatrimonial paramStatutMatrimonial);
  
  void edit(StatutMatrimonial paramStatutMatrimonial);
  
  void remove(StatutMatrimonial paramStatutMatrimonial);
  
  StatutMatrimonial find(Object paramObject);
  
  List<StatutMatrimonial> findAll();
  
  List<StatutMatrimonial> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\StatutMatrimonialFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
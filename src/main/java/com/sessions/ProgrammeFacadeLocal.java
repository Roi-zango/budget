package sessions;

import entities.Programme;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProgrammeFacadeLocal {
  void create(Programme paramProgramme);
  
  void edit(Programme paramProgramme);
  
  void remove(Programme paramProgramme);
  
  Programme find(Object paramObject);
  
  List<Programme> findAll();
  
  List<Programme> findRange(int[] paramArrayOfint);
  
  int count();
  
  Long nextId();
  
  List<Programme> findByIdinstitution(long paramLong);
  
  List<Programme> findByIdinstitutionEtat(long paramLong, String paramString);
  
  Programme findByIdinstitution(long paramLong, String paramString);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ProgrammeFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
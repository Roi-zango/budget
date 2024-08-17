package sessions;

import entities.Structure;
import java.util.List;
import javax.ejb.Local;

@Local
public interface StructureFacadeLocal {
  void create(Structure paramStructure);
  
  void edit(Structure paramStructure);
  
  void remove(Structure paramStructure);
  
  Structure find(Object paramObject);
  
  List<Structure> findAll();
  
  List<Structure> findRange(int[] paramArrayOfint);
  
  int count();
  
  Long nextId();
  
  List<Structure> findAllRange();
  
  List<Structure> findAllRangeEtatInstitutionIsActif();
  
  List<Structure> findByIdinstitution(long paramLong);
  
  List<Structure> findByIdinstitution(long paramLong, String paramString);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\StructureFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
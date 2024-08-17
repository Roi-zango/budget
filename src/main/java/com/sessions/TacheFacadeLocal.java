package sessions;

import entities.Tache;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TacheFacadeLocal {
  void create(Tache paramTache);
  
  void edit(Tache paramTache);
  
  void remove(Tache paramTache);
  
  Tache find(Object paramObject);
  
  List<Tache> findAll();
  
  List<Tache> findRange(int[] paramArrayOfint);
  
  int count();
  
  Long nextId();
  
  List<Tache> findByStructureAnnee(long paramLong1, long paramLong2);
  
  List<Tache> findByIdInstitutionIdAnnee(long paramLong1, long paramLong2);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\TacheFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package sessions;

import entities.Annee;
import entities.Moyens;
import entities.Structure;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MoyensFacadeLocal {
  void create(Moyens paramMoyens);
  
  void edit(Moyens paramMoyens);
  
  void remove(Moyens paramMoyens);
  
  Moyens find(Object paramObject);
  
  List<Moyens> findAll();
  
  List<Moyens> findRange(int[] paramArrayOfint);
  
  int count();
  
  Integer nextId();
  
  List<Moyens> findByStructureAnnee(Structure paramStructure, Annee paramAnnee);
  
  List<Moyens> findByTache(long paramLong) throws Exception;
  
  List<Moyens> findByStructureAnneeIdimputation(Long paramLong1, Long paramLong2, Long paramLong3);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\MoyensFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
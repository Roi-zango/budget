package sessions;

import entities.Lignedecision;
import java.util.List;
import javax.ejb.Local;

@Local
public interface LignedecisionFacadeLocal {
  void create(Lignedecision paramLignedecision);
  
  void edit(Lignedecision paramLignedecision);
  
  void remove(Lignedecision paramLignedecision);
  
  Lignedecision find(Object paramObject);
  
  List<Lignedecision> findAll();
  
  List<Lignedecision> findRange(int[] paramArrayOfint);
  
  int count();
  
  long nextId();
  
  void deleteByIdBoncommande(long paramLong);
  
  List<Lignedecision> findByIdBoncommande(long paramLong);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\LignedecisionFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
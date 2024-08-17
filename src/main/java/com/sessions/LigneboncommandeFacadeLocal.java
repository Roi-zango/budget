package sessions;

import entities.Ligneboncommande;
import java.util.List;
import javax.ejb.Local;

@Local
public interface LigneboncommandeFacadeLocal {
  void create(Ligneboncommande paramLigneboncommande);
  
  void edit(Ligneboncommande paramLigneboncommande);
  
  void remove(Ligneboncommande paramLigneboncommande);
  
  Ligneboncommande find(Object paramObject);
  
  List<Ligneboncommande> findAll();
  
  List<Ligneboncommande> findRange(int[] paramArrayOfint);
  
  int count();
  
  long nextId();
  
  void deleteByIdBoncommande(long paramLong);
  
  List<Ligneboncommande> findByIdBoncommande(long paramLong);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\LigneboncommandeFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package sessions;

import entities.Typestructure;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TypestructureFacadeLocal {
  void create(Typestructure paramTypestructure);
  
  void edit(Typestructure paramTypestructure);
  
  void remove(Typestructure paramTypestructure);
  
  Typestructure find(Object paramObject);
  
  List<Typestructure> findAll();
  
  List<Typestructure> findRange(int[] paramArrayOfint);
  
  int count();
  
  List<Typestructure> findAllRange();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\TypestructureFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
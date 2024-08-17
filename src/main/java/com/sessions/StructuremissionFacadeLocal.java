package sessions;

import entities.Structuremission;
import java.util.List;
import javax.ejb.Local;

@Local
public interface StructuremissionFacadeLocal {
  void create(Structuremission paramStructuremission);
  
  void edit(Structuremission paramStructuremission);
  
  void remove(Structuremission paramStructuremission);
  
  Structuremission find(Object paramObject);
  
  List<Structuremission> findAll();
  
  List<Structuremission> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\StructuremissionFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
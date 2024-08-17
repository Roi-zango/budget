package sessions;

import entities.Structuremissionactivite;
import java.util.List;
import javax.ejb.Local;

@Local
public interface StructuremissionactiviteFacadeLocal {
  void create(Structuremissionactivite paramStructuremissionactivite);
  
  void edit(Structuremissionactivite paramStructuremissionactivite);
  
  void remove(Structuremissionactivite paramStructuremissionactivite);
  
  Structuremissionactivite find(Object paramObject);
  
  List<Structuremissionactivite> findAll();
  
  List<Structuremissionactivite> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\StructuremissionactiviteFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package sessions;

import entities.Basejuridique;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BasejuridiqueFacadeLocal {
  void create(Basejuridique paramBasejuridique);
  
  void edit(Basejuridique paramBasejuridique);
  
  void remove(Basejuridique paramBasejuridique);
  
  Basejuridique find(Object paramObject);
  
  List<Basejuridique> findAll();
  
  List<Basejuridique> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\BasejuridiqueFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
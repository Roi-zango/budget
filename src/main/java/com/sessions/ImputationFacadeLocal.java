package sessions;

import entities.Imputation;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ImputationFacadeLocal {
  void create(Imputation paramImputation);
  
  void edit(Imputation paramImputation);
  
  void remove(Imputation paramImputation);
  
  Imputation find(Object paramObject);
  
  List<Imputation> findAll();
  
  List<Imputation> findRange(int[] paramArrayOfint);
  
  int count();
  
  List<Imputation> find(int paramInt1, int paramInt2);
  
  List<Imputation> findAllOrder();
  
  long nextId();
  
  List<Imputation> findAllOrder(String paramString);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ImputationFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
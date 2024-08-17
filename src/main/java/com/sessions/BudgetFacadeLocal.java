package sessions;

import entities.Budget;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BudgetFacadeLocal {
  void create(Budget paramBudget);
  
  void edit(Budget paramBudget);
  
  void remove(Budget paramBudget);
  
  Budget find(Object paramObject);
  
  List<Budget> findAll();
  
  List<Budget> findRange(int[] paramArrayOfint);
  
  int count();
  
  Integer nextId();
  
  Budget findByNom(String paramString);
  
  List<Budget> findAllRange();
  
  Budget findByAnnee(String paramString);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\BudgetFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
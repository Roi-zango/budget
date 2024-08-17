package sessions;

import entities.Rubriquedifficulte;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RubriquedifficulteFacadeLocal {
  void create(Rubriquedifficulte paramRubriquedifficulte);
  
  void edit(Rubriquedifficulte paramRubriquedifficulte);
  
  void remove(Rubriquedifficulte paramRubriquedifficulte);
  
  Rubriquedifficulte find(Object paramObject);
  
  List<Rubriquedifficulte> findAll();
  
  List<Rubriquedifficulte> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RubriquedifficulteFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
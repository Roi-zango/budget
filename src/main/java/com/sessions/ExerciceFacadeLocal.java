package sessions;

import entities.Exercice;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ExerciceFacadeLocal {
  void create(Exercice paramExercice);
  
  void edit(Exercice paramExercice);
  
  void remove(Exercice paramExercice);
  
  Exercice find(Object paramObject);
  
  List<Exercice> findAll();
  
  List<Exercice> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ExerciceFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
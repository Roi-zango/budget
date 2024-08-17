package sessions;

import entities.ExerciceNatureT;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ExerciceNatureTFacadeLocal {
  void create(ExerciceNatureT paramExerciceNatureT);
  
  void edit(ExerciceNatureT paramExerciceNatureT);
  
  void remove(ExerciceNatureT paramExerciceNatureT);
  
  ExerciceNatureT find(Object paramObject);
  
  List<ExerciceNatureT> findAll();
  
  List<ExerciceNatureT> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ExerciceNatureTFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
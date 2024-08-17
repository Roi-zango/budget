package sessions;

import entities.ExerciceNature;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ExerciceNatureFacadeLocal {
  void create(ExerciceNature paramExerciceNature);
  
  void edit(ExerciceNature paramExerciceNature);
  
  void remove(ExerciceNature paramExerciceNature);
  
  ExerciceNature find(Object paramObject);
  
  List<ExerciceNature> findAll();
  
  List<ExerciceNature> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ExerciceNatureFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
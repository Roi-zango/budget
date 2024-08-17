package sessions;

import entities.ExerciceProgramme;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ExerciceProgrammeFacadeLocal {
  void create(ExerciceProgramme paramExerciceProgramme);
  
  void edit(ExerciceProgramme paramExerciceProgramme);
  
  void remove(ExerciceProgramme paramExerciceProgramme);
  
  ExerciceProgramme find(Object paramObject);
  
  List<ExerciceProgramme> findAll();
  
  List<ExerciceProgramme> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ExerciceProgrammeFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
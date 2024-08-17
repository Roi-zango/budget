package sessions;

import entities.Annee;
import entities.Imputation;
import entities.Recette;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RecetteFacadeLocal {
  void create(Recette paramRecette);
  
  void edit(Recette paramRecette);
  
  void remove(Recette paramRecette);
  
  Recette find(Object paramObject);
  
  List<Recette> findAll();
  
  List<Recette> findRange(int[] paramArrayOfint);
  
  int count();
  
  Long nextId();
  
  Recette findByImputationAnne(Imputation paramImputation, Annee paramAnnee) throws Exception;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RecetteFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
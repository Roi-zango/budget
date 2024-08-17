package sessions;

import entities.Sousrubrique;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SousrubriqueFacadeLocal {
  void create(Sousrubrique paramSousrubrique);
  
  void edit(Sousrubrique paramSousrubrique);
  
  void remove(Sousrubrique paramSousrubrique);
  
  Sousrubrique find(Object paramObject);
  
  List<Sousrubrique> findAll();
  
  List<Sousrubrique> findRange(int[] paramArrayOfint);
  
  int count();
  
  List<Sousrubrique> findByRubrique(int paramInt);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SousrubriqueFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package sessions;

import entities.Secteur;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SecteurFacadeLocal {
  void create(Secteur paramSecteur);
  
  void edit(Secteur paramSecteur);
  
  void remove(Secteur paramSecteur);
  
  Secteur find(Object paramObject);
  
  List<Secteur> findAll();
  
  List<Secteur> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SecteurFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
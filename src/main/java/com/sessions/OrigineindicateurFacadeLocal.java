package sessions;

import entities.Origineindicateur;
import java.util.List;
import javax.ejb.Local;

@Local
public interface OrigineindicateurFacadeLocal {
  void create(Origineindicateur paramOrigineindicateur);
  
  void edit(Origineindicateur paramOrigineindicateur);
  
  void remove(Origineindicateur paramOrigineindicateur);
  
  Origineindicateur find(Object paramObject);
  
  List<Origineindicateur> findAll();
  
  List<Origineindicateur> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\OrigineindicateurFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
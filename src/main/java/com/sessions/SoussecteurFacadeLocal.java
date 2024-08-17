package sessions;

import entities.Soussecteur;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SoussecteurFacadeLocal {
  void create(Soussecteur paramSoussecteur);
  
  void edit(Soussecteur paramSoussecteur);
  
  void remove(Soussecteur paramSoussecteur);
  
  Soussecteur find(Object paramObject);
  
  List<Soussecteur> findAll();
  
  List<Soussecteur> findRange(int[] paramArrayOfint);
  
  int count();
  
  List<Soussecteur> findAllRange();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SoussecteurFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package sessions;

import entities.Adresse;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AdresseFacadeLocal {
  void create(Adresse paramAdresse);
  
  void edit(Adresse paramAdresse);
  
  void remove(Adresse paramAdresse);
  
  Adresse find(Object paramObject);
  
  List<Adresse> findAll();
  
  List<Adresse> findRange(int[] paramArrayOfint);
  
  int count();
  
  long nextId();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\AdresseFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
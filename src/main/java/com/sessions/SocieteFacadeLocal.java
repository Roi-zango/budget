package sessions;

import entities.Societe;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SocieteFacadeLocal {
  void create(Societe paramSociete);
  
  void edit(Societe paramSociete);
  
  void remove(Societe paramSociete);
  
  Societe find(Object paramObject);
  
  List<Societe> findAll();
  
  List<Societe> findRange(int[] paramArrayOfint);
  
  int count();
  
  int nextId();
  
  Societe findByNuid(String paramString);
  
  List<Societe> findAllRange();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SocieteFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
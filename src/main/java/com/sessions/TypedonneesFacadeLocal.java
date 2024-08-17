package sessions;

import entities.Typedonnees;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TypedonneesFacadeLocal {
  void create(Typedonnees paramTypedonnees);
  
  void edit(Typedonnees paramTypedonnees);
  
  void remove(Typedonnees paramTypedonnees);
  
  Typedonnees find(Object paramObject);
  
  List<Typedonnees> findAll();
  
  List<Typedonnees> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\TypedonneesFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
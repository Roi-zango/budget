package sessions;

import entities.Cdmt;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CdmtFacadeLocal {
  void create(Cdmt paramCdmt);
  
  void edit(Cdmt paramCdmt);
  
  void remove(Cdmt paramCdmt);
  
  Cdmt find(Object paramObject);
  
  List<Cdmt> findAll();
  
  List<Cdmt> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\CdmtFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
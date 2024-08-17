package sessions;

import entities.CdmtTache;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CdmtTacheFacadeLocal {
  void create(CdmtTache paramCdmtTache);
  
  void edit(CdmtTache paramCdmtTache);
  
  void remove(CdmtTache paramCdmtTache);
  
  CdmtTache find(Object paramObject);
  
  List<CdmtTache> findAll();
  
  List<CdmtTache> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\CdmtTacheFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
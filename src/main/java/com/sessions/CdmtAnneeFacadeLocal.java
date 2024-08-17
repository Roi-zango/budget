package sessions;

import entities.CdmtAnnee;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CdmtAnneeFacadeLocal {
  void create(CdmtAnnee paramCdmtAnnee);
  
  void edit(CdmtAnnee paramCdmtAnnee);
  
  void remove(CdmtAnnee paramCdmtAnnee);
  
  CdmtAnnee find(Object paramObject);
  
  List<CdmtAnnee> findAll();
  
  List<CdmtAnnee> findRange(int[] paramArrayOfint);
  
  int count();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\CdmtAnneeFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
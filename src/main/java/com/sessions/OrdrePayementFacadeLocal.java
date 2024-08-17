package sessions;

import entities.OrdrePayement;
import java.util.List;
import javax.ejb.Local;

@Local
public interface OrdrePayementFacadeLocal {
  void create(OrdrePayement paramOrdrePayement);
  
  void edit(OrdrePayement paramOrdrePayement);
  
  void remove(OrdrePayement paramOrdrePayement);
  
  OrdrePayement find(Object paramObject);
  
  List<OrdrePayement> findAll();
  
  List<OrdrePayement> findRange(int[] paramArrayOfint);
  
  int count();
  
  long nextId();
  
  long nextIdOp(int paramInt);
  
  List<OrdrePayement> findAll(long paramLong, int paramInt);
  
  List<OrdrePayement> findAllEtat(long paramLong, int paramInt, boolean paramBoolean);
  
  List<OrdrePayement> findAllBc(int paramInt);
  
  List<OrdrePayement> findAllLc(int paramInt);
  
  List<OrdrePayement> findAllEtatPaid(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\OrdrePayementFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
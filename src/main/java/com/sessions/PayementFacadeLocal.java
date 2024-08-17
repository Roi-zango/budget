package sessions;

import entities.Payement;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PayementFacadeLocal {
  void create(Payement paramPayement);
  
  void edit(Payement paramPayement);
  
  void remove(Payement paramPayement);
  
  Payement find(Object paramObject);
  
  List<Payement> findAll();
  
  List<Payement> findRange(int[] paramArrayOfint);
  
  int count();
  
  long nextId();
  
  List<Payement> findByIdAnnee(Long paramLong, int paramInt);
  
  Payement findByIdVirement(int paramInt);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\PayementFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
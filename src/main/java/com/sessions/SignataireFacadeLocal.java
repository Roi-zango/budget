package sessions;

import entities.Signataire;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SignataireFacadeLocal {
  void create(Signataire paramSignataire);
  
  void edit(Signataire paramSignataire);
  
  void remove(Signataire paramSignataire);
  
  Signataire find(Object paramObject);
  
  List<Signataire> findAll();
  
  List<Signataire> findRange(int[] paramArrayOfint);
  
  int count();
  
  int nextId();
  
  List<Signataire> findAllRangeEtatInstitutionIsActif();
  
  List<Signataire> findByIdInstitution(long paramLong);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SignataireFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
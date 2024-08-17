package sessions;

import entities.Certificatengagement;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CertificatengagementFacadeLocal {
  void create(Certificatengagement paramCertificatengagement);
  
  void edit(Certificatengagement paramCertificatengagement);
  
  void remove(Certificatengagement paramCertificatengagement);
  
  Certificatengagement find(Object paramObject);
  
  List<Certificatengagement> findAll();
  
  List<Certificatengagement> findRange(int[] paramArrayOfint);
  
  int count();
  
  long nextId();
  
  List<Certificatengagement> findByIdAnnee(Long paramLong, int paramInt);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\CertificatengagementFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
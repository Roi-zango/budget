package sessions;

import entities.Verificationbc;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

@Local
public interface VerificationbcFacadeLocal {
  void create(Verificationbc paramVerificationbc);
  
  void edit(Verificationbc paramVerificationbc);
  
  void remove(Verificationbc paramVerificationbc);
  
  Verificationbc find(Object paramObject);
  
  List<Verificationbc> findAll();
  
  List<Verificationbc> findRange(int[] paramArrayOfint);
  
  int count();
  
  long nextId();
  
  List<Verificationbc> findByIdAnneeBc(Long paramLong, int paramInt);
  
  List<Verificationbc> findByIdAnneeSal(Long paramLong, int paramInt);
  
  List<Verificationbc> findByIdAnneeLc(Long paramLong, int paramInt);
  
  List<Verificationbc> findByIdAnneeDec(Long paramLong, int paramInt);
  
  List<Verificationbc> findByIdAnnee(Long paramLong, int paramInt, Date paramDate1, Date paramDate2);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\VerificationbcFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
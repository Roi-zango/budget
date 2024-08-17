package sessions;

import entities.Boncommande;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BoncommandeFacadeLocal {
  void create(Boncommande paramBoncommande);
  
  void edit(Boncommande paramBoncommande);
  
  void remove(Boncommande paramBoncommande);
  
  Boncommande find(Object paramObject);
  
  List<Boncommande> findAll();
  
  List<Boncommande> findRange(int[] paramArrayOfint);
  
  int count();
  
  long nextId();
  
  long nextIdBC(int paramInt);
  
  long nextIdBC(int paramInt, long paramLong);
  
  long nextIdLC(int paramInt);
  
  long nextIdDE(int paramInt);
  
  long nextIdSA(int paramInt);
  
  Boncommande findByCode(Long paramLong, String paramString);
  
  List<Boncommande> findByIdAnnee(Long paramLong, int paramInt);
  
  List<Boncommande> findByIdAnneeBc(Long paramLong, int paramInt);
  
  List<Boncommande> findByIdAnneeMis(Long paramLong, int paramInt);
  
  List<Boncommande> findByIdAnneeSal(Long paramLong, int paramInt);
  
  List<Boncommande> findByIdAnneeEngageIsFalse(Long paramLong, int paramInt);
  
  List<Boncommande> findByIdAnneeEngageNotvalidated(Long paramLong, int paramInt);
  
  List<Boncommande> findByIdAnneeBcNotValidated(Long paramLong, int paramInt);
  
  List<Boncommande> findByIdAnneeBc(Long paramLong, int paramInt, boolean paramBoolean);
  
  List<Boncommande> findByIdAnneeLc(Long paramLong, int paramInt, boolean paramBoolean);
  
  List<Boncommande> findByIdAnneeDec(Long paramLong, int paramInt, boolean paramBoolean);
  
  List<Boncommande> findByIdAnneeSal(Long paramLong, int paramInt, boolean paramBoolean);
  
  List<Boncommande> findByIdAnneeMis(Long paramLong, int paramInt, boolean paramBoolean);
  
  List<Boncommande> findByIdAnneeValidated(Long paramLong, int paramInt, boolean paramBoolean);
  
  List<Boncommande> findByIdAnneeMisNotValidated(Long paramLong, int paramInt);
  
  List<Boncommande> findByIdAnneeLc(Long paramLong, int paramInt);
  
  List<Boncommande> findByIdAnneeDec(Long paramLong, int paramInt);
  
  List<Boncommande> findByIdAnneeLcNotValidated(Long paramLong, int paramInt);
  
  List<Boncommande> findByIdAnneeDecNotValidated(Long paramLong, int paramInt);
  
  List<Boncommande> findByIdAnneeValidatedNotPayed(Long paramLong, int paramInt);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\BoncommandeFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package sessions;

import entities.Compte;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CompteFacadeLocal {
  void create(Compte paramCompte);
  
  void edit(Compte paramCompte);
  
  void remove(Compte paramCompte);
  
  Compte find(Object paramObject);
  
  List<Compte> findAll();
  
  List<Compte> findRange(int[] paramArrayOfint);
  
  int count();
  
  long nextId();
  
  Compte connexion(Compte paramCompte);
  
  List<Compte> findByEtat(String paramString);
  
  Compte findByIdutilisateur(long paramLong);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\CompteFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
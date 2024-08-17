package sessions;

import entities.Utilisateur;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UtilisateurFacadeLocal {
  void create(Utilisateur paramUtilisateur);
  
  void edit(Utilisateur paramUtilisateur);
  
  void remove(Utilisateur paramUtilisateur);
  
  Utilisateur find(Object paramObject);
  
  List<Utilisateur> findAll();
  
  List<Utilisateur> findRange(int[] paramArrayOfint);
  
  int count();
  
  long nextId();
  
  List<Utilisateur> findByEtat(String paramString);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\UtilisateurFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
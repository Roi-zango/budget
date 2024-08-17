package sessions;

import entities.Sousrubriquemercurial;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SousrubriquemercurialFacadeLocal {
  void create(Sousrubriquemercurial paramSousrubriquemercurial);
  
  void edit(Sousrubriquemercurial paramSousrubriquemercurial);
  
  void remove(Sousrubriquemercurial paramSousrubriquemercurial);
  
  Sousrubriquemercurial find(Object paramObject);
  
  List<Sousrubriquemercurial> findAll();
  
  List<Sousrubriquemercurial> findRange(int[] paramArrayOfint);
  
  int count();
  
  int nextId();
  
  Sousrubriquemercurial findByCode(int paramInt, String paramString) throws Exception;
  
  List<Sousrubriquemercurial> findAllRange();
  
  List<Sousrubriquemercurial> findByIdrubrique(int paramInt);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SousrubriquemercurialFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
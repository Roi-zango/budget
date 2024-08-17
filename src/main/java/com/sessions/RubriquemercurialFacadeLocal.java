package sessions;

import entities.Rubriquemercurial;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RubriquemercurialFacadeLocal {
  void create(Rubriquemercurial paramRubriquemercurial);
  
  void edit(Rubriquemercurial paramRubriquemercurial);
  
  void remove(Rubriquemercurial paramRubriquemercurial);
  
  Rubriquemercurial find(Object paramObject);
  
  List<Rubriquemercurial> findAll();
  
  List<Rubriquemercurial> findRange(int[] paramArrayOfint);
  
  int count();
  
  int nextId();
  
  Rubriquemercurial findByCode(String paramString) throws Exception;
  
  List<Rubriquemercurial> findAllRange();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\RubriquemercurialFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
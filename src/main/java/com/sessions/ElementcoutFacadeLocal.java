package sessions;

import entities.Elementcout;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ElementcoutFacadeLocal {
  void create(Elementcout paramElementcout);
  
  void edit(Elementcout paramElementcout);
  
  void remove(Elementcout paramElementcout);
  
  Elementcout find(Object paramObject);
  
  List<Elementcout> findAll();
  
  List<Elementcout> findRange(int[] paramArrayOfint);
  
  int count();
  
  int nextId();
  
  Elementcout findByCode(String paramString) throws Exception;
  
  List<Elementcout> findAllRange();
  
  List<Elementcout> findByIdimputation(long paramLong);
  
  List<Elementcout> findByIdimputationIdrubrique(long paramLong, int paramInt);
  
  List<Elementcout> findByIdimputationIdsousrubrique(long paramLong, int paramInt);
  
  List<Elementcout> findByIdrubrique(int paramInt);
  
  List<Elementcout> findByIdsousrubrique(int paramInt);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ElementcoutFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
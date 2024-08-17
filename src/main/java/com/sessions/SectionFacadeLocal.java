package sessions;

import entities.Section;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SectionFacadeLocal {
  void create(Section paramSection);
  
  void edit(Section paramSection);
  
  void remove(Section paramSection);
  
  Section find(Object paramObject);
  
  List<Section> findAll();
  
  List<Section> findRange(int[] paramArrayOfint);
  
  int count();
  
  int nextId();
  
  Section findByCode(String paramString) throws Exception;
  
  List<Section> findAllRange();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\SectionFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
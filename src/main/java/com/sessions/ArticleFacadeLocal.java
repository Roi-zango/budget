package sessions;

import entities.Article;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ArticleFacadeLocal {
  void create(Article paramArticle);
  
  void edit(Article paramArticle);
  
  void remove(Article paramArticle);
  
  Article find(Object paramObject);
  
  List<Article> findAll();
  
  List<Article> findRange(int[] paramArrayOfint);
  
  int count();
  
  int nextId();
  
  Article findByCode(String paramString) throws Exception;
  
  List<Article> findAllRange();
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\ArticleFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Article.class)
public class Article_ {
  public static volatile SingularAttribute<Article, String> code;
  
  public static volatile SingularAttribute<Article, Integer> idarticle;
  
  public static volatile SingularAttribute<Article, String> nom;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Article_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
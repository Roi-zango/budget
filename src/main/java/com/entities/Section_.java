package entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Section.class)
public class Section_ {
  public static volatile SingularAttribute<Section, String> code;
  
  public static volatile SingularAttribute<Section, Integer> idsection;
  
  public static volatile SingularAttribute<Section, String> nom;
  
  public static volatile SingularAttribute<Section, Article> article;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Section_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
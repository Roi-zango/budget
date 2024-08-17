package entities;

import java.math.BigInteger;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Menu.class)
public class Menu_ {
  public static volatile SingularAttribute<Menu, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Menu, String> shortcut;
  
  public static volatile SingularAttribute<Menu, String> categorie;
  
  public static volatile SingularAttribute<Menu, String> libelle;
  
  public static volatile SingularAttribute<Menu, Date> derniereModif;
  
  public static volatile SingularAttribute<Menu, Long> idMenu;
  
  public static volatile SingularAttribute<Menu, String> name;
  
  public static volatile SingularAttribute<Menu, String> etat;
  
  public static volatile SingularAttribute<Menu, BigInteger> idParent;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Menu_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
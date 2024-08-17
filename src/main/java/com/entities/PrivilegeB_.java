package entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PrivilegeB.class)
public class PrivilegeB_ {
  public static volatile SingularAttribute<PrivilegeB, Long> idprivilegeB;
  
  public static volatile SingularAttribute<PrivilegeB, MenuB> menu;
  
  public static volatile SingularAttribute<PrivilegeB, Compte> compte;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\PrivilegeB_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
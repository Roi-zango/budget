package entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Structuremissionactivite.class)
public class Structuremissionactivite_ {
  public static volatile SingularAttribute<Structuremissionactivite, Activite> activite;
  
  public static volatile SingularAttribute<Structuremissionactivite, Structuremission> structuremission;
  
  public static volatile SingularAttribute<Structuremissionactivite, StructuremissionactivitePK> structuremissionactivitePK;
  
  public static volatile SingularAttribute<Structuremissionactivite, String> objectif;
  
  public static volatile ListAttribute<Structuremissionactivite, Performance> performanceList;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Structuremissionactivite_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
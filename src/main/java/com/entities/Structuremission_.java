package entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Structuremission.class)
public class Structuremission_ {
  public static volatile SingularAttribute<Structuremission, Mission> mission;
  
  public static volatile SingularAttribute<Structuremission, StructuremissionPK> structuremissionPK;
  
  public static volatile SingularAttribute<Structuremission, String> objectif;
  
  public static volatile SingularAttribute<Structuremission, String> problemes;
  
  public static volatile ListAttribute<Structuremission, Structuremissionactivite> structuremissionactiviteList;
  
  public static volatile SingularAttribute<Structuremission, Structure> structure;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Structuremission_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
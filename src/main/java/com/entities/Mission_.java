package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Mission.class)
public class Mission_ {
  public static volatile SingularAttribute<Mission, String> code;
  
  public static volatile SingularAttribute<Mission, String> observation;
  
  public static volatile ListAttribute<Mission, Structuremission> structuremissionList;
  
  public static volatile SingularAttribute<Mission, String> problemes;
  
  public static volatile SingularAttribute<Mission, String> objectspecifique;
  
  public static volatile SingularAttribute<Mission, String> nom;
  
  public static volatile SingularAttribute<Mission, String> etat;
  
  public static volatile SingularAttribute<Mission, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Mission, Long> idmission;
  
  public static volatile SingularAttribute<Mission, Date> derniereModif;
  
  public static volatile SingularAttribute<Mission, Basejuridique> idbasejuridique;
  
  public static volatile SingularAttribute<Mission, String> objectgeneral;
  
  public static volatile SingularAttribute<Mission, Niveaupyramide> idniveaupyramide;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Mission_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
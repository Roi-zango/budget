package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Niveaupyramide.class)
public class Niveaupyramide_ {
  public static volatile SingularAttribute<Niveaupyramide, Date> dateEnregistre;
  
  public static volatile ListAttribute<Niveaupyramide, Indicateurperformance> indicateurperformanceList;
  
  public static volatile SingularAttribute<Niveaupyramide, String> code;
  
  public static volatile ListAttribute<Niveaupyramide, Mission> missionList;
  
  public static volatile ListAttribute<Niveaupyramide, Structure> structureList;
  
  public static volatile SingularAttribute<Niveaupyramide, Date> derniereModif;
  
  public static volatile ListAttribute<Niveaupyramide, Pyramide> pyramideList;
  
  public static volatile SingularAttribute<Niveaupyramide, Long> idniveaupyramide;
  
  public static volatile SingularAttribute<Niveaupyramide, String> nom;
  
  public static volatile SingularAttribute<Niveaupyramide, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Niveaupyramide_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
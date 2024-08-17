package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Bailleurfond.class)
public class Bailleurfond_ {
  public static volatile SingularAttribute<Bailleurfond, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Bailleurfond, Sourcefinancement> idsourcefinancement;
  
  public static volatile SingularAttribute<Bailleurfond, Date> derniereModif;
  
  public static volatile ListAttribute<Bailleurfond, Recette> recetteList;
  
  public static volatile ListAttribute<Bailleurfond, Tache> tacheList;
  
  public static volatile SingularAttribute<Bailleurfond, Long> idbailleurfond;
  
  public static volatile SingularAttribute<Bailleurfond, String> nom;
  
  public static volatile SingularAttribute<Bailleurfond, String> etat;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Bailleurfond_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
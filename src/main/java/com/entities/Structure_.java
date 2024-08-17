package entities;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Structure.class)
public class Structure_ {
  public static volatile ListAttribute<Structure, Activite> activiteList;
  
  public static volatile SingularAttribute<Structure, Adresse> idAdresse;
  
  public static volatile SingularAttribute<Structure, String> objectifspecifique;
  
  public static volatile SingularAttribute<Structure, String> nom;
  
  public static volatile SingularAttribute<Structure, String> etat;
  
  public static volatile SingularAttribute<Structure, Rattachement> idrattachement;
  
  public static volatile SingularAttribute<Structure, String> presentation;
  
  public static volatile SingularAttribute<Structure, String> objectifgeneral;
  
  public static volatile SingularAttribute<Structure, String> axeintervention;
  
  public static volatile SingularAttribute<Structure, Double> cordoney;
  
  public static volatile SingularAttribute<Structure, Double> cordonex;
  
  public static volatile SingularAttribute<Structure, Date> derniereModif;
  
  public static volatile SingularAttribute<Structure, String> nomrespo;
  
  public static volatile ListAttribute<Structure, Tache> tacheList;
  
  public static volatile SingularAttribute<Structure, Arrondissement> idarrondissement;
  
  public static volatile SingularAttribute<Structure, Region> idregion;
  
  public static volatile SingularAttribute<Structure, Boolean> pap;
  
  public static volatile ListAttribute<Structure, Utilisateur> utilisateurList;
  
  public static volatile SingularAttribute<Structure, Statutstructure> idstatutstructure;
  
  public static volatile SingularAttribute<Structure, Long> idstructure;
  
  public static volatile SingularAttribute<Structure, Typestructure> idtypestructure;
  
  public static volatile SingularAttribute<Structure, Date> dateouverture;
  
  public static volatile ListAttribute<Structure, Structuremission> structuremissionList;
  
  public static volatile SingularAttribute<Structure, Boolean> actif;
  
  public static volatile SingularAttribute<Structure, String> article;
  
  public static volatile SingularAttribute<Structure, Date> dateEnregistre;
  
  public static volatile SingularAttribute<Structure, String> vision;
  
  public static volatile SingularAttribute<Structure, Pyramide> idpyramide;
  
  public static volatile SingularAttribute<Structure, String> arretecreation;
  
  public static volatile SingularAttribute<Structure, Institution> idinstitution;
  
  public static volatile SingularAttribute<Structure, String> designation;
  
  public static volatile SingularAttribute<Structure, Departement> iddepartement;
  
  public static volatile SingularAttribute<Structure, Niveaupyramide> idniveaupyramide;
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\entities\Structure_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
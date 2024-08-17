package sessions;

import entities.Annee;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AnneeFacadeLocal {
  void create(Annee paramAnnee);
  public void create() {
	    try {
	        if (this.annee != null) {
	            anneeFacadeLocal.create(this.annee);  // Persist the new Annee entity
	            JsfUtil.addSuccessMessage("Entry created successfully.");
	            this.annees = anneeFacadeLocal.findAll();  // Refresh the list of Annee entities
	            this.annee = new Annee();  // Reset the Annee object for new entries
	        } else {
	            JsfUtil.addErrorMessage("No entry to create.");
	        }
	    } catch (Exception e) {
	        JsfUtil.addErrorMessage("Error creating entry.");
	        e.printStackTrace();
	    }
	}

  
  void edit(Annee paramAnnee);
  
  void remove(Annee paramAnnee);
  public void delete() {
	    try {
	        if (this.annee != null) {
	            anneeFacadeLocal.remove(this.annee);  // Remove the selected Annee
	            JsfUtil.addSuccessMessage("Entry deleted successfully.");
	            this.annees = anneeFacadeLocal.findAll();  // Refresh the list of Annee entities
	            this.annee = new Annee();  // Reset the Annee object after deletion
	        } else {
	            JsfUtil.addErrorMessage("No entry selected for deletion.");
	        }
	    } catch (Exception e) {
	        JsfUtil.addErrorMessage("Error deleting entry.");
	        e.printStackTrace();
	    }
	}

  
  Annee find(Object paramObject);
  
  List<Annee> findAll();
  
  List<Annee> findRange(int[] paramArrayOfint);
  
  int count();
  
  List<Annee> findAllRange();
  
  List<Annee> findByEtat(boolean paramBoolean);
  
  List<Annee> findAll(String paramString);
}


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\sessions\AnneeFacadeLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
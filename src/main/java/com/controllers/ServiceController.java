/*     */ package controllers;
/*     */ 
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Adresse;
/*     */ import entities.Arrondissement;
/*     */ import entities.Departement;
/*     */ import entities.Niveaupyramide;
/*     */ import entities.Pyramide;
/*     */ import entities.Rattachement;
/*     */ import entities.Region;
/*     */ import entities.Rue;
/*     */ import entities.Statutstructure;
/*     */ import entities.Structure;
/*     */ import entities.Typestructure;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ViewScoped;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import sessions.AdresseFacadeLocal;
/*     */ import sessions.ArrondissementFacadeLocal;
/*     */ import sessions.DepartementFacadeLocal;
/*     */ import sessions.NiveaupyramideFacadeLocal;
/*     */ import sessions.RegionFacadeLocal;
/*     */ import sessions.RueFacadeLocal;
/*     */ import sessions.StatutstructureFacadeLocal;
/*     */ import sessions.StructureFacadeLocal;
/*     */ import sessions.TypestructureFacadeLocal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ManagedBean
/*     */ @ViewScoped
/*     */ public class ServiceController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private StructureFacadeLocal structureFacadeLocal;
/*  49 */   private Structure structure = new Structure();
/*  50 */   private List<Structure> structures = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private NiveaupyramideFacadeLocal niveaupyramideFacadeLocal;
/*  54 */   private Niveaupyramide niveaupyramide = new Niveaupyramide();
/*  55 */   private List<Niveaupyramide> niveaupyramides = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private TypestructureFacadeLocal typestructureFacadeLocal;
/*  59 */   private Typestructure typestructure = new Typestructure();
/*  60 */   private List<Typestructure> typestructures = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private StatutstructureFacadeLocal statutstructureFacadeLocal;
/*  64 */   private Statutstructure statutstructure = new Statutstructure();
/*  65 */   private List<Statutstructure> statutstructures = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private DepartementFacadeLocal departementFacadeLocal;
/*  69 */   private Departement departement = new Departement();
/*  70 */   private List<Departement> departements = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private ArrondissementFacadeLocal arrondissementFacadeLocal;
/*  74 */   private Arrondissement arrondissement = new Arrondissement();
/*  75 */   private List<Arrondissement> arrondissements = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private RueFacadeLocal rueFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   private AdresseFacadeLocal adresseFacadeLocal;
/*     */   
/*     */   @EJB
/*     */   private RegionFacadeLocal regionFacadeLocal;
/*  85 */   private Region region = new Region();
/*  86 */   private List<Region> regions = new ArrayList<>();
/*     */   
/*  88 */   private String mode = "";
/*  89 */   private String filename = "";
/*  90 */   private String filenameStructure = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  99 */     this.mode = "Create";
/* 100 */     this.structure = new Structure();
/* 101 */     this.structure.setArticle("-");
/* 102 */     this.structure.setAxeintervention("-");
/* 103 */     this.structure.setPresentation("-");
/* 104 */     this.structure.setEtat("Actif");
/* 105 */     this.structure.setActif(Boolean.valueOf(true));
/* 106 */     this.departements.clear();
/* 107 */     this.arrondissements.clear();
/* 108 */     this.region = new Region();
/* 109 */     this.departement = new Departement();
/* 110 */     this.arrondissement = new Arrondissement();
/* 111 */     this.statutstructure = new Statutstructure(Long.valueOf(1L));
/* 112 */     this.typestructure = new Typestructure(Long.valueOf(3L));
/* 113 */     this.niveaupyramide = new Niveaupyramide(Long.valueOf(1L));
/*     */     
/* 115 */     RequestContext.getCurrentInstance().execute("PF('StructureCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/* 119 */     if (this.structure != null) {
/* 120 */       this.mode = "Edit";
/*     */       try {
/* 122 */         this.niveaupyramide = this.structure.getIdniveaupyramide();
/* 123 */         this.region = this.structure.getIdregion();
/* 124 */         this.typestructure = this.structure.getIdtypestructure();
/* 125 */         this.statutstructure = this.structure.getIdstatutstructure();
/* 126 */         this.region = this.structure.getIdregion();
/* 127 */         this.departement = this.structure.getIddepartement();
/* 128 */         this.arrondissement = this.structure.getIdarrondissement();
/*     */         
/* 130 */         this.departements = this.departementFacadeLocal.findByIdregion(this.region.getIdregion());
/* 131 */         this.arrondissements = this.arrondissementFacadeLocal.findByIddepartement(this.departement.getIddepartement());
/* 132 */       } catch (Exception e) {
/* 133 */         e.printStackTrace();
/*     */       } 
/* 135 */       RequestContext.getCurrentInstance().execute("PF('StructureCreateDialog').show()");
/*     */     } else {
/* 137 */       JsfUtil.addWarningMessage("Aucune ligne sélectionnée");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateDepartement() {
/*     */     try {
/* 143 */       this.departements.clear();
/* 144 */       if (this.region.getIdregion() != null) {
/* 145 */         this.departements = this.departementFacadeLocal.findByIdregion(this.region.getIdregion());
/*     */       }
/* 147 */     } catch (Exception e) {
/* 148 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateArrondissement() {
/*     */     try {
/* 154 */       this.arrondissements.clear();
/* 155 */       if (this.departement.getIddepartement() != null) {
/* 156 */         this.arrondissements = this.arrondissementFacadeLocal.findByIddepartement(this.departement.getIddepartement());
/*     */       }
/* 158 */     } catch (Exception e) {
/* 159 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/* 165 */       if ("Create".equals(this.mode)) {
/*     */         
/* 167 */         Adresse adresse = new Adresse();
/* 168 */         Rue r = this.rueFacadeLocal.find(Long.valueOf(1L));
/*     */         
/* 170 */         adresse.setIdAdresse(Long.valueOf(this.adresseFacadeLocal.nextId()));
/* 171 */         r.getIdQuartier().getIdVille();
/* 172 */         adresse.setIdRue(r);
/* 173 */         adresse.setIdQuartier(r.getIdQuartier());
/* 174 */         adresse.setIdVille(r.getIdQuartier().getIdVille());
/* 175 */         this.adresseFacadeLocal.create(adresse);
/*     */         
/* 177 */         this.structure.setIdstructure(this.structureFacadeLocal.nextId());
/* 178 */         this.structure.setIdregion(this.region);
/* 179 */         this.structure.setIdarrondissement(this.arrondissement);
/* 180 */         this.structure.setIddepartement(this.departement);
/* 181 */         this.structure.setIdinstitution(SessionMBean.getInstitution());
/* 182 */         this.structure.setIdAdresse(adresse);
/* 183 */         this.structure.setIdniveaupyramide(this.niveaupyramide);
/* 184 */         this.structure.setIdpyramide(new Pyramide(Long.valueOf(1L)));
/* 185 */         this.structure.setIdrattachement(new Rattachement(Integer.valueOf(1)));
/* 186 */         this.structure.setIdtypestructure(this.typestructure);
/* 187 */         this.structure.setIdstatutstructure(this.statutstructure);
/* 188 */         this.structureFacadeLocal.create(this.structure);
/* 189 */         this.structure = new Structure();
/*     */         
/* 191 */         this.detail = true;
/* 192 */         RequestContext.getCurrentInstance().execute("PF('StructureCreateDialog').hide()");
/* 193 */         JsfUtil.addSuccessMessage("Opération réussie");
/* 194 */       } else if ("Edit".equals(this.mode)) {
/* 195 */         if (this.structure != null) {
/* 196 */           this.structureFacadeLocal.edit(this.structure);
/* 197 */           this.structure = new Structure();
/* 198 */           this.detail = true;
/* 199 */           RequestContext.getCurrentInstance().execute("PF('StructureCreateDialog').hide()");
/* 200 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 202 */           JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */         } 
/*     */       } 
/* 205 */     } catch (Exception e) {
/* 206 */       e.printStackTrace();
/* 207 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/* 213 */       if (this.structure != null) {
/* 214 */         this.structureFacadeLocal.remove(this.structure);
/* 215 */         this.structure = new Structure();
/* 216 */         this.detail = true;
/*     */       } else {
/* 218 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 220 */     } catch (Exception e) {
/* 221 */       e.printStackTrace();
/* 222 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareUploadPhoto(Structure structure) {
/* 227 */     HttpSession session = SessionMBean.getSession();
/* 228 */     session.setAttribute("i_session", structure);
/*     */     try {
/* 230 */       this.filename = "";
/* 231 */       this.filenameStructure = "";
/*     */     
/*     */     }
/* 234 */     catch (Exception e) {}
/*     */     
/* 236 */     this.structure = structure;
/* 237 */     RequestContext.getCurrentInstance().execute("PF('PhotoCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 241 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 245 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 249 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 253 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Structure getStructure() {
/* 257 */     return this.structure;
/*     */   }
/*     */   
/*     */   public void setStructure(Structure structure) {
/* 261 */     this.structure = structure;
/*     */   }
/*     */   
/*     */   public List<Structure> getStructures() {
/* 265 */     this.structures = this.structureFacadeLocal.findByIdinstitution(SessionMBean.getInstitution().getIdinstitution().longValue());
/* 266 */     return this.structures;
/*     */   }
/*     */   
/*     */   public void setStructures(List<Structure> structures) {
/* 270 */     this.structures = structures;
/*     */   }
/*     */   
/*     */   public String getFilename() {
/* 274 */     return this.filename;
/*     */   }
/*     */   
/*     */   public String getFilenameStructure() {
/* 278 */     return this.filenameStructure;
/*     */   }
/*     */   
/*     */   public Niveaupyramide getNiveaupyramide() {
/* 282 */     return this.niveaupyramide;
/*     */   }
/*     */   
/*     */   public void setNiveaupyramide(Niveaupyramide niveaupyramide) {
/* 286 */     this.niveaupyramide = niveaupyramide;
/*     */   }
/*     */   
/*     */   public List<Niveaupyramide> getNiveaupyramides() {
/* 290 */     this.niveaupyramides = this.niveaupyramideFacadeLocal.findAllRange();
/* 291 */     return this.niveaupyramides;
/*     */   }
/*     */   
/*     */   public void setNiveaupyramides(List<Niveaupyramide> niveaupyramides) {
/* 295 */     this.niveaupyramides = niveaupyramides;
/*     */   }
/*     */   
/*     */   public Typestructure getTypestructure() {
/* 299 */     return this.typestructure;
/*     */   }
/*     */   
/*     */   public void setTypestructure(Typestructure typestructure) {
/* 303 */     this.typestructure = typestructure;
/*     */   }
/*     */   
/*     */   public List<Typestructure> getTypestructures() {
/* 307 */     this.typestructures = this.typestructureFacadeLocal.findAllRange();
/* 308 */     return this.typestructures;
/*     */   }
/*     */   
/*     */   public void setTypestructures(List<Typestructure> typestructures) {
/* 312 */     this.typestructures = typestructures;
/*     */   }
/*     */   
/*     */   public Statutstructure getStatutstructure() {
/* 316 */     return this.statutstructure;
/*     */   }
/*     */   
/*     */   public void setStatutstructure(Statutstructure statutstructure) {
/* 320 */     this.statutstructure = statutstructure;
/*     */   }
/*     */   
/*     */   public List<Statutstructure> getStatutstructures() {
/* 324 */     this.statutstructures = this.statutstructureFacadeLocal.findAllRange();
/* 325 */     return this.statutstructures;
/*     */   }
/*     */   
/*     */   public void setStatutstructures(List<Statutstructure> statutstructures) {
/* 329 */     this.statutstructures = statutstructures;
/*     */   }
/*     */   
/*     */   public Region getRegion() {
/* 333 */     return this.region;
/*     */   }
/*     */   
/*     */   public void setRegion(Region region) {
/* 337 */     this.region = region;
/*     */   }
/*     */   
/*     */   public List<Region> getRegions() {
/* 341 */     this.regions = this.regionFacadeLocal.findAllRange();
/* 342 */     return this.regions;
/*     */   }
/*     */   
/*     */   public void setRegions(List<Region> regions) {
/* 346 */     this.regions = regions;
/*     */   }
/*     */   
/*     */   public String getMode() {
/* 350 */     return this.mode;
/*     */   }
/*     */   
/*     */   public Departement getDepartement() {
/* 354 */     return this.departement;
/*     */   }
/*     */   
/*     */   public void setDepartement(Departement departement) {
/* 358 */     this.departement = departement;
/*     */   }
/*     */   
/*     */   public List<Departement> getDepartements() {
/* 362 */     return this.departements;
/*     */   }
/*     */   
/*     */   public void setDepartements(List<Departement> departements) {
/* 366 */     this.departements = departements;
/*     */   }
/*     */   
/*     */   public Arrondissement getArrondissement() {
/* 370 */     return this.arrondissement;
/*     */   }
/*     */   
/*     */   public void setArrondissement(Arrondissement arrondissement) {
/* 374 */     this.arrondissement = arrondissement;
/*     */   }
/*     */   
/*     */   public List<Arrondissement> getArrondissements() {
/* 378 */     return this.arrondissements;
/*     */   }
/*     */   
/*     */   public void setArrondissements(List<Arrondissement> arrondissements) {
/* 382 */     this.arrondissements = arrondissements;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\ServiceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
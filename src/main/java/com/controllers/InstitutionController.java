/*     */ package controllers;
/*     */ 
/*     */ import com.google.common.io.Files;
/*     */ import controllers.util.JsfUtil;
/*     */ import controllers.util.SessionMBean;
/*     */ import entities.Institution;
/*     */ import entities.Soussecteur;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.ejb.EJB;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ViewScoped;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.primefaces.context.RequestContext;
/*     */ import org.primefaces.event.FileUploadEvent;
/*     */ import sessions.InstitutionFacadeLocal;
/*     */ import sessions.SoussecteurFacadeLocal;
/*     */ import utilitaire.Utilitaires;
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
/*     */ public class InstitutionController
/*     */   implements Serializable
/*     */ {
/*     */   @EJB
/*     */   private InstitutionFacadeLocal institutionFacadeLocal;
/*  39 */   private Institution institution = new Institution();
/*  40 */   private List<Institution> institutions = new ArrayList<>();
/*     */   
/*     */   @EJB
/*     */   private SoussecteurFacadeLocal soussecteurFacadeLocal;
/*  44 */   private Soussecteur soussecteur = new Soussecteur();
/*  45 */   private List<Soussecteur> soussecteurs = new ArrayList<>();
/*     */   
/*  47 */   private String mode = "";
/*  48 */   private String filename = "";
/*  49 */   private String filenameInstitution = "";
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean detail = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareCreate() {
/*  58 */     this.soussecteur = new Soussecteur();
/*  59 */     this.institution = new Institution();
/*  60 */     this.mode = "Create";
/*  61 */     RequestContext.getCurrentInstance().execute("PF('InstitutionCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void prepareEdit() {
/*  65 */     if (this.institution != null) {
/*  66 */       this.mode = "Edit";
/*     */       
/*     */       try {
/*  69 */         this.soussecteur = this.institution.getIdsoussecteur();
/*  70 */         if (this.soussecteur == null) {
/*  71 */           this.soussecteur = new Soussecteur();
/*     */         }
/*  73 */       } catch (Exception e) {
/*  74 */         this.soussecteur = new Soussecteur();
/*     */       } 
/*  76 */       RequestContext.getCurrentInstance().execute("PF('InstitutionCreateDialog').show()");
/*     */     } else {
/*  78 */       JsfUtil.addWarningMessage("Opération réussie");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save() {
/*     */     try {
/*  84 */       if ("Create".equals(this.mode)) {
/*  85 */         this.institution.setIdinstitution(this.institutionFacadeLocal.nextId());
/*  86 */         this.institution.setIdsoussecteur(this.soussecteur);
/*  87 */         this.institutionFacadeLocal.create(this.institution);
/*  88 */         this.institution = new Institution();
/*  89 */         this.soussecteur = new Soussecteur();
/*  90 */         this.detail = true;
/*  91 */         RequestContext.getCurrentInstance().execute("PF('InstitutionCreateDialog').hide()");
/*  92 */         JsfUtil.addSuccessMessage("Opération réussie");
/*  93 */       } else if ("Edit".equals(this.mode)) {
/*  94 */         if (this.institution != null) {
/*  95 */           this.institution.setIdsoussecteur(this.soussecteurFacadeLocal.find(this.soussecteur.getIdsoussecteur()));
/*  96 */           this.institutionFacadeLocal.edit(this.institution);
/*  97 */           this.institution = new Institution();
/*  98 */           this.soussecteur = new Soussecteur();
/*  99 */           this.detail = true;
/* 100 */           RequestContext.getCurrentInstance().execute("PF('InstitutionCreateDialog').hide()");
/* 101 */           JsfUtil.addSuccessMessage("Opération réussie");
/*     */         } else {
/* 103 */           JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */         } 
/*     */       } 
/* 106 */     } catch (Exception e) {
/* 107 */       e.printStackTrace();
/* 108 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void delete() {
/*     */     try {
/* 114 */       if (this.institution != null) {
/* 115 */         this.institutionFacadeLocal.remove(this.institution);
/* 116 */         this.institution = new Institution();
/* 117 */         this.detail = true;
/*     */       } else {
/* 119 */         JsfUtil.addErrorMessage("Aucune ligne seletionnée");
/*     */       } 
/* 121 */     } catch (Exception e) {
/* 122 */       e.printStackTrace();
/* 123 */       JsfUtil.addFatalErrorMessage("Exception");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void handleFileUpload(FileUploadEvent event) {
/*     */     try {
/* 129 */       if (event.getFile() == null || event.getFile().getFileName() == null || event.getFile().getFileName().equals("")) {
/* 130 */         JsfUtil.addWarningMessage("Nom de l'image incorrect");
/* 131 */         RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
/*     */         
/*     */         return;
/*     */       } 
/* 135 */       if (!Utilitaires.estFichierImage(Utilitaires.getExtension(event.getFile().getFileName()))) {
/* 136 */         JsfUtil.addWarningMessage("Fichier non pris en charge");
/* 137 */         RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
/*     */         
/*     */         return;
/*     */       } 
/* 141 */       String nom = "Photo_Inst_" + SessionMBean.getInstitutionSession().getIdinstitution() + "_." + Utilitaires.getExtension(event.getFile().getFileName());
/*     */ 
/*     */       
/* 144 */       FileOutputStream out = new FileOutputStream(Utilitaires.path + "" + "/photos/" + "" + nom, true);
/*     */       
/* 146 */       byte[] bytes = event.getFile().getContents();
/* 147 */       out.write(bytes);
/*     */       
/* 149 */       this.filename = nom;
/* 150 */       this.institution = SessionMBean.getInstitutionSession();
/* 151 */       this.institution.setPhoto(nom);
/* 152 */       this.institutionFacadeLocal.edit(this.institution);
/*     */       
/* 154 */       RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
/*     */       
/* 156 */       File f1 = new File(Utilitaires.path + "" + "/photos/" + "" + nom);
/* 157 */       File f2 = new File(SessionMBean.getParametrage().getRepertoirePhoto() + "" + nom);
/* 158 */       Files.copy(f1, f2);
/* 159 */       System.out.println("telechargement");
/* 160 */       JsfUtil.addSuccessMessage("Opération réussie");
/* 161 */     } catch (IOException ex) {
/* 162 */       JsfUtil.addFatalErrorMessage("Exception");
/* 163 */       RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void handleFileUpload1(FileUploadEvent event) {
/*     */     try {
/* 169 */       if (event.getFile() == null || event.getFile().getFileName() == null || event.getFile().getFileName().equals("")) {
/* 170 */         JsfUtil.addWarningMessage("Nom de l'image incorrect");
/* 171 */         RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
/*     */         
/*     */         return;
/*     */       } 
/* 175 */       if (!Utilitaires.estFichierImage(Utilitaires.getExtension(event.getFile().getFileName()))) {
/* 176 */         JsfUtil.addWarningMessage("Fichier non pris en charge");
/* 177 */         RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
/*     */         
/*     */         return;
/*     */       } 
/* 181 */       String nom = "Photo_Inst_M" + SessionMBean.getInstitutionSession().getIdinstitution() + "_." + Utilitaires.getExtension(event.getFile().getFileName());
/*     */ 
/*     */       
/* 184 */       FileOutputStream out = new FileOutputStream(Utilitaires.path + "" + "/photos/" + "" + nom, true);
/*     */       
/* 186 */       byte[] bytes = event.getFile().getContents();
/* 187 */       out.write(bytes);
/*     */       
/* 189 */       this.filenameInstitution = nom;
/* 190 */       this.institution = SessionMBean.getInstitutionSession();
/* 191 */       this.institution.setPhotoInstitutionMere(nom);
/* 192 */       this.institutionFacadeLocal.edit(this.institution);
/*     */       
/* 194 */       RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
/*     */       
/* 196 */       File f1 = new File(Utilitaires.path + "" + "/photos/" + "" + nom);
/* 197 */       File f2 = new File(SessionMBean.getParametrage().getRepertoirePhoto() + "" + nom);
/* 198 */       Files.copy(f1, f2);
/*     */       
/* 200 */       JsfUtil.addSuccessMessage("Opération réussie");
/* 201 */     } catch (IOException ex) {
/* 202 */       JsfUtil.addFatalErrorMessage("Exception");
/* 203 */       RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareUploadPhoto(Institution institution) {
/* 208 */     HttpSession session = SessionMBean.getSession();
/* 209 */     session.setAttribute("i_session", institution);
/*     */     try {
/* 211 */       this.filename = "";
/* 212 */       this.filenameInstitution = "";
/* 213 */       this.filename = institution.getPhoto();
/* 214 */       this.filenameInstitution = institution.getPhotoInstitutionMere();
/* 215 */     } catch (Exception e) {}
/*     */     
/* 217 */     this.institution = institution;
/* 218 */     RequestContext.getCurrentInstance().execute("PF('PhotoCreateDialog').show()");
/*     */   }
/*     */   
/*     */   public void activeButton() {
/* 222 */     this.detail = false;
/*     */   }
/*     */   
/*     */   public void deactiveButton() {
/* 226 */     this.detail = true;
/*     */   }
/*     */   
/*     */   public boolean isDetail() {
/* 230 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setDetail(boolean detail) {
/* 234 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public Soussecteur getSoussecteur() {
/* 238 */     return this.soussecteur;
/*     */   }
/*     */   
/*     */   public void setSoussecteur(Soussecteur soussecteur) {
/* 242 */     this.soussecteur = soussecteur;
/*     */   }
/*     */   
/*     */   public List<Soussecteur> getSoussecteurs() {
/* 246 */     this.soussecteurs = this.soussecteurFacadeLocal.findAllRange();
/* 247 */     return this.soussecteurs;
/*     */   }
/*     */   
/*     */   public void setSoussecteurs(List<Soussecteur> soussecteurs) {
/* 251 */     this.soussecteurs = soussecteurs;
/*     */   }
/*     */   
/*     */   public Institution getInstitution() {
/* 255 */     return this.institution;
/*     */   }
/*     */   
/*     */   public void setInstitution(Institution institution) {
/* 259 */     this.institution = institution;
/*     */   }
/*     */   
/*     */   public List<Institution> getInstitutions() {
/* 263 */     this.institutions = this.institutionFacadeLocal.findAllRange();
/* 264 */     return this.institutions;
/*     */   }
/*     */   
/*     */   public void setInstitutions(List<Institution> institutions) {
/* 268 */     this.institutions = institutions;
/*     */   }
/*     */   
/*     */   public String getFilename() {
/* 272 */     return this.filename;
/*     */   }
/*     */   
/*     */   public String getFilenameInstitution() {
/* 276 */     return this.filenameInstitution;
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\controllers\InstitutionController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
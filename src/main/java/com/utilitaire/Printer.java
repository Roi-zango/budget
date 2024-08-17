/*    */ package utilitaire;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.util.Locale;
/*    */ import java.util.Map;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.servlet.ServletOutputStream;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.sf.jasperreports.engine.JRException;
/*    */ import net.sf.jasperreports.engine.JasperExportManager;
/*    */ import net.sf.jasperreports.engine.JasperFillManager;
/*    */ import net.sf.jasperreports.engine.JasperPrint;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Printer
/*    */ {
/*    */   private JasperPrint jasperPrint;
/* 28 */   public static String user = "postgres";
/* 29 */   public static String password = "batrapi";
/* 30 */   public static String driver = "org.postgresql.Driver";
/* 31 */   public static String url = "jdbc:postgresql://localhost:5432/camersoft_db";
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Connection con;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void print(String path, Map<String, Locale> parameters) throws Exception {
/*    */     try {
/* 50 */       Class.forName(driver);
/* 51 */       con = DriverManager.getConnection(url, user, password);
/* 52 */       String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(path);
/*    */       
/* 54 */       parameters.put("REPORT_LOCALE", FacesContext.getCurrentInstance().getViewRoot().getLocale());
/*    */       
/* 56 */       this.jasperPrint = JasperFillManager.fillReport(reportPath, parameters, con);
/*    */       
/* 58 */       HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
/* 59 */       httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + path.substring(path.lastIndexOf("/"), path.lastIndexOf(".")) + ".pdf");
/* 60 */       ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
/* 61 */       JasperExportManager.exportReportToPdfStream(this.jasperPrint, (OutputStream)servletOutputStream);
/*    */       
/* 63 */       FacesContext.getCurrentInstance().responseComplete();
/* 64 */     } catch (IOException e) {
/* 65 */       throw new IOException(e);
/* 66 */     } catch (JRException e) {
/* 67 */       throw new JRException(e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\\\utilitaire\Printer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
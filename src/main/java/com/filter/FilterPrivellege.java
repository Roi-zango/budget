/*     */ package filter;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Serializable;
/*     */ import java.io.StringWriter;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import javax.servlet.Filter;
/*     */ import javax.servlet.FilterChain;
/*     */ import javax.servlet.FilterConfig;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ import javax.servlet.annotation.WebFilter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @WebFilter(filterName = "FilterPrivellege", urlPatterns = {"/faces/parametrages/*", "/faces/securite/*", "/faces/operations/*", "/faces/analyse/*"})
/*     */ public class FilterPrivellege
/*     */   implements Filter, Serializable
/*     */ {
/*     */   Properties properties;
/*     */   private static final boolean debug = true;
/*  37 */   private FilterConfig filterConfig = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doBeforeProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException {
/*  45 */     log("FilterPrivellege:DoBeforeProcessing");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doAfterProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException {
/*  52 */     log("FilterPrivellege:DoAfterProcessing");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
/*  68 */     HttpServletRequest hRequest = (HttpServletRequest)request;
/*  69 */     HttpServletResponse hResponse = (HttpServletResponse)response;
/*  70 */     HttpSession session = hRequest.getSession();
/*     */     
/*  72 */     if (session.getAttribute("user") != null) {
/*     */       
/*  74 */       if ("/faces/login.html".equals(hRequest.getRequestURI())) {
/*  75 */         request.getRequestDispatcher("/faces/index.html?faces-redirect=true").forward(request, response);
/*     */       }
/*     */       
/*  78 */       List<String> system_all_menu = (List<String>)session.getAttribute("system_all_menu");
/*     */       
/*  80 */       if (system_all_menu.contains(hRequest.getRequestURI())) {
/*  81 */         List<Long> user_access_id = (List<Long>)session.getAttribute("user_access_id");
/*     */         
/*  83 */         if (!user_access_id.isEmpty()) {
/*     */           
/*  85 */           boolean drapeau = false;
/*     */           
/*  87 */           if (user_access_id.contains(Long.valueOf(1L))) {
/*  88 */             drapeau = true;
/*     */           }
/*     */           
/*  91 */           if (drapeau) {
/*  92 */             chain.doFilter(request, response);
/*     */           } else {
/*  94 */             List<String> user_all_menu = (List<String>)session.getAttribute("user_all_menu");
/*  95 */             if (user_all_menu.contains(hRequest.getRequestURI())) {
/*  96 */               chain.doFilter(request, response);
/*     */             } else {
/*  98 */               request.getRequestDispatcher("/faces/erreuracces.xhtml?faces-redirect=true").forward(request, response);
/*     */             } 
/*     */           } 
/*     */         } else {
/* 102 */           request.getRequestDispatcher("/faces/erreuracces.xhtml?faces-redirect=true").forward(request, response);
/*     */         } 
/*     */       } else {
/* 105 */         chain.doFilter(request, response);
/*     */       } 
/*     */     } else {
/* 108 */       request.getRequestDispatcher("/faces/login.html?faces-redirect=true").forward(request, response);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FilterConfig getFilterConfig() {
/* 116 */     return this.filterConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFilterConfig(FilterConfig filterConfig) {
/* 125 */     this.filterConfig = filterConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void destroy() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(FilterConfig filterConfig) {
/* 142 */     this.filterConfig = filterConfig;
/* 143 */     if (filterConfig != null)
/*     */     {
/* 145 */       log("FilterPrivellege:Initializing filter");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 155 */     if (this.filterConfig == null) {
/* 156 */       return "FilterPrivellege()";
/*     */     }
/* 158 */     StringBuilder sb = new StringBuilder("FilterPrivellege(");
/* 159 */     sb.append(this.filterConfig);
/* 160 */     sb.append(")");
/* 161 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private void sendProcessingError(Throwable t, ServletResponse response) {}
/*     */ 
/*     */   
/*     */   public static String getStackTrace(Throwable t) {
/* 169 */     String stackTrace = null;
/*     */     try {
/* 171 */       StringWriter sw = new StringWriter();
/* 172 */       PrintWriter pw = new PrintWriter(sw);
/* 173 */       t.printStackTrace(pw);
/* 174 */       pw.close();
/* 175 */       sw.close();
/* 176 */       stackTrace = sw.getBuffer().toString();
/* 177 */     } catch (Exception ex) {}
/*     */     
/* 179 */     return stackTrace;
/*     */   }
/*     */   
/*     */   public void log(String msg) {
/* 183 */     this.filterConfig.getServletContext().log(msg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyValue(String key) {
/*     */     try {
/* 190 */       if (key == null) {
/* 191 */         System.out.println("=============== key null  ++++++++++++++++++++");
/*     */       }
/* 193 */       if (key == "") {
/* 194 */         System.out.println("=============== key empty  ++++++++++++++++++++");
/*     */       }
/* 196 */       if (this.properties == null) {
/* 197 */         System.out.println("=============== properties empty  ++++++++++++++++++++");
/*     */       }
/* 199 */       String propValue = this.properties.getProperty(key);
/*     */       
/* 201 */       System.out.println("key is: " + key);
/* 202 */       System.out.println("Property value is: " + propValue);
/* 203 */       return propValue;
/* 204 */     } catch (Exception ex) {
/* 205 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Roi-zango\OneDrive\Bureau\web\WEB-INF\classes\!\filter\FilterPrivellege.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
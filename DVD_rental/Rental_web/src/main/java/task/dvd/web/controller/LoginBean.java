/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.dvd.web.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import task.dvd.web.util.JSF;

@Named
@ViewScoped
public class LoginBean implements Serializable {

    private static Logger log = Logger.getLogger(LoginBean.class.getName());
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void login() throws IOException, ServletException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        
        try {
            //logowanie
            request.login(username, password);
            //logowanie udane - przekierowanie na strone index.xhtml
            externalContext.redirect(externalContext.getRequestContextPath()+"/index.xhtml");
            } catch (ServletException e) {
                // dodajemy informacje o bledzie (renderowane na stronie)
                log.log(Level.WARNING,"",e);
                JSF.addErrorMessage("Invalid credentials");
            }
    }
    // akcja wylogowania
    public void logout() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.invalidateSession();
        externalContext.redirect(externalContext.getRequestContextPath() + "/index.xhtml");
        System.out.println("logout called");
    }
    
    
}

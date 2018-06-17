/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.dvd.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSF {
    public static void addErrorMessage(String message) {
        addMessage(FacesMessage.SEVERITY_ERROR, message);
    }
    
    public static void addInfoMessage(String message) {
        addMessage(FacesMessage.SEVERITY_INFO, message);    
    }
    
    private static void addMessage(FacesMessage.Severity severity, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, message, message));
    }
}

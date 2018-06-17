/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.dvd.web.controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import task.dvd.ejb.PurchaseItemDao;
import task.dvd.model.PurchaseItemDTO;

@Named
@ViewScoped
public class PurchaseItemBean implements Serializable {    
    @EJB
    private PurchaseItemDao pidao;
    
    private PurchaseItemDTO newPI = new PurchaseItemDTO();

    public List<PurchaseItemDTO> getPIs() {
        return pidao.findAll();
    }
    
    public void onRemovePI(PurchaseItemDTO pi) {
        pidao.remove(pi.getId());
    }

    public void onPIAdd() {
        newPI = new PurchaseItemDTO();
    }
    
    public void onPIAdded() {
        pidao.save(newPI);
        RequestContext.getCurrentInstance().execute("PF('PIDlg').hide()");
    }  

    public PurchaseItemDTO getNewPI() {
        return newPI;
    }

    public void setNewPI(PurchaseItemDTO newPI) {
        this.newPI = newPI;
    }   
}

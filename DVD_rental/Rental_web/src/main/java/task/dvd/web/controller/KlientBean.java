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
import task.dvd.ejb.KlientDao;
import task.dvd.model.KlientDTO;

@Named
@ViewScoped
public class KlientBean implements Serializable {    
    @EJB
    private KlientDao kdao;
    
    private KlientDTO newKlient = new KlientDTO();

    public List<KlientDTO> getKlients() {
        return kdao.findAll();
    }
    
    public void onRemoveKlient(KlientDTO klient) {
        kdao.remove(klient.getId());
    }

    public void onKlinetAdd() {
        newKlient = new KlientDTO();
    }
    
    public void onKlientAdded() {
        kdao.save(newKlient);
        RequestContext.getCurrentInstance().execute("PF('KlinetDlg').hide()");
    }  

    public KlientDTO getNewKlinet() {
        return newKlient;
    }

    public void setNewKlient(KlientDTO newKlient) {
        this.newKlient = newKlient;
    }   
}

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
import task.dvd.ejb.ZamowienieDao;
import task.dvd.model.ZamowienieDTO;

@Named
@ViewScoped
public class ZamowienieBean implements Serializable {    
    @EJB
    private ZamowienieDao zdao;
    
    private ZamowienieDTO newZamowienie = new ZamowienieDTO();

    public List<ZamowienieDTO> getZamowienia() {
        return zdao.findAll();
    }
    
    public void onRemoveZamowienie(ZamowienieDTO zamowienie) {
        zdao.remove(zamowienie.getId());
    }

    public void onZamowienieAdd() {
        newZamowienie = new ZamowienieDTO();
    }
    
    public void onZamowieieAdded() {
        zdao.save(newZamowienie);
        RequestContext.getCurrentInstance().execute("PF('ZamowienieDlg').hide()");
    }  

    public ZamowienieDTO getNewZamowienie() {
        return newZamowienie;
    }

    public void setNewZamowienie(ZamowienieDTO newZamowienie) {
        this.newZamowienie = newZamowienie;
    }   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author student
 */
@Entity
@Table(name="ZAMOWIENIE", schema="APP")
public class ZamowienieDTO extends AbstractDTO {
    @ManyToOne
    private KlientDTO klient;
    @OneToMany(mappedBy = "zamowienie", cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private List<PurchaseItemDTO> purchaseItems = new LinkedList<PurchaseItemDTO>();
    //private String miejsce_dostawy;
    private Date data_wypozyczenia;

    public KlientDTO getCustomer() {
        return klient;
    }

    public void setCustomer(KlientDTO klient) {
        this.klient = klient;
    }

    public void addPurchaseItem(PurchaseItemDTO pi) {
        purchaseItems.add(pi);
        pi.setZamowienie(this);
    }

    public List<PurchaseItemDTO> getPurchaseItems() {
        return purchaseItems;
    }

    public Date getDataWypozyczenia(){
        return data_wypozyczenia;
    }
    public void setDataWypozyczenia(Date data_wypozyczenia){
        this.data_wypozyczenia = data_wypozyczenia;
    }
    
}

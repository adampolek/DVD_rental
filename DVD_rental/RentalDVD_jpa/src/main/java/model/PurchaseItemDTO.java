/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author student
 */
@Entity
@Table(name="PURCHASE_ITEM", schema="APP")
public class PurchaseItemDTO extends AbstractDTO {
    @ManyToOne
    private FilmDTO film;
    @ManyToOne
    private ZamowienieDTO zamowienie;
    private Integer quantity;
    

    public FilmDTO getFilm() {
        return film;
    }

    public void setFilm(FilmDTO film) {
        this.film = film;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ZamowienieDTO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieDTO zamowienie) {
        this.zamowienie  = zamowienie;
    }
    
}

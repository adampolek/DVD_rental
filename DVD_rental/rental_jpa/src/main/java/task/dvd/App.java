/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task.dvd;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import task.dvd.dao.KlientDao;
import task.dvd.dao.FilmDao;
import task.dvd.dao.ZamowienieDao;
import task.dvd.dao.jpa.JpaKlientDao;
import task.dvd.dao.jpa.JpaFilmDao;
import task.dvd.dao.jpa.JpaZamowienieDao;
import task.dvd.model.FilmDTO;
import task.dvd.model.KlientDTO;
import task.dvd.model.ZamowienieDTO;
import task.dvd.model.PurchaseItemDTO;

/**
 * @author user
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        KlientDao kdao = new JpaKlientDao();
        FilmDao fdao = new JpaFilmDao();
        ZamowienieDao zdao = new JpaZamowienieDao();
        
        KlientDTO c1 = new KlientDTO();
        c1.setFirstName("jan");
        c1.setLastName("kowalski");
        c1.setEmail("jan.kowalski@dot.com");
        // zapis klienta
        kdao.save(c1);
        
        FilmDTO f1 = new FilmDTO();
        f1.setTitle("Transformers");
        f1.setDirector("Michael Bay");
        f1.setPrice(9.88);
        fdao.save(f1);
        
        FilmDTO f2 = new FilmDTO();
        f2.setTitle("Grawitacja");
        f2.setDirector("Ktos Tam");
        f2.setPrice(7.88);
        fdao.save(f2);
        
        ZamowienieDTO z1  = new ZamowienieDTO();
        z1.setCustomer(c1);
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date data = d.parse("10/03/2017 09:25:00");
        z1.setDataWypozyczenia(data);
        
        PurchaseItemDTO pi = new PurchaseItemDTO();
        pi.setFilm(f1);
        pi.setQuantity(10);
        z1.addPurchaseItem(pi);
        //zdao.save(z1);
        
        PurchaseItemDTO pi2 = new PurchaseItemDTO();
        pi2.setFilm(f2);
        pi2.setQuantity(10);
        z1.addPurchaseItem(pi2);
        zdao.save(z1);
        
    }

}

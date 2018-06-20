/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wipb.jee.clientdemo.file;

import file.dao.FilmDao;
import file.dao.jpa.JpaFilmDao;
import file.model.FilmDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Mateusz
 */
@ManagedBean(name = "filmdto")
@SessionScoped
public class AddFilm {

    @EJB
    private FilmDao dao;
    private FilmDTO dvd = new FilmDTO();

    public FilmDao getDao() {
        return dao;
    }

    public void setDao(FilmDao dao) {
        this.dao = dao;
    }

    public FilmDTO getDvd() {
        return dvd;
    }

    public void setDvd(FilmDTO dvd) {
        this.dvd = dvd;
    }

    public List<FilmDTO> getFilms() {
        return dao.findAll();
    }

    public FilmDTO getFilm() {
        return dvd;
    }

    public void setFilm(FilmDTO dvd) {
        this.dvd = dvd;
    }

    public void onFilmAdd() {
        dvd = new FilmDTO();
        
    }

    public String added() {
        dao.save(dvd);
        RequestContext.getCurrentInstance().execute("PF('filmDlg').hide()");
        return "admin.xhtml";
    }

}

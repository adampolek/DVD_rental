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
import task.dvd.ejb.FilmDao;
import task.dvd.model.FilmDTO;

@Named
@ViewScoped
public class FilmBean implements Serializable {    
    @EJB
    private FilmDao fdao;
    
    private FilmDTO newFilm = new FilmDTO();

    public List<FilmDTO> getFilms() {
        return fdao.findAll();
    }
    
    public void onRemoveFilm(FilmDTO film) {
        fdao.remove(film.getId());
    }

    public void onFilmAdd() {
        newFilm = new FilmDTO();
    }
    
    public void onFilmAdded() {
        fdao.save(newFilm);
        RequestContext.getCurrentInstance().execute("PF('FilmDlg').hide()");
    }  

    public FilmDTO getNewFilm() {
        return newFilm;
    }

    public void setNewFilm(FilmDTO newFilm) {
        this.newFilm = newFilm;
    }   
}

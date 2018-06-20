/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.dao;

import file.model.FilmDTO;
import java.util.List;

/**
 *
 * @author student
 */
public interface FilmDao  {
    public void save(FilmDTO t);
    public void delete (FilmDTO t);
    public void update (FilmDTO t);
    public FilmDTO findById(Long id);
    public List<FilmDTO> findAll();
}

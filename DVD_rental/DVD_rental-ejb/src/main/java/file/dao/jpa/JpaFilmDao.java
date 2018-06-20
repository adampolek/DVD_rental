/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.dao.jpa;

import file.dao.FilmDao;
import file.model.FilmDTO;
import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author student
 */

@Stateless
public class JpaFilmDao extends GenericJpaDao<FilmDTO, Long> implements FilmDao {
    @PersistenceContext(unitName = "file_DVD_rental-ejb_1.0PU")

    @Override
    public List<FilmDTO> findAll() {
        EntityManager em = getEntityManager();
        TypedQuery<FilmDTO> q = em.createNamedQuery("FilmDTO.findAll", FilmDTO.class);
        return q.getResultList();
    }
}

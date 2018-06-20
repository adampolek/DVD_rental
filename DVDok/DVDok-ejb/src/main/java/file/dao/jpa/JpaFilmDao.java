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
@DataSourceDefinition(
        name = "java:global/dvd",
        className = "org.apache.derby.jdbc.ClientDataSource",
        minPoolSize = 1,
        initialPoolSize = 1,
        portNumber = 1527,
        serverName = "localhost",
        user = "app",
        password = "app",
        databaseName = "dvd",
        properties = {"connectionAttributes=;create=true"}
)
@Stateless
public class JpaFilmDao implements FilmDao {
    @PersistenceContext(unitName = "file_DVD_rental-ejb_1.0PU")
    private EntityManager em;

    @Override
    public void save(FilmDTO t) {
        em.persist(t);
    }

    @Override
    public void delete(FilmDTO t) {
        t = em.merge(t);
        em.remove(t);
    }

    @Override
    public void update(FilmDTO t) {
        em.merge(t);
    }

    @Override
    public FilmDTO findById(Long id) {
        FilmDTO dto = em.find(FilmDTO.class, id);
        return dto;
    }

    @Override
    public List<FilmDTO> findAll() {
        TypedQuery<FilmDTO> q = em.createNamedQuery("FilmDTO.findAll", FilmDTO.class);
        return q.getResultList();
    }
}

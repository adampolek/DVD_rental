/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.dvd.ejb;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import task.dvd.model.FilmDTO;


//@DataSourceDefinition(
//        name="java:global/DemoDataSource",
//        className="org.apache.derby.jdbc.ClientDataSource",
//        minPoolSize = 1,
//        initialPoolSize = 1,
//        portNumber = 1527,
//        serverName = "localhost",
//        user = "app",
//        password = "app",
//        databaseName = "testdb1",
//        properties = {"connectionAttributes=;create=true"}       
//)
@Stateless
public class FilmDao extends AbstractDao<FilmDTO,Long> {
    public FilmDao() {
        super(FilmDTO.class);
    } 
}

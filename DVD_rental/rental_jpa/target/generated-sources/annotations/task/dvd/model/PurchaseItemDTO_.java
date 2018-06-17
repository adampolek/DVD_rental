package task.dvd.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import task.dvd.model.FilmDTO;
import task.dvd.model.ZamowienieDTO;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2018-06-06T22:55:41")
@StaticMetamodel(PurchaseItemDTO.class)
public class PurchaseItemDTO_ extends AbstractDTO_ {

    public static volatile SingularAttribute<PurchaseItemDTO, Integer> quantity;
    public static volatile SingularAttribute<PurchaseItemDTO, ZamowienieDTO> zamowienie;
    public static volatile SingularAttribute<PurchaseItemDTO, FilmDTO> film;

}
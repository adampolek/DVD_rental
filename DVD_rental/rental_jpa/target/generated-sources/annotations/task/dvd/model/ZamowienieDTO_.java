package task.dvd.model;

import com.hazelcast.nio.serialization.Data;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import task.dvd.model.KlientDTO;
import task.dvd.model.PurchaseItemDTO;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2018-06-06T22:55:41")
@StaticMetamodel(ZamowienieDTO.class)
public class ZamowienieDTO_ extends AbstractDTO_ {

    public static volatile SingularAttribute<ZamowienieDTO, String> miejsce_dostawy;
    public static volatile SingularAttribute<ZamowienieDTO, KlientDTO> klient;
    public static volatile SingularAttribute<ZamowienieDTO, Data> data_wypozyczenia;
    public static volatile ListAttribute<ZamowienieDTO, PurchaseItemDTO> purchaseItems;

}
package fooddelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="Search_table")
@Data
public class Search {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long orderid;
        private String storeid;
        private String deliveryid;
        private String orderstatus;
        private String storestatus;
        private String deliverystatus;


}
package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long orderid;
    private String foodid;
    private Integer qty;
    private String status;
    private String customerid;
    private String address;
}



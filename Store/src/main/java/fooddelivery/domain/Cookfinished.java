package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Cookfinished extends AbstractEvent {

    private Long storeid;
    private String orderid;
    private String status;
    private String customerid;
    private String address;

    public Cookfinished(Store aggregate){
        super(aggregate);
    }
    public Cookfinished(){
        super();
    }
}

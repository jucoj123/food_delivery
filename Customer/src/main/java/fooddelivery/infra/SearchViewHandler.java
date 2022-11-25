package fooddelivery.infra;

import fooddelivery.domain.*;
import fooddelivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SearchViewHandler {


    @Autowired
    private SearchRepository searchRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Search search = new Search();
            // view 객체에 이벤트의 Value 를 set 함
            search.setOrderid(orderPlaced.getOrderid());
            search.setOrderstatus(orderPlaced.getStatus());
            // view 레파지 토리에 save
            searchRepository.save(search);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_1(@Payload Delivered delivered) {
        try {
            if (!delivered.validate()) return;
                // view 객체 조회
            Optional<Search> searchOptional = searchRepository.findByOrderid(Long.valueOf(delivered.getOrderid()));

            if( searchOptional.isPresent()) {
                 Search search = searchOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                search.setDeliverystatus(delivery complete);    
                // view 레파지 토리에 save
                 searchRepository.save(search);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


package com.example.demo.settlements.services;

import com.example.demo.settlements.entities.Settlement
import com.example.demo.settlements.extensions.toResponse
import com.example.demo.settlements.repositories.SettlementRepository
import com.nytimes.spg.settlements.entities.Settlement;
import com.nytimes.spg.settlements.repositories.SettlementRepository;
import com.nytimes.spg.settlements_service.server.model.SettlementResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//@Slf4j
@Service
class GetSettlementService(
    private val repository: SettlementRepository
) {

    fun getSettlement(settlementID: String): ResponseEntity<SettlementResponse>  {
//        log.info("get settlement by settlementID: {} ", settlementID);

        val settlement = repository.findSettlementById(settlementID.toLong())

        settlement.copy(id = 1)

        settlement == settlement

        return if (settlement == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok(settlement.toResponse())
        }
    }

    fun getSettlement(String orderID, String vendorTransactionID): ResponseEntity<SettlementResponse> {
        log.info("get settlement by orderID: {} and vendorTransactionID: {}", orderID, vendorTransactionID);

        Settlement settlement = settlementRepository.findSettlementByOrderIdAndVendorTransactionId(orderID, vendorTransactionID);

        if (settlement == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(mapToSettlementEntity(settlement), HttpStatus.OK);
    }


    // Map Settlement object
//    private SettlementResponse mapToSettlementEntity(Settlement object) {
//        SettlementResponse settlement = new SettlementResponse();
//
//        settlement.setId(String.valueOf(object.getId()));
//        settlement.setOrderId(object.getOrderId());
//        settlement.setOriginalOrderId(object.getOriginalOrderId());
//        settlement.setVendorTransactionId(object.getVendorTransactionId());
//        settlement.setGateway(object.getGateway());
//        settlement.setNetwork(object.getNetwork());
//        settlement.setSettlementDate(object.getSettledDate());
//        settlement.setSettlementType(object.getType());
//        settlement.setMethodOfPayment(object.getMethodOfPayment());
//        settlement.setPresentmentCurrency(object.getPresentmentCurrency().getName());
//        settlement.setPresentmentAmount(object.getPresentmentAmount());
//        settlement.setFeeCurrency(object.getFeeCurrency().getName());
//        settlement.setFeeAmount(object.getFee());
//        settlement.setSettlementCurrency(object.getCurrency().getName());
//        settlement.setSettlementAmount(object.getAmount());
//        settlement.setRate(object.getRate());
//
//        return settlement;
//    }
}

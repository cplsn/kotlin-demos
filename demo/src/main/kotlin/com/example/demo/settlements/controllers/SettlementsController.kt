package com.example.demo.settlements.controllers

import com.example.demo.settlements.services.GetSettlementService
import com.nytimes.spg.settlements_service.server.api.SettlementsApi
import com.nytimes.spg.settlements_service.server.model.SettlementRequest
import com.nytimes.spg.settlements_service.server.model.SettlementResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
class SettlementsController(
  private val getSettlementService: GetSettlementService
) : SettlementsApi {

  @GetMapping(value = ["/settlements/{settlementID}"])
  override fun getSettlement(@PathVariable settlementID: String) =
    getSettlementService.getSettlement(settlementID)

  @GetMapping(value = ["/settlements"])
  override fun getSettlementByOrderIDAndVendorTransactionID(
    @RequestParam
    orderID: String?,
    @RequestParam
    vendorTransactionID: String?
  ): ResponseEntity<SettlementResponse> {
    TODO("Not yet implemented")
  }

  @PostMapping(value = ["/settlements"])
  override fun triggerSettlement(
    @RequestHeader(value = "User-Agent")
    userAgent: String?,
    @Valid @RequestBody
    settlementRequest: SettlementRequest?
  ): ResponseEntity<SettlementResponse> {
    TODO("Not yet implemented")
  }
}

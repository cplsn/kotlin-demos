package com.example.demo.settlements.repositories

import com.example.demo.settlements.entities.Settlement
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SettlementRepository : JpaRepository<Settlement?, Long?> {

  fun findSettlementById(settlementID: Long?): Settlement?

  fun findSettlementByOrderIdAndVendorTransactionId(
    orderID: String?,
    vendorTransactionID: String?
  ): Settlement?
}

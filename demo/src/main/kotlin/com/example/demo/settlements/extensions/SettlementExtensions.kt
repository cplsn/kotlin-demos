package com.example.demo.settlements.extensions

import com.example.demo.settlements.entities.Settlement
import com.nytimes.spg.settlements_service.server.model.SettlementResponse

fun Settlement.toResponse() =
  SettlementResponse()


package uk.co.findout.traderslog.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import uk.co.findout.traderslog.model.Broker

interface BrokerService {

    fun getAllBrokers(offset: Int, limit: Int, sortDirection: Sort.Direction,
                      orderedField: String): ResponseEntity<Page<Broker>>
    fun getBrokerById(id: Long): ResponseEntity<Broker>
    fun getBrokerByName(brokerName: String): ResponseEntity<Broker>
    fun createBroker(broker: Broker): ResponseEntity<Broker>
    fun updateBrokerById(id: Long, broker: Broker): ResponseEntity<Broker>
    fun updateBrokerByName(name: String, broker: Broker): ResponseEntity<Broker>
    fun deleteBroker(id: Long): ResponseEntity<Boolean>

}
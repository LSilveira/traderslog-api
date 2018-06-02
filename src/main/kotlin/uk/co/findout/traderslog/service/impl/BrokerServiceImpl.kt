package uk.co.findout.traderslog.service.impl

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import uk.co.findout.traderslog.model.Broker
import uk.co.findout.traderslog.repository.BrokerRepository
import uk.co.findout.traderslog.service.BrokerService

@Service
class BrokerServiceImpl(val brokerRepository: BrokerRepository) : BrokerService
{

    override fun getAllBrokers(offset: Int, limit: Int, sortDirection: Sort.Direction,
                               orderedField: String): ResponseEntity<Page<Broker>>
    {
        val brokerPage: Page<Broker> = brokerRepository.findAllByRemoved(false, PageRequest.of(offset, limit, sortDirection, orderedField))

        return if (brokerPage.hasContent())
            ResponseEntity.ok(brokerPage)
        else
            ResponseEntity.notFound().build<Page<Broker>>()
    }

    override fun getBrokerById(id: Long): ResponseEntity<Broker> {
        return brokerRepository.findById(id)
                .map { broker -> ResponseEntity.ok(broker) }
                .orElse(ResponseEntity.notFound().build<Broker>())
    }

    override fun getBrokerByName(brokerName: String): ResponseEntity<Broker>
    {
        return brokerRepository.findByName(brokerName)
                ?.let { broker -> ResponseEntity.ok(broker) }
                ?:ResponseEntity.notFound().build<Broker>()
    }

    override fun createBroker(broker: Broker): ResponseEntity<Broker>
    {
        return brokerRepository.save(broker)
                .let { brokerEntity -> ResponseEntity(brokerEntity, HttpStatus.CREATED) }
    }

    override fun updateBrokerById(id: Long, broker: Broker): ResponseEntity<Broker>
    {
        return brokerRepository.findById(id)
                .map { brokerEntity -> ResponseEntity(
                        brokerRepository.save(
                                brokerEntity.copy(
                                        name = broker.name,
                                        description = broker.description,
                                        url = broker.url
                                )
                        ),
                        HttpStatus.ACCEPTED
                    )
                }
                .orElse(ResponseEntity.notFound().build<Broker>())
    }

    override fun updateBrokerByName(name: String, broker: Broker): ResponseEntity<Broker>
    {
        return brokerRepository.findByName(name)
                ?.let { brokerEntity -> ResponseEntity(
                        brokerRepository.save(
                                brokerEntity.copy(
                                        name = broker.name,
                                        description = broker.description,
                                        url = broker.url
                                )
                        ),
                        HttpStatus.ACCEPTED
                )
                }
                ?:ResponseEntity.notFound().build<Broker>()
    }

    // code 200 or code 404
    override fun deleteBroker(id: Long): ResponseEntity<Boolean>
    {
        return brokerRepository.findByIdAndRemoved(false, id)
                ?.let { brokerEntity -> ResponseEntity(
                        logicalDeleteBroker(brokerEntity),
                        HttpStatus.OK
                )
                }
                ?:ResponseEntity.notFound().build<Boolean>()
    }

    private fun logicalDeleteBroker(broker: Broker): Boolean
    {
        brokerRepository.save(
                broker.copy(
                        removed = true
                )
        )
        return true
    }

//    override fun deleteBroker(id: Long)
//    {
//        return brokerRepository.findById(id)
//                .ifPresent(
//                        Consumer {
//                            broker -> brokerRepository.save(
//                                broker.copy(removed = true)
//                        )
//                        }
//                )
//    }

}
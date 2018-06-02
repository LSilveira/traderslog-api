package uk.co.findout.traderslog.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import uk.co.findout.traderslog.model.Broker

@Repository
interface BrokerRepository : PagingAndSortingRepository<Broker, Long> {

    fun findByName(@Param("name") name: String): Broker?
    fun findAllByRemoved(@Param("removed") removed: Boolean, page: Pageable): Page<Broker>
    fun findByIdAndRemoved(@Param("removed") removed: Boolean, id: Long): Broker?

}
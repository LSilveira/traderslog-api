package uk.co.findout.traderslog.company.industry

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface IndustryRepository : PagingAndSortingRepository<Industry, Long>
{
    fun findByName(@Param("name") name: String): Industry?
}
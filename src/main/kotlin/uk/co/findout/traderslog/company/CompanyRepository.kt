package uk.co.findout.traderslog.company

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository : PagingAndSortingRepository<Company, Long>
{
    fun findByName(@Param("name") name: String): Company?
}
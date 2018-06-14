package uk.co.findout.traderslog.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import uk.co.findout.traderslog.model.CompanyCategory

@Repository
interface CompanyCategoryRepository : PagingAndSortingRepository<CompanyCategory, Long> {

    fun findByName(@Param("name") name: String): CompanyCategory?

}
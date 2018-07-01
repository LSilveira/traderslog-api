package uk.co.findout.traderslog.company

import org.springframework.http.ResponseEntity
import uk.co.findout.traderslog.service.BaseService

/**
 * Service to manage company data
 */
interface CompanyService : BaseService<Company>
{
    /**
     * Get company data searched by name
     *
     * @param companyName the company name
     * @return company object wrapped in a ResponseEntity
     */
    fun getCompanyByName(companyName: String): ResponseEntity<Company>

    /**
     * Update a company data searched by id
     *
     * @param id the company id
     * @param company the company object
     * @return updated company object wrapped in a ResponseEntity
     */
    fun updateCompanyById(id: Long, company: Company): ResponseEntity<Company>

    /**
     * Update a company data searched by name
     *
     * @param name the company name
     * @param company the company object
     * @return updated company object wrapped in a ResponseEntity
     */
    fun updateCompanyByName(name: String, company: Company): ResponseEntity<Company>
}
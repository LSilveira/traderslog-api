package uk.co.findout.traderslog.company.industry

import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity

/**
 * Service to manage industry data
 */
interface IndustryService
{
    /**
     * Get pages for the industries
     *
     * @param offset offset of the page
     * @param limit page limite
     * @param sortDirection sort direction
     * @param orderedField ordered field
     * @return page of industries wrapped in a ResponseEntity
     */
    fun getAllIndustries(offset: Int, limit: Int, sortDirection: Sort.Direction,
                      orderedField: String): ResponseEntity<Page<Industry>>

    /**
     * Get industry data searched by id
     *
     * @param id the industry id
     * @return industry object wrapped in a ResponseEntity
     */
    fun getIndustryById(id: Long): ResponseEntity<Industry>

    /**
     * Get industry data searched by name
     *
     * @param industryName the industry name
     * @return industry object wrapped in a ResponseEntity
     */
    fun getIndustryByName(industryName: String): ResponseEntity<Industry>

    /**
     * Create an industry
     *
     * @param industry the company object
     * @return created industry object wrapped in a ResponseEntity
     */
    fun createIndustry(industry: Industry): ResponseEntity<Industry>

    /**
     * Update a industry data searched by id
     *
     * @param id the industry id
     * @param industry the industry object
     * @return updated industry object wrapped in a ResponseEntity
     */
    fun updateIndustryById(id: Long, industry: Industry): ResponseEntity<Industry>

    /**
     * Update a industry data searched by name
     *
     * @param name the industry name
     * @param industry the industry object
     * @return updated industry object wrapped in a ResponseEntity
     */
    fun updateIndustryByName(name: String, industry: Industry): ResponseEntity<Industry>
}
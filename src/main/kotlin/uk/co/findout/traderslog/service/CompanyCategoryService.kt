package uk.co.findout.traderslog.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import uk.co.findout.traderslog.model.CompanyCategory

interface CompanyCategoryService {

    fun getAllCompanyCategories(offset: Int, limit: Int, sortDirection: Sort.Direction,
                      orderedField: String): ResponseEntity<Page<CompanyCategory>>
    fun getCompanyCategoryById(id: Long): ResponseEntity<CompanyCategory>
    fun getCompanyCategoryByName(companyCategoryName: String): ResponseEntity<CompanyCategory>
    fun createCompanyCategory(companyCategory: CompanyCategory): ResponseEntity<CompanyCategory>
    fun updateCompanyCategoryById(id: Long, companyCategory: CompanyCategory): ResponseEntity<CompanyCategory>
    fun updateCompanyCategoryByName(name: String, companyCategory: CompanyCategory): ResponseEntity<CompanyCategory>

}
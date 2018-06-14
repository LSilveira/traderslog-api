package uk.co.findout.traderslog.service.impl

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import uk.co.findout.traderslog.model.CompanyCategory
import uk.co.findout.traderslog.repository.CompanyCategoryRepository
import uk.co.findout.traderslog.service.CompanyCategoryService

@Service
class CompanyCategoryServiceImpl(val companyCategoryRepository: CompanyCategoryRepository) : CompanyCategoryService
{

    override fun getAllCompanyCategories(offset: Int, limit: Int, sortDirection: Sort.Direction,
                               orderedField: String): ResponseEntity<Page<CompanyCategory>>
    {
        val companyCategoryPage: Page<CompanyCategory> = companyCategoryRepository.findAll(PageRequest.of(offset, limit, sortDirection, orderedField))

        return if (companyCategoryPage.hasContent())
            ResponseEntity.ok(companyCategoryPage)
        else
            ResponseEntity.notFound().build<Page<CompanyCategory>>()
    }

    override fun getCompanyCategoryById(id: Long): ResponseEntity<CompanyCategory> {
        return companyCategoryRepository.findById(id)
                .map { companyCategory -> ResponseEntity.ok(companyCategory) }
                .orElse(ResponseEntity.notFound().build<CompanyCategory>())
    }

    override fun getCompanyCategoryByName(companyCategoryName: String): ResponseEntity<CompanyCategory>
    {
        return companyCategoryRepository.findByName(companyCategoryName)
                ?.let { companyCategory -> ResponseEntity.ok(companyCategory) }
                ?:ResponseEntity.notFound().build<CompanyCategory>()
    }

    override fun createCompanyCategory(companyCategory: CompanyCategory): ResponseEntity<CompanyCategory>
    {
        return companyCategoryRepository.save(companyCategory)
                .let { companyCategoryEntity -> ResponseEntity(companyCategoryEntity, HttpStatus.CREATED) }
    }

    override fun updateCompanyCategoryById(id: Long, companyCategory: CompanyCategory): ResponseEntity<CompanyCategory>
    {
        return companyCategoryRepository.findById(id)
                .map { companyCategoryEntity -> ResponseEntity(
                        companyCategoryRepository.save(
                                companyCategoryEntity.copy(
                                        name = companyCategory.name,
                                        description = companyCategory.description
                                )
                        ),
                        HttpStatus.ACCEPTED
                    )
                }
                .orElse(ResponseEntity.notFound().build<CompanyCategory>())
    }

    override fun updateCompanyCategoryByName(name: String, companyCategory: CompanyCategory): ResponseEntity<CompanyCategory>
    {
        return companyCategoryRepository.findByName(name)
                ?.let { companyCategoryEntity -> ResponseEntity(
                        companyCategoryRepository.save(
                                companyCategoryEntity.copy(
                                        name = companyCategory.name,
                                        description = companyCategory.description
                                )
                        ),
                        HttpStatus.ACCEPTED
                )
                }
                ?:ResponseEntity.notFound().build<CompanyCategory>()
    }

}
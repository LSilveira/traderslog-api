package uk.co.findout.traderslog.company.industry

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class IndustryServiceImpl(private val industryRepository: IndustryRepository) : IndustryService
{
    override fun getAllIndustries(offset: Int, limit: Int, sortDirection: Sort.Direction,
                               orderedField: String): ResponseEntity<Page<Industry>>
    {
        val industryPage: Page<Industry> = industryRepository.findAll(PageRequest.of(offset, limit, sortDirection, orderedField))

        return if (industryPage.hasContent())
            ResponseEntity.ok(industryPage)
        else
            ResponseEntity.notFound().build<Page<Industry>>()
    }

    override fun getIndustryById(id: Long): ResponseEntity<Industry>
    {
        return industryRepository.findById(id)
                .map { industry -> ResponseEntity.ok(industry) }
                .orElse(ResponseEntity.notFound().build<Industry>())
    }

    override fun getIndustryByName(industryName: String): ResponseEntity<Industry>
    {
        return industryRepository.findByName(industryName)
                ?.let { industry -> ResponseEntity.ok(industry) }
                ?:ResponseEntity.notFound().build<Industry>()
    }

    override fun createIndustry(industry: Industry): ResponseEntity<Industry>
    {
        return industryRepository.save(industry)
                .let { industryEntity -> ResponseEntity(industryEntity, HttpStatus.CREATED) }
    }

    override fun updateIndustryById(id: Long, industry: Industry): ResponseEntity<Industry>
    {
        return industryRepository.findById(id)
                .map { oldIndustry -> ResponseEntity(
                        industryCopy(oldIndustry, industry),
                        HttpStatus.ACCEPTED
                    )
                }
                .orElse(ResponseEntity.notFound().build<Industry>())
    }

    override fun updateIndustryByName(name: String, industry: Industry): ResponseEntity<Industry>
    {
        return industryRepository.findByName(name)
                ?.let { oldIndustry -> ResponseEntity(
                        industryCopy(oldIndustry, industry),
                        HttpStatus.ACCEPTED
                )
                }
                ?:ResponseEntity.notFound().build<Industry>()
    }

    private fun industryCopy(industry: Industry, newIndustry: Industry) : Industry
    {
        return industryRepository.save(
                industry.copy(
                        id = newIndustry.id,
                        name = newIndustry.name,
                        companies = newIndustry.companies,
                        assets = newIndustry.assets,
                        products = newIndustry.products,
                        industrySize = newIndustry.industrySize,
                        description = newIndustry.description
                )
        )
    }
}
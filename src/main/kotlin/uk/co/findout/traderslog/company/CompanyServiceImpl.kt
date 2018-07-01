package uk.co.findout.traderslog.company

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import uk.co.findout.traderslog.service.BaseServiceImpl

@Service
class CompanyServiceImpl(private val companyRepository: CompanyRepository) : CompanyService, BaseServiceImpl<Company>(companyRepository)
{
    override fun getCompanyByName(companyName: String): ResponseEntity<Company> {
        return companyRepository.findByName(companyName)
                ?.let { company -> ResponseEntity.ok(company) }
                ?:ResponseEntity.notFound().build<Company>()
    }

    override fun updateCompanyById(id: Long, company: Company): ResponseEntity<Company> {
        return companyRepository.findById(id)
                .map { oldCompany -> ResponseEntity(
                        companyCopy(oldCompany, company),
                        HttpStatus.ACCEPTED
                )
                }
                .orElse(ResponseEntity.notFound().build<Company>())
    }

    override fun updateCompanyByName(name: String, company: Company): ResponseEntity<Company> {
        return companyRepository.findByName(name)
                ?.let { oldCompany -> ResponseEntity(
                        companyCopy(oldCompany, company),
                        HttpStatus.ACCEPTED
                )
                }
                ?:ResponseEntity.notFound().build<Company>()
    }

    private fun companyCopy(company: Company, newCompany: Company) : Company
    {
        return companyRepository.save(
                company.copy(
                        id = newCompany.id,
                        name = newCompany.name,
                        size = newCompany.size,
                        industries = newCompany.industries,
                        products = newCompany.products,
                        assets = newCompany.assets,
                        description = newCompany.description,
                        url = newCompany.url


                )
        )
    }

}
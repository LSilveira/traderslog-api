package uk.co.findout.traderslog.company

import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class CompanyController(private val companyService: CompanyService)
{
    @GetMapping("/company")
    fun getCompanies(@RequestParam(defaultValue = "0") offset: Int,
                      @RequestParam(defaultValue = "10") limit: Int,
                      @RequestParam(defaultValue = "ASC") sortDirection: Sort.Direction) =
            companyService.getAllEntities(offset, limit, sortDirection, "name")

    @GetMapping("/company/{id}")
    fun getCompanyById(@PathVariable(value = "id") id: Long) =
            companyService.getEntityById(id)

    @GetMapping("/company/name/{name}")
    fun getCompanyByName(@PathVariable(value = "name") name: String) =
            companyService.getCompanyByName(name)

    @PostMapping("/company")
    fun createCompany(@RequestBody company: Company) =
            companyService.createEntity(company)

    @PutMapping("/company/{id}")
    fun updateCompanyById(@PathVariable(value = "id") id: Long, @RequestBody company: Company) =
            companyService.updateCompanyById(id, company)

    @PutMapping("/company/name/{name}")
    fun updateCompanyByName(@PathVariable(value = "name") name: String, @RequestBody company: Company) =
            companyService.updateCompanyByName(name, company)
}
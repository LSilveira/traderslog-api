package uk.co.findout.traderslog.rest

import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*
import uk.co.findout.traderslog.model.CompanyCategory
import uk.co.findout.traderslog.service.CompanyCategoryService

@RestController
@RequestMapping("/api/v1")
class CompanyCategoryController(private val companyCategoryRepository: CompanyCategoryService) {

    @GetMapping("/companyCategory")
    fun getCompanyCategories(@RequestParam(defaultValue = "0") offset: Int,
                             @RequestParam(defaultValue = "10") limit: Int,
                             @RequestParam(defaultValue = "ASC") sortDirection: Sort.Direction) =
            companyCategoryRepository.getAllCompanyCategories(offset, limit, sortDirection, "name")

    @GetMapping("/companyCategory/{id}")
    fun getCompanyCategoryById(@PathVariable(value = "id") id: Long) =
            companyCategoryRepository.getCompanyCategoryById(id)

    @GetMapping("/companyCategory/name/{name}")
    fun getCompanyCategoryByName(@PathVariable(value = "name") name: String) =
            companyCategoryRepository.getCompanyCategoryByName(name)

    @PostMapping("/companyCategory")
    fun createCompanyCategory(@RequestBody companyCategory: CompanyCategory) =
            companyCategoryRepository.createCompanyCategory(companyCategory)

    @PutMapping("/companyCategory/{id}")
    fun updateCompanyCategoryById(@PathVariable(value = "id") id: Long, @RequestBody companyCategory: CompanyCategory) =
            companyCategoryRepository.updateCompanyCategoryById(id, companyCategory)

    @PutMapping("/companyCategory/name/{name}")
    fun updateCompanyCategoryByName(@PathVariable(value = "name") name: String, @RequestBody companyCategory: CompanyCategory) =
            companyCategoryRepository.updateCompanyCategoryByName(name, companyCategory)

}

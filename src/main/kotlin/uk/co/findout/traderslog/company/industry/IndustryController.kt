package uk.co.findout.traderslog.company.industry

import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class IndustryController(private val industryService: IndustryService)
{
    @GetMapping("/industry")
    fun getIndustries(@RequestParam(defaultValue = "0") offset: Int,
                             @RequestParam(defaultValue = "10") limit: Int,
                             @RequestParam(defaultValue = "ASC") sortDirection: Sort.Direction) =
            industryService.getAllIndustries(offset, limit, sortDirection, "name")

    @GetMapping("/industry/{id}")
    fun getIndustryById(@PathVariable(value = "id") id: Long) =
            industryService.getIndustryById(id)

    @GetMapping("/industry/name/{name}")
    fun getIndustryByName(@PathVariable(value = "name") name: String) =
            industryService.getIndustryByName(name)

    @PostMapping("/industry")
    fun createIndustry(@RequestBody industry: Industry) =
            industryService.createIndustry(industry)

    @PutMapping("/industry/{id}")
    fun updateIndustryById(@PathVariable(value = "id") id: Long, @RequestBody industry: Industry) =
            industryService.updateIndustryById(id, industry)

    @PutMapping("/industry/name/{name}")
    fun updateIndustryByName(@PathVariable(value = "name") name: String, @RequestBody industry: Industry) =
            industryService.updateIndustryByName(name, industry)
}

package uk.co.findout.traderslog.rest

import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.WebRequest
import uk.co.findout.traderslog.model.Broker
import uk.co.findout.traderslog.service.BrokerService


@RestController
@RequestMapping("/v1")
class BrokerController(private val brokerService: BrokerService) {

    @GetMapping("/brokers")
    fun getCategories(@RequestParam(defaultValue = "0") offset: Int,
                      @RequestParam(defaultValue = "10") limit: Int,
                      @RequestParam(defaultValue = "ASC") sortDirection: Sort.Direction) =
            brokerService.getAllBrokers(offset, limit, sortDirection, "name")

    @GetMapping("/brokers/{id}")
    fun getBrokerById(@PathVariable(value = "id") id: Long) =
            brokerService.getBrokerById(id)

    @GetMapping("/brokers/name/{name}")
    fun getBrokerByName(@PathVariable(value = "name") name: String) =
            brokerService.getBrokerByName(name)

    @PostMapping("/brokers")
    fun createCategory(@RequestBody broker: Broker) =
            brokerService.createBroker(broker)

    @PutMapping("/brokers/{id}")
    fun updateCategoryById(@PathVariable(value = "id") id: Long, @RequestBody broker: Broker) =
            brokerService.updateBrokerById(id, broker)

    @PutMapping("/brokers/name/{name}")
    fun updateCategoryByTitle(@PathVariable(value = "name") name: String, @RequestBody broker: Broker) =
            brokerService.updateBrokerByName(name, broker)

    @DeleteMapping("/brokers/{id}")
    fun deleteCategory(@PathVariable(value = "id") id: Long) =
            brokerService.deleteBroker(id)

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<String> {
        println(ex.message)
        return ResponseEntity<String>(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
    }


}
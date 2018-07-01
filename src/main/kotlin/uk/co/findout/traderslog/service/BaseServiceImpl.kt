package uk.co.findout.traderslog.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

open class BaseServiceImpl<T>(private val entityRepository: PagingAndSortingRepository<T, Long>) : BaseService<T>
{
    override fun getAllEntities(offset: Int, limit: Int, sortDirection: Sort.Direction,
                                orderedField: String): ResponseEntity<Page<T>>
    {
        val entityPage: Page<T> = entityRepository.findAll(PageRequest.of(offset, limit, sortDirection, orderedField))

        return if (entityPage.hasContent())
            ResponseEntity.ok(entityPage)
        else
            ResponseEntity.notFound().build<Page<T>>()
    }

    override fun getEntityById(id: Long): ResponseEntity<T>
    {
        return entityRepository.findById(id)
                .map { entity -> ResponseEntity.ok(entity) }
                .orElse(ResponseEntity.notFound().build<T>())
    }

    override fun createEntity(entity: T): ResponseEntity<T>
    {
        return entityRepository.save(entity)
                .let { newEntity -> ResponseEntity(newEntity, HttpStatus.CREATED) }
    }
}
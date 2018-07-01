package uk.co.findout.traderslog.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity

/**
 * Generic service to support create and get entities
 */
interface BaseService<T>
{
    /**
     * Get pages for the entities
     *
     * @param offset offset of the page
     * @param limit page limite
     * @param sortDirection sort direction
     * @param orderedField ordered field
     * @return page of entities wrapped in a ResponseEntity
     */
    fun getAllEntities(offset: Int, limit: Int, sortDirection: Sort.Direction,
                         orderedField: String): ResponseEntity<Page<T>>

    /**
     * Get entity data searched by id
     *
     * @param id the entity id
     * @return entity object wrapped in a ResponseEntity
     */
    fun getEntityById(id: Long): ResponseEntity<T>

    /**
     * Create an entity
     *
     * @param entity the entity object
     * @return created entity object wrapped in a ResponseEntity
     */
    fun createEntity(entity: T): ResponseEntity<T>
}
package uk.co.findout.traderslog.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

/**
 * Data class to represent a CompanyCategory
 * @author Luis Silveira
 */
@Entity
@Table(name = "TL_COMPANY_CATEGORY")
data class CompanyCategory (

        @Id @NotNull val id: Long,
        @NotNull val name: String,
        val description: String

)
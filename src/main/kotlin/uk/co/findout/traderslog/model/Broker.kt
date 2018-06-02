package uk.co.findout.traderslog.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

/**
 * Data class representing a broker
 * @author Luis Silveira
 */
@Entity
@Table(name = "TDL_BROKER")
data class Broker (

        @Id @GeneratedValue val id: Long = 0,
        @NotNull val name: String = "",
        val description: String = "",
        val url: String = "",
        val removed: Boolean = false
)
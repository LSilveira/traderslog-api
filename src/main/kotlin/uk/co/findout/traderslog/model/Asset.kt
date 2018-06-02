package uk.co.findout.traderslog.model

import javax.persistence.Id
import javax.validation.constraints.NotNull

/**
 * Data class to represent an Asset
 * @author Luis Silveira
 */
data class Asset (

        @Id @NotNull val id: Long,
        @NotNull val name: String,
        val description: String,
        val symbol: String,
        val url: String,
        val broker: List<Broker>

)
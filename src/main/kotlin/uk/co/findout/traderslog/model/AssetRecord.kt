package uk.co.findout.traderslog.model

import java.time.LocalDateTime
import javax.persistence.Id
import javax.validation.constraints.NotNull

/**
 * Data class to represent an asset record
 * This class contains one line of the trading log of the user
 * @author Luis Silveira
 */
class AssetRecord (

        @Id @NotNull val creationDate: LocalDateTime,
        val startDate: LocalDateTime,
        val endDate: LocalDateTime,
        val asset: Asset,
        val broker: Broker,
        val amount: Double,
        val initialPosition: Double,
        val finalPosition: Double,
        val profit: Double,
        val takeProfit: Double,
        val stopLoss: Double,
        val profitGoal: Double
//        val owner: User

)
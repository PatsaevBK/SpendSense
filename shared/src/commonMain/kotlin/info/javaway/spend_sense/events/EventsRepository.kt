package info.javaway.spend_sense.events

import info.javaway.spend_sense.events.models.EventDao
import info.javaway.spend_sense.events.models.SpendEvent

class EventsRepository(
    private val dao: EventDao
) {

    fun getAllFlow() = dao.getAllFlow()

    suspend fun create(spendEvent: SpendEvent) = dao.insert(spendEvent)
}
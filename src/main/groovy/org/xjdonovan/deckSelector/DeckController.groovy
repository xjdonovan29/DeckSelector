package org.xjdonovan.deckSelector

import grails.gorm.transactions.Transactional
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

import javax.inject.Inject

@Controller('/deck')
class DeckController {
    @Inject
    DeckService deckService

    @Get(uri = '/')
    @Transactional
    @ExecuteOn(TaskExecutors.IO)
    List<Card> show() {
        deckService.drawDeck()
    }
}

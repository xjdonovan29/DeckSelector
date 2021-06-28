package org.xjdonovan.deckSelector

import grails.gorm.transactions.Transactional
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn


@Controller('/cards')
class CardController {

    @Get(uri = '/{id}')
    @Transactional
    @ExecuteOn(TaskExecutors.IO)
    Card show(@PathVariable Serializable id) {
        Card.get(id)
    }

    @Get(uri = '/')
    @Transactional
    @ExecuteOn(TaskExecutors.IO)
    List<Card> list() {
        Card.list()
    }
}

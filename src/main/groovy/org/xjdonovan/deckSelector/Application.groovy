package org.xjdonovan.deckSelector

import grails.gorm.transactions.Transactional
import io.micronaut.runtime.Micronaut

class Application {
    static void main(String[] args) {
        load()
        Micronaut.run(Application, args)
    }

    @Transactional
    static void load() {
        def card = new Card(
                name:'Moat',
                cost:2,
                type:CardType.REACTION,
                cards:2,
                description: 'When another player plays an Attack card, you may first reveal this from your hand, to be unaffected by it.'
        )
        if (card.save()) {
            println(card.id)
        } else {
            println(card.errors)
        }
    }
}

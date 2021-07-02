package org.xjdonovan.deckSelector

import grails.gorm.transactions.Transactional
import io.micronaut.runtime.Micronaut

class Application {
    static void main(String[] args) {
        Micronaut.run(Application, args)
    }

}

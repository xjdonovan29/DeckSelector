package org.xjdonovan.deckSelector

import grails.gorm.annotation.Entity

@Entity
class Card {
    String name
    Integer cost
    CardType type
    Expansion expansion
    Integer action = 0
    Integer buy = 0
    Integer cards = 0
    Integer coin = 0
    Boolean gainCard = false
    Boolean trash = false
    Boolean affectedByCardCount = false
    String description

    static mapping = {
        table "cards"
        id generator:"sequence", params:[sequence:"card_id_seq"]
        type column:"card_type"
    }

    static constraints = {
        name unique:true, maxSize:32
        description nullable:true, maxSize:2048
        cost min:0, max:30
        action min:0, max:10
        buy min:0, max:10
        cards min:0, max:10
        coin min:0, max:10
    }
}

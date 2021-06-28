package org.xjdonovan.deckSelector

import grails.gorm.annotation.Entity

@Entity
class Card {
    String name
    Integer cost
    CardType type
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
        cost minSize:0, maxSize:30
        action minSize:0, maxSize:10
        buy minSize:0, maxSize:10
        cards minSize:0, maxSize:10
        coin minSize:0, maxSize:10
    }
}

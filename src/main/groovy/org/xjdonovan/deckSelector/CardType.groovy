package org.xjdonovan.deckSelector

enum CardType {
    ACTION,
    ATTACK,
    REACTION,
    DURATION,
    TREASURE,
    VICTORY,
    EVENT,
    WAY

    static CardType byName(String name) {
        find { it.name() == name.toUpperCase()}
    }
}
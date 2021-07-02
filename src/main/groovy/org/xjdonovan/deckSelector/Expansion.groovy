package org.xjdonovan.deckSelector

enum Expansion {
    BASE,
    SEASIDE,
    CORNUCOPIA,
    ALCHEMY,
    PROSPERITY,
    MENAGERIE,
    INTRIGUE,
    HINTERLANDS,
    DARKAGES,
    GUILDS,
    ADVENTURES,
    EMPRIRES,
    NOCUTURNE,
    RENAISSANCE

    static Expansion byName(String name) {
        find { it.name() == name.toUpperCase()}
    }
}
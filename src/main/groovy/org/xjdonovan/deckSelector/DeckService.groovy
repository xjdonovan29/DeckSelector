package org.xjdonovan.deckSelector

import javax.inject.Singleton

@Singleton
class DeckService {
    Random random = new Random()

    List<Card> drawDeck() {
        def deck = []
        deck += selectRandom(Card.findAllByCost(2))
        deck += selectRandom(Card.findAllByCostGreaterThanEquals(6))
        deck += selectRandom(Card.findAllByCost(5), 2)
        deck += selectRandom(Card.findAllByCostBetween(3,4), 3)
        deck += selectRandom(Card.findAllByIdNotInList(deck.collect {it.id}), 3)
    }

    Card selectRandom(List<Card> cards) {
        cards.get(random.nextInt(cards.size()))
    }

    List<Card> selectRandom(List<Card> cards, Integer amount) {
        (1..amount).inject([]) {deck, n ->
            deck + selectRandom(cards - deck)
        }
    }
}

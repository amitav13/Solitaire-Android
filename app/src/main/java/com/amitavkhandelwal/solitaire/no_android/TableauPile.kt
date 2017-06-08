package com.amitavkhandelwal.solitaire

/**
 * Created by amitavk on 01/06/17.
 */
class TableauPile(var cards: MutableList<Card> = mutableListOf()) {
    init {
        if (cards.size > 0) {
            cards.last().faceUp = true
        }
    }

    fun addCards(newCards: MutableList<Card>): Boolean {
        if (cards.size > 0) {
            //new card(s) put onto a non-empty pile
            if (newCards.first().value == cards.last().value - 1 && suitCheck(newCards.first(), cards.last())) {
                cards.addAll(newCards)
                return true
            }
        } else if (newCards.first().value == 12) {
            //If a king is put down on an empty pile
            cards.addAll(newCards)
            return true
        }
        return false
    }

    fun removeCards(tappedIndex: Int) {
        for (i in tappedIndex..cards.lastIndex) {
            cards.removeAt(tappedIndex)
        }
        if (cards.size > 0) {
            cards.last().faceUp = true
        }
    }

    private fun suitCheck(c1: Card, c2: Card): Boolean {
        if ((redSuits.contains(c1.suit) && blackSuits.contains(c2.suit)) ||
                (blackSuits.contains(c1.suit)) && redSuits.contains(c2.suit)) {
            return true
        }
        return false
    }
}
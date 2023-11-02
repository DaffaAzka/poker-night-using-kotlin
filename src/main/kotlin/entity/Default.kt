package entity

import service.Rules

data class Default(val name: String, var money: Int) {
    private var status: String = "None Pair"
    private var n = 0
    private var cards = mutableListOf<Card>()
    private var rules = Rules()

    public fun getStatus(): String {
        rules.setAllCards(cards)
        return rules.getResult()
    }



    public fun addCards(rank: String, suit: String) {
        cards.add(Card(rank, suit))
        n++
    }

    override fun toString(): String {
        return "Default(name='$name', money=$money, cards=$cards)"
    }


}

class Card(val rank: String, val suit: String)
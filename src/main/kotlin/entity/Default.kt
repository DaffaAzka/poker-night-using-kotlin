package entity

import service.Rules

data class Default(val name: String, var money: Int) {
    private var status: String = "None Pair"
    private var n = 0
    private var cards: MutableMap<Int, List<String>> = mutableMapOf()
    private var rules = Rules()

    public fun getStatus(): String {
        rules.setAllCards(cards)
        rules.getListItem()
        return status
    }



    public fun addCards(l: List<String>) {
        cards[n] = l
        n++
    }

    override fun toString(): String {
        return "Default(name='$name', money=$money, cards=$cards)"
    }


}
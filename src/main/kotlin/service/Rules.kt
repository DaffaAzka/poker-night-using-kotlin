package service

import entity.Card

public class Rules {
    private var cards = mutableListOf<Card>()

    public fun setAllCards(map: MutableList<Card>){
        for (i in 0..<map.size) {
            map[i].let { cards.add(it) }
        }
    }

    public fun getListItem() {
        println(cards)
    }

    public fun getResult(): String {
        if (straightFlush()) return "Straight Flush"
        if (fourOfKind()) return "Four Of a Kind"
        if (fullHouse()) return "Full House"
        if (flush()) return "Flush"
        if (straight()) return "Straight"
        if (threeOfKind()) return "Three Of a Kind"
        if (twoPair()) return "Two Pair"
        if (onePair()) return "One Pair"
        if (highCard()) return "High Card"
        return "None Pair"
    }

    private fun straightFlush(): Boolean {
        val sortedCards = cards.sortedBy { it.rank }
        var straightFlush = mutableListOf(sortedCards[0])
        for (i in 1..<sortedCards.size) {
            if (sortedCards[i].rank == straightFlush.last().rank + 1 && sortedCards[i].suit == straightFlush.last().suit) {
                straightFlush.add(sortedCards[i])
                if (straightFlush.size == 5) {
                    return true
                }
            } else if (sortedCards[i].rank != straightFlush.last().rank || sortedCards[i].suit != straightFlush.last().suit) {
                straightFlush = mutableListOf(sortedCards[i])
            }
        }
        return false
    }

    private fun fourOfKind(): Boolean {
        val cardGroups = cards.groupBy { it.rank }
        return cardGroups.values.any { it.size >= 4 }
    }

    private fun fullHouse(): Boolean {
        val cardGroups = cards.groupBy { it.rank }
        val threeOfAKind = cardGroups.values.firstOrNull { it.size == 3 }
        val pair = cardGroups.values.firstOrNull { it.size >= 2 && it != threeOfAKind }
        return threeOfAKind != null && pair != null
    }

    private fun flush(): Boolean {
        val cardGroups = cards.groupBy { it.suit }
        return cardGroups.values.any{it.size >= 5 }
    }

    private fun straight(): Boolean {
        val sortedCards = cards.sortedBy { it.rank }
        var straight = mutableListOf(sortedCards[0])
        for (i in 1 until sortedCards.size) {
            if (sortedCards[i].rank == straight.last().rank + 1) {
                straight.add(sortedCards[i])
                if (straight.size == 5) {
                    return true
                }
            } else if (sortedCards[i].rank != straight.last().rank) {
                straight = mutableListOf(sortedCards[i])
            }
        }
        return false

    }

    private fun threeOfKind(): Boolean {
        val cardGroups = cards.groupBy { it.rank }
        return cardGroups.values.any { it.size == 3 }
    }

    private fun twoPair(): Boolean {
        val cardGroups = cards.groupBy { it.rank }
        return cardGroups.values.any { it.size == 2 }
    }

    private fun onePair(): Boolean {
        var pair: Int = 0

        for (i in 0..<cards.size) {
            val list1 = cards[i]
            for (j in (i + 1)..<cards.size) {
                val list2 = cards[j]
                if (list1.rank == list2.rank) pair++
            }
        }

        return pair == 1
    }

    private fun highCard(): Boolean {
        for (i in cards) {
            if (i.rank == "A") {
                return true
            }
        }
        return false
    }

}
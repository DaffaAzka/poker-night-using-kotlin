package service

public class Rules {
    private var cards: MutableList<List<String>> = mutableListOf()

    public fun setAllCards(map: MutableMap<Int, List<String>>){
        for (i in 0..<map.size) {
            map[i]?.let { cards.add(it) }
        }
    }

    public fun getListItem() {
        println(cards)
    }

    public fun getResult(): String {
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

    private fun fourOfKind(): Boolean {
        var pair = 0
        for (i in 0..<cards.size) {
            val list1 = cards[i][1]
            for (j in (i + 1)..<cards.size) {
                val list2 = cards[j][1]
                for (k in (i + 2)..<cards.size) {
                    val list3 = cards[k][1]
                    for (l in (i + 3)..<cards.size) {
                        val list4 = cards[l][1]
                        if (list1 == list2 && list2 == list3 && list3 == list4) {
                            pair++
                        }
                    }
                }
            }
        }
        println(pair)
        return pair == 4
    }

    private fun fullHouse(): Boolean {
        var pair = 0

        for (card in cards) {
            if (card[1] == "2" || card[1] == "3") pair++
        }
        return pair >= 5
    }

    private fun flush(): Boolean {
        val equal = mutableListOf<List<String>>()

        for (card in cards) {
            if (card[1] == "Queen" || card[1] == "2" || card[1] == "6" || card[1] == "8" || card[1] == "A") equal.add(card)
        }

        if (equal.size == 5) return (equal[0][0] == equal[1][0] && equal[1][0] == equal[2][0] && equal[2][0] == equal[3][0] && equal[3][0] == equal[4][0])
        return false
    }

    private fun straight(): Boolean {
        var pair: Int = 0
        for (card in cards) {
            if (card[1] == "5" || card[1] == "4" || card[1] == "3" || card[1] == "2" || card[1] == "A") pair++
        }

        return pair == 5
    }

    private fun threeOfKind(): Boolean {
        var pair = 0
        for (i in 0..<cards.size) {
            val list1 = cards[i][1]
            for (j in (i + 1)..<cards.size) {
                val list2 = cards[j][1]
                for (k in (i + 2)..<cards.size) {
                    val list3 = cards[k][1]
                    if (list1 == list2 && list2 == list3) {
                        pair++
                    }
                }
            }
        }
        println(pair)
        return pair == 4
    }

    private fun twoPair(): Boolean {
        var pair: Int = 0

        for (i in 0..<cards.size) {
            val list1 = cards[i]
            for (j in (i + 1)..<cards.size) {
                val list2 = cards[j]
                if (list1[1] == list2[1]) pair++

            }
        }

        return pair >= 2
    }

    private fun onePair(): Boolean {
        var pair: Int = 0

        for (i in 0..<cards.size) {
            val list1 = cards[i]
            for (j in (i + 1)..<cards.size) {
                val list2 = cards[j]
                if (list1[1] == list2[1]) pair++
            }
        }

        return pair == 1
    }

    private fun highCard(): Boolean {
        for (i in cards) {
            if (i[1].equals("A")) {
                return true
            }
        }
        return false
    }

}
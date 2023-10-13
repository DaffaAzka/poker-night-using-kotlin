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

    fun onePair(l:List<String>): String {
        return "none"
    }

}
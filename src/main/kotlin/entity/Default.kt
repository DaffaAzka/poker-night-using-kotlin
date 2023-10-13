package entity

data class Default(val name: String, var money: Int) {
    private var t: String? = null
    private var n = 0;
    private var cards: MutableMap<Int, List<String>> = mutableMapOf()

    public fun setStatus(s: String) {
        t = s
    }

    public fun addCards(l: List<String>) {
        cards[n] = l
        n++
    }

    override fun toString(): String {
        return "Default(name='$name', money=$money, cards=$cards)"
    }


}
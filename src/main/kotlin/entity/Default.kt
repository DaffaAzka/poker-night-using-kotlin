package entity

data class Default(val name: String, var money: Int, val cards: Map<Int, List<String>>) {
    var t:String? = null

    public fun setStatus(s: String) {
        t = s
    }

    override fun toString(): String {
        return "Default(name='$name', money=$money, cards=$cards)"
    }


}
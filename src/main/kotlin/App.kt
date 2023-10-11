import entity.Default

fun main() {
    val cr = mapOf<Int, List<String>>(
        1 to listOf("Clover", "2"),
        2 to listOf("Clover", "Queen"),
        3 to listOf("Clover", "King"),
        4 to listOf("Clover", "Jack")
    )
    val ent = Default("Dest", 15000, cr)

    println(ent)
}
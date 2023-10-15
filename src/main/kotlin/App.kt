import entity.Default
import utility.RandomCards

fun main() {
    val cr = RandomCards()

    val ent = Default("Dest", 15000)
    ent.addCards(listOf("Heart", "3"))
    ent.addCards(listOf("Spade", "King"))
    ent.addCards(listOf("Heart", "3"))
    ent.addCards(listOf("Spade", "King"))
    ent.addCards(listOf("Spade", "Jack"))
    ent.addCards(listOf("Heart", "3"))
    ent.addCards(listOf("Spade", "Jack"))

//    println(ent)

    println("================================")

    ent.getStatus()
}
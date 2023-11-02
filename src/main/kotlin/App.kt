import entity.Default
import utility.RandomCards

fun main() {
    val cr = RandomCards()

    val ent = Default("Dest", 15000)

    ent.addCards("J", "Heart")
    ent.addCards("10", "Heart")
    ent.addCards("9", "Heart")
    ent.addCards("8", "Heart")
    ent.addCards("7", "Heart")

//    println(ent)

    println("================================")

    println(
        ent.getStatus()
    )
}
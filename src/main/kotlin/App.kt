import entity.Default
import utility.RandomCards

fun main() {
    val cr = RandomCards()

    val ent = Default("Dest", 15000)

    ent.addCards(cr.getRandom())
    ent.addCards(cr.getRandom())
    ent.addCards(cr.getRandom())
    ent.addCards(cr.getRandom())

    println(ent)
}
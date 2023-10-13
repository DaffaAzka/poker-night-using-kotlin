package utility

public class RandomCards {

    private val symbols = listOf("Clover", "Diamonds", "Heart", "Spade");
    private val tier = listOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "A")

    public fun getRandom(): List<String> {
        val v1 = symbols[(0..3).random()]
        val v2 = tier[(0..12).random()]
        return listOf(v1, v2)
    }

}
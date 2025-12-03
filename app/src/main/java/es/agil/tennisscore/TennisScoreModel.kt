package es.agil.tennisscore

class TennisScoreModel {
    private var scoreA = 0
    private var scoreB = 0
    private var gamesA = 0
    private var gamesB = 0
    private var currentSetA = 0
    private var currentSetB = 0
    private var SetsA = listOf("_", "_", "_", "_", "_")
    private var SetsB = listOf("_", "_", "_", "_", "_")
    private var pointsA = Points.LOVE
    private var pointsB = Points.LOVE
    private var numSets = 3

    enum class Points(val p: List<String>){
        LOVE(listOf("0", "0")),
        FIFTEEN(listOf("1", "5")),
        THIRTY(listOf("3", "0")),
        FORTY(listOf("4", "0")),
        ADVANTAGE(listOf("A", "d"))
    }
}
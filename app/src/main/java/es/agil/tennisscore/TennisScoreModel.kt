package es.agil.tennisscore

class TennisScoreModel:ITennisScoreModel {
    private var scoreA = 0
    private var scoreB = 0
    private var gamesA = 0
    private var gamesB = 0
    private var setsA = mutableListOf(0, 0, 0, 0, 0)
    private var setsB = mutableListOf(0, 0, 0, 0, 0)
    private var pointsA = Points.LOVE
    private var pointsB = Points.LOVE
    private var numSets = 3
    private var activeSet = 1

    enum class Points(val p: List<String>){
        LOVE(listOf("0", "0")),
        FIFTEEN(listOf("1", "5")),
        THIRTY(listOf("3", "0")),
        FORTY(listOf("4", "0")),
        ADVANTAGE(listOf("A", "d"))
    }

    override fun addPointA() {
        val allEnumValues = Points.values()
        val currentPos = pointsA.ordinal
        if (currentPos < allEnumValues.lastIndex){
            pointsA = allEnumValues[currentPos + 1]
        }
    }

    override fun addPointB() {
        val allEnumValues = Points.values()
        val currentPos = pointsB.ordinal
        if (currentPos < allEnumValues.lastIndex){
            pointsB = allEnumValues[currentPos + 1]
        }
    }

    override fun setDeuce() {
        pointsA = Points.FORTY
        pointsB = Points.FORTY
    }

    override fun getPointsA(): Points {
        return pointsA
    }

    override fun getPointsB(): Points {
        return pointsB
    }

    override fun resetPoints() {
        pointsA = Points.LOVE
        pointsB = Points.LOVE
    }

    override fun getGamesA():Int {
        return gamesA
    }

    override fun getGamesB():Int {
        return gamesB
    }

    override fun increaseGamesA() {
        gamesA += 1
    }

    override fun increaseGamesB() {
        gamesB += 1
    }

    override fun resetGames() {
        gamesA = 0
        gamesB = 0
    }

    override fun increaseNumSets() {
        if (numSets == 3) {
            numSets = 5
        }
    }

    override fun decreaseNumSets() {
        if(numSets == 5){
            numSets = 3
        }
    }

    override fun increaseActiveSet() {
        activeSet += 1
    }

    override fun getNumSets():Int {
        return numSets
    }

    override fun getActiveSet(): Int {
        return activeSet
    }

    override fun setSets(index:Int) {
        setsA[index] = gamesA
        setsB[index] = gamesB
    }

    override fun getSetsA(): List<Int> {
        return setsA
    }

    override fun getSetsB(): List<Int> {
        return setsB
    }

    override fun nextSet() {
        if(activeSet < numSets) {
            activeSet += 1
        }
    }

    override fun resetActiveSet() {
        activeSet = 1
    }

    override fun resetSets() {
        setsA = mutableListOf(0, 0, 0, 0, 0)
        setsB = mutableListOf(0, 0, 0, 0, 0)
    }

    override fun getScoreA():Int {
        return scoreA
    }

    override fun getScoreB():Int {
        return scoreB
    }

    override fun increaseScoreA() {
        scoreA += 1
    }

    override fun increaseScoreB() {
        scoreB += 1
    }

    override fun resetScores() {
        scoreA = 0
        scoreB = 0
    }

    override fun resetAll() {
        resetScores()
        resetActiveSet()
        resetSets()
        resetGames()
        resetPoints()
    }
}
package es.agil.tennisscore

interface ITennisScoreModel {
    fun addPointA()
    fun addPointB()
    fun setDeuce()
    fun getPointsA():TennisScoreModel.Points
    fun getPointsB():TennisScoreModel.Points
    fun resetPoints()

    fun getGamesA():Int
    fun getGamesB():Int
    fun increaseGamesA()
    fun increaseGamesB()
    fun resetGames()

    fun increaseNumSets()
    fun decreaseNumSets()
    fun increaseActiveSet()
    fun getNumSets():Int
    fun getActiveSet():Int

    fun setSets(index:Int)
    fun getSetsA():List<Int>
    fun getSetsB():List<Int>
    fun nextSet()
    fun resetActiveSet()
    fun resetSets()

    fun getScoreA():Int
    fun getScoreB():Int
    fun increaseScoreA()
    fun increaseScoreB()
    fun resetScores()

    fun resetAll()
}
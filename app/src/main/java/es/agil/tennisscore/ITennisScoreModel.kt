package es.agil.tennisscore

interface ITennisScoreModel {
    fun resetPoints()
    fun resetScores()
    fun resetSets()
    fun resetGames()
    fun resetAll()
    fun addPointA()
    fun addPointB()
    fun getScoreA()
    fun getScoreB()
    fun getGamesA()
    fun getGamesB()
    fun getSetsA()
    fun getSetsB()
    fun getPointsA()
    fun getPointsB()
    fun getNumSets()
    fun increaseNumSets()
    fun decreaseNumSets()
}
package es.agil.tennisscore

interface ITennisScoreView {
    fun updateScore()
    fun updateSets()
    fun updateGames()
    fun updatePoints()
    fun changeNumOfSets()
    fun addPointA()
    fun addPointB()
    fun updateAll()
}
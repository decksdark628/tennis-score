package es.agil.tennisscore

interface ITennisScoreView {
    fun setScore(nA:Int, nB:Int)
    fun setSets(nA:Int, nB:Int, ind:Int)
    fun updateGames(nA:Int, nB:Int)
    fun setPointA(s1:String, s2:String)
    fun setPointB(s1:String, s2:String)
    fun resetSets()
    fun showExtraSets()
    fun hideExtraSets()
    fun disablePointButtons()
    fun enablePointButtons()
}
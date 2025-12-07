package es.agil.tennisscore

class TennisScoreController(private val view: TennisScoreActivity) {
    private val model:TennisScoreModel = TennisScoreModel()

    fun resetAll(){
        model.resetAll()
        view.enablePointButtons()
    }

    private fun updatePoints(){
        val leftA = model.getPointsA().p[0]
        val rightA = model.getPointsA().p[1]
        view.setPointA(leftA, rightA)

        val leftB = model.getPointsB().p[0]
        val rightB = model.getPointsB().p[1]
        view.setPointB(leftB, rightB)
    }

    private fun updateGames(){
        view.updateGames(model.getGamesA(), model.getGamesB())
    }

    private fun updateScores(){
        view.setScore(model.getScoreA(), model.getScoreB())
    }

    private fun updateView(){
        updatePoints()
        updateGames()
        updateScores()
        //sets are update in the set writeSet method
    }

    fun addPointA(){
        val a = model.getPointsA()
        val b = model.getPointsB()
        if(a == TennisScoreModel.Points.ADVANTAGE){
            addGame(1)
        }
        else if (a == TennisScoreModel.Points.FORTY){
                if (b == TennisScoreModel.Points.FORTY){
                    model.addPointA()
                }
                else{
                    addGame(1)
                }
        }
        else{
            if (a == TennisScoreModel.Points.THIRTY && b == TennisScoreModel.Points.ADVANTAGE)
                model.setDeuce()
            else{
                model.addPointA()
            }
        }
        updateView()
        checkWinCondition()
    }

    private fun addGame(player:Int){
        val gamesA = model.getGamesA()
        val gamesB = model.getGamesB()
        //SET
        if (player == 1) {
            if (gamesA>= 6 && gamesA - gamesB >= 2){
                writeSet()
            }
            else{
                model.increaseGamesA()
                model.increaseScoreA()
            }
        }
        else{
            if(gamesB>= 6 && gamesB - gamesA >= 2) {
            }
            else{
                model.increaseGamesB()
                model.increaseScoreB()
            }
        }
    }

    private fun writeSet(){
        val indexOfSetToModify = model.getActiveSet() -1
        if (indexOfSetToModify in 0..<model.getNumSets()){
            model.setSets(indexOfSetToModify)
            view.setSets(model.getGamesA(), model.getGamesB(), indexOfSetToModify)
            model.increaseActiveSet()
            model.resetGames()
        }
    }

    private fun checkWinCondition(){
        val setsNeededToWin = (model.getNumSets()+1)/2 // Añado 1 para redondear siempre hacia arriba. Al dividir dos Ints, el resultado será solo la parte Int de la division.
        if (model.getScoreA() >= setsNeededToWin || model.getScoreB() >= setsNeededToWin)
            view.disablePointButtons()
    }

    fun addPointB() {
        val a = model.getPointsA()
        val b = model.getPointsB()
        if (b == TennisScoreModel.Points.ADVANTAGE) {
            addGame(2)
        } else if (b == TennisScoreModel.Points.FORTY) {
            if (a == TennisScoreModel.Points.FORTY) {
                model.addPointB()
            } else {
                addGame(2)
            }
        } else {
            if (b == TennisScoreModel.Points.THIRTY && a == TennisScoreModel.Points.ADVANTAGE)
                model.setDeuce()
            else {
                model.addPointB()
            }
        }
        updateView()
        checkWinCondition()
    }

    fun radBut3Selected(){
        view.hideExtraSets()
        model.resetAll()
        updateView()
    }

    fun radBut5Selected(){
        view.showExtraSets()
        model.resetAll()
        updateView()
    }
}
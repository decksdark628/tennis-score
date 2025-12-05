package es.agil.tennisscore

class TennisScoreController(private val view: TennisScoreActivity) {
    private val model:TennisScoreModel = TennisScoreModel()

    fun reset(){
        model.resetAll()
        view.enablePointButtons()
        view.updateAll()
    }

    fun attemptToAddPointA():Boolean{
        val a = model.getPointsA()
        var result = false
        if (a == TennisScoreModel.Points.ADVANTAGE && attemptToIncreaseGamesA()){
            result = true
            model.resetPoints() //GAME
        }
        else if (a == TennisScoreModel.Points.FORTY) {
            if (model.getPointsB() == TennisScoreModel.Points.FORTY) { // DEUCE: continues
                model.addPointA() //ADVANTAGE
                result = true
            }
            else if (model.getPointsB() == TennisScoreModel.Points.ADVANTAGE){
                model.setDeuce() //Removes advantage of opponent
            }
            else { // GAME
                result = attemptToIncreaseGamesA()
                if(result){
                    model.resetPoints()
                }
            }
        }
        else{ // continues
            model.addPointA()
            result = true
        }

        return result
    }

    private fun attemptToIncreaseGamesA():Boolean{
        val a = model.getGamesA()

        var result = false
        if (a >= 6 && a - model.getGamesB() >= 2){
            result = attemptToWriteCurrentSet()
            if (result){
                model.increaseScoreA()
                model.resetGames()
                result = true
            }
        }
        else{
            model.increaseGamesA()
            result = true
        }
        return result
    }

    private fun attemptToWriteCurrentSet():Boolean{
        val indexOfSetToModify = model.getActiveSet() -1
        if (indexOfSetToModify in 0..<model.getNumSets()) {
            model.setSets(indexOfSetToModify)
            model.increaseActiveSet()
            return checkWinCondition()
        }
        return false
    }

    private fun checkWinCondition():Boolean{
        val setsNeededToWin = (model.getNumSets()+1)/2 // Añado 1 para redondear siempre hacia arriba. Al dividir dos Ints, el resultado será solo la parte Int de la division.
        if (model.getScoreA() >= setsNeededToWin || model.getScoreB() >= setsNeededToWin)
            view.disablePointButtons()
        return false
    }
}
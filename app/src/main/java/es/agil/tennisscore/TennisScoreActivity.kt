package es.agil.tennisscore

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TennisScoreActivity : AppCompatActivity(), ITennisScoreView {
    private lateinit var radGroup:RadioGroup

    private lateinit var scoreA:TextView
    private lateinit var scoreB:TextView

    private lateinit var setsA1:TextView
    private lateinit var setsA2:TextView
    private lateinit var setsA3:TextView
    private lateinit var setsA4:TextView
    private lateinit var setsA5:TextView

    private lateinit var setsB1:TextView
    private lateinit var setsB2:TextView
    private lateinit var setsB3:TextView
    private lateinit var setsB4:TextView
    private lateinit var setsB5:TextView

    private lateinit var gamesWonA:TextView
    private lateinit var gamesWonB:TextView

    private lateinit var pointsALeft:TextView
    private lateinit var pointsARight:TextView

    private lateinit var pointsBLeft:TextView
    private lateinit var pointsBRight:TextView

    private lateinit var btnPointA:Button
    private lateinit var btnPointB:Button
    private lateinit var btnReset:Button

    private lateinit var controller:TennisScoreController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radGroup = findViewById(R.id.radButGroup)
        scoreA = findViewById(R.id.scoreA)
        scoreB = findViewById(R.id.scoreB)
        setsA1 = findViewById(R.id.setsA1)
        setsA2 = findViewById(R.id.setsA2)
        setsA3 = findViewById(R.id.setsA3)
        setsA4 = findViewById(R.id.setsA4)
        setsA5 = findViewById(R.id.setsA5)
        setsB1 = findViewById(R.id.setsB1)
        setsB2 = findViewById(R.id.setsB2)
        setsB3 = findViewById(R.id.setsB3)
        setsB4 = findViewById(R.id.setsB4)
        setsB5 = findViewById(R.id.setsB5)
        gamesWonA = findViewById(R.id.gamesWonA)
        gamesWonB = findViewById(R.id.gamesWonB)
        pointsALeft = findViewById(R.id.pointsALeft)
        pointsBLeft = findViewById(R.id.pointsBLeft)
        pointsARight = findViewById(R.id.pointsARight)
        pointsBRight = findViewById(R.id.pointsBRight)
        btnPointA = findViewById(R.id.BtnPointA)
        btnPointB = findViewById(R.id.BtnPointB)
        btnReset = findViewById(R.id.BtnReset)
        controller = TennisScoreController(this)

        radGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId){
                R.id.radBut3 -> {
                    controller.radBut3Selected()
                }
                R.id.radBut5 ->{
                    controller.radBut5Selected()
                }
            }
        }
    }

    override fun setScore(nA: Int, nB: Int) {
        scoreA.text = nA.toString()
        scoreB.text = nB.toString()
    }

    override fun setSets(nA: Int, nB: Int, ind:Int) {
        when (ind) {
            1 -> {
                setsA1.text = nA.toString()
                setsB1.text = nB.toString()
            }
            2 -> {
                setsA2.text = nA.toString()
                setsB2.text = nB.toString()
            }
            3 -> {
                setsA3.text = nA.toString()
                setsB3.text = nB.toString()
            }
            4 -> {
                setsA4.text = nA.toString()
                setsB4.text = nB.toString()
            }
            5 -> {
                setsA5.text = nA.toString()
                setsB5.text = nB.toString()
            }
        }
    }

    override fun updateGames(nA: Int, nB: Int) {
        gamesWonA.text = nA.toString()
        gamesWonB.text = nB.toString()
    }

    override fun setPointA(s1: String, s2: String) {
        pointsALeft.text = s1
        pointsARight.text = s2
    }

    override fun setPointB(s1: String, s2: String) {
        pointsBLeft.text = s1
        pointsBRight.text = s2
    }

    override fun showExtraSets() {
        setsA4.visibility = View.VISIBLE
        setsA5.visibility = View.VISIBLE
        setsB4.visibility = View.VISIBLE
        setsB5.visibility = View.VISIBLE
    }

    override fun hideExtraSets() {
        setsA4.visibility = View.GONE
        setsA5.visibility = View.GONE
        setsB4.visibility = View.GONE
        setsB5.visibility = View.GONE
    }

    override fun disablePointButtons() {
        btnPointA.isEnabled = false
        btnPointB.isEnabled = false
    }

    override fun enablePointButtons() {
        btnPointA.isEnabled = true
        btnPointB.isEnabled = true
    }

    fun resetAll(view: View) {
        controller.resetAll()
    }
    fun addPointB(view: View) {
        controller.addPointB()
    }
    fun addPointA(view: View) {
        controller.addPointA()
    }
}
package es.agil.tennisscore

import android.os.Bundle
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

    private lateinit var controller:TennisScoreController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*enableEdgeToEdge()*/
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
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
        controller = TennisScoreController(this)

    }

    override fun updateScore() {
        TODO("Not yet implemented")
    }

    override fun updateSets() {
        TODO("Not yet implemented")
    }

    override fun updateGames() {
        TODO("Not yet implemented")
    }

    override fun updatePoints() {
        TODO("Not yet implemented")
    }

    override fun changeNumOfSets() {
        TODO("Not yet implemented")
    }

    override fun addPointA() {
        TODO("Not yet implemented")
    }

    override fun addPointB() {
        TODO("Not yet implemented")
    }

    override fun updateAll() {
        TODO("Not yet implemented")
    }
}
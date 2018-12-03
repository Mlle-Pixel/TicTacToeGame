package fr.epita.tictactoegame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class GameActivity : AppCompatActivity() {

    var prs_name : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val b = intent.extras
        if (b != null)
            prs_name = b.getString("prs_name")!!

        Toast.makeText(this@GameActivity, prs_name, Toast.LENGTH_SHORT).show()


    }
}

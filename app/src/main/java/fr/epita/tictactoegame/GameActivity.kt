package fr.epita.tictactoegame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

// player X = 0 (Guest)
// player O = 1 (Player)

class GameActivity : AppCompatActivity() {

    var prs_name : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val b = intent.extras
        if (b != null) {
            prs_name = b.getString("prs_name")!!
            player_O.setText(("O("+ prs_name + ")"))
            player_X.setText(("X(Player)"))
        }

        val r = Random()
        var turn = r.nextInt(2 - 0)

        fun changeTurn() {
            if (turn == 1) {
                player_turn_X.setText("")
                player_turn_X.setText("Player turn  :")
            } else {
                player_turn_O.setText("")
                player_turn_X.setText("Player turn  :")
            }
        }

        changeTurn()


        fun changeValueBtn(button: Button) {
            if (turn == 0) {
                button.setText("X")
                turn++
            }
            else {
                button.setText("O")
                turn--
            }
            changeTurn()
        }

        fun victory() {
            if (turn == 1)
                Toast.makeText(this@GameActivity, "Guest Win !", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this@GameActivity, prs_name + " Win !", Toast.LENGTH_SHORT).show()
        }

        fun check_win() {
            // ligne
            if (btn_1.text != "" && btn_2.text != "" && btn_3.text != "" && btn_1.text == btn_2.text && btn_2.text == btn_3.text)
                victory()
            if (btn_4.text != "" && btn_5.text != "" && btn_6.text != "" && btn_4.text == btn_5.text && btn_5.text == btn_6.text)
                victory()

            if (btn_7.text != "" && btn_8.text != "" && btn_9.text != "" &&btn_7.text == btn_8.text && btn_8.text == btn_9.text)
                victory()

            // collonne
            if (btn_1.text != "" && btn_4.text != "" && btn_7.text != "" && btn_1.text == btn_4.text && btn_1.text == btn_7.text)
                victory()
            if (btn_5.text != "" && btn_2.text != "" && btn_8.text != "" && btn_2.text == btn_5.text && btn_2.text == btn_8.text)
                victory()
            if (btn_3.text != "" && btn_6.text != "" && btn_9.text != "" && btn_3.text == btn_6.text && btn_3.text == btn_9.text)
                victory()

            // diagonal
            if (btn_1.text != "" && btn_5.text != "" && btn_9.text != "" && btn_1.text == btn_5.text && btn_1.text == btn_9.text)
                victory()
            if (btn_5.text != "" && btn_3.text != "" && btn_7.text != "" && btn_3.text == btn_5.text && btn_3.text == btn_7.text)
                victory()
        }




        btn_1.setOnClickListener {
            changeValueBtn(btn_1)
            check_win()
        }

        btn_2.setOnClickListener {
            changeValueBtn(btn_2)
            check_win()
        }

        btn_3.setOnClickListener {
            changeValueBtn(btn_3)
            check_win()
        }

        btn_4.setOnClickListener {
            changeValueBtn(btn_4)
            check_win()
        }

        btn_5.setOnClickListener {
            changeValueBtn(btn_5)
            check_win()
        }

        btn_6.setOnClickListener {
            changeValueBtn(btn_6)
            check_win()
        }

        btn_7.setOnClickListener {
            changeValueBtn(btn_7)
            check_win()
        }

        btn_8.setOnClickListener {
            changeValueBtn(btn_8)
            check_win()
        }

        btn_9.setOnClickListener {
            changeValueBtn(btn_9)
            check_win()
        }

    }
}

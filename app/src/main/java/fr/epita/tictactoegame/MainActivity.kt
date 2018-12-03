package fr.epita.tictactoegame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            if (input_prs_name.text.toString() == "Name") {
                Toast.makeText(this@MainActivity, "Please enter a name :)", Toast.LENGTH_SHORT).show()
            } else {
                val change_to_gameActivity = Intent(this@MainActivity, GameActivity::class.java)
                change_to_gameActivity.putExtra("prs_name", input_prs_name.text.toString())
                startActivity(change_to_gameActivity)
            }
        }
    }
}

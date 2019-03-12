package dinesh.example.language.game.view

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import dinesh.example.language.game.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert

class MainActivity : AppCompatActivity() {

    private val presenter: Presenter = Presenter()
    private lateinit var fallingWordAnimation: Animation
    private var score = 0
    private var round = 0
    private var userStop: Boolean = false
    private lateinit var answer: String
    private lateinit var givenWord: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress_fetch.visibility = VISIBLE
        presenter.getWords(object : PresenterCallback {
            override fun onSuccess() {
                runOnUiThread {
                    progress_fetch.visibility = INVISIBLE
                }
                loadChallenge()
                challenge_text.startAnimation(fallingWordAnimation)
            }

        })
        playTheGame()
    }

    override fun onStart() {
        super.onStart()
        yes_button.setOnClickListener { getResult(true) }
        no_button.setOnClickListener { getResult(false) }
    }

    @SuppressLint("SetTextI18n")
    private fun getResult(result: Boolean) {
        stopAnimation()
        if (presenter.checkMatch(result)) {
            showDialog("Correct")
            score += 1
            score_text.text = "$score"
        } else {
            showDialog("Wrong")
        }
    }


    private fun showDialog(alertTitle: String) {
        alert {
            title = alertTitle
            message = "${presenter.challengeWordPair.text_eng} is ${presenter.challengeWordPair.text_spa}"
            negativeButton("Next Round") { dialog ->
                newRound(dialog)
                round += 1
                round_text.text = "$round"
            }
            positiveButton("Restart") { dialog ->
                restart(dialog)
            }
        }.show()
    }


    private fun restart(dialog: DialogInterface) {
        dialog.dismiss()
        restartMetrics()
        resetScores()
    }

    private fun resetScores() {
        score_text.text = "0"
        round_text.text = "0"
        score = 0
        round = 0
    }

    private fun newRound(dialog: DialogInterface) {
        dialog.dismiss()
        restartMetrics()
    }

    private fun restartMetrics() {
        userStop = false
        loadChallenge()
        runOnUiThread {
            challenge_text.startAnimation(fallingWordAnimation)
        }
    }


    private fun loadChallenge() {
        val (question, answer, choice) = presenter.loadChallengeWord()
        runOnUiThread {
            challenge_text.text = choice
            translation_text.text = question
            this.givenWord = choice
            this.answer = answer
        }
    }

    private fun stopAnimation() {
        userStop = true
        runOnUiThread {
            challenge_text.clearAnimation()
        }
    }


    private fun playTheGame() {
        fallingWordAnimation = AnimationUtils.loadAnimation(this, R.anim.falling_anim)
        fallingWordAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                if (!userStop) {
                    showDialog("Time up")
                }
            }

            override fun onAnimationStart(p0: Animation?) {}
        })
    }
}

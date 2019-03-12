package dinesh.example.language.game.view

import dinesh.example.language.game.model.WordPair
import dinesh.example.language.game.network.RestCallerImpl
import dinesh.example.language.game.network.WordCaptureCallback
import dinesh.example.language.game.network.WordsCapture
import org.jetbrains.anko.doAsync
import timber.log.Timber
import kotlin.random.Random

/**
 * Created by dineshvg on 28.02.19 for LanguageGame in dinesh.example.language.game.view.
 * 03: 39
 */
class Presenter {

    lateinit var wordList: List<WordPair>
    lateinit var challengeWordPair: WordPair
    lateinit var choiceInLanguageTwo: WordPair

    fun getWords(callback: PresenterCallback) {
        doAsync {
            WordsCapture(RestCallerImpl()).getWordList(object : WordCaptureCallback {
                override fun onSuccess(list: List<WordPair>) {
                    wordList = list
                    callback.onSuccess()
                }

                override fun onError() {
                    Timber.e("Error getting words getWords()")
                }

            })
        }
    }

    fun loadChallengeWord(): Triple<String, String, String> {
        val randomQuestionVal = Random.nextInt(wordList.size - 1)
        challengeWordPair = wordList[randomQuestionVal]
        choiceInLanguageTwo = wordList[getRandomValForChoice(randomQuestionVal)]
        return Triple(challengeWordPair.text_eng, challengeWordPair.text_spa, choiceInLanguageTwo.text_spa)
    }

    internal fun getRandomValForChoice(randomRange: Int): Int {
        return when (randomRange) {
            0 -> Random.nextInt(0, 5)
            in wordList.size - 5..wordList.size -> Random.nextInt(wordList.size - 5, wordList.size - 1)
            else -> {
                Random.nextInt(randomRange - 2, randomRange + 2)
            }
        }
    }

    fun checkMatch(matches: Boolean): Boolean {
        val wordMatch = (challengeWordPair == choiceInLanguageTwo)
        if (wordMatch && matches) return true
        if (!wordMatch && !matches) return true
        if (wordMatch && !matches) return false
        if (!wordMatch && matches) return false
        return false
    }
}

interface PresenterCallback {
    fun onSuccess()
}
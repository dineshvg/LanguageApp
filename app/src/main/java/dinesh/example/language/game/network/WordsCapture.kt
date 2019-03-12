package dinesh.example.language.game.network

import java.util.*

/**
 * Created by dineshvg on 28.02.19 for LanguageGame in dinesh.example.language.game.network.
 * 00: 27
 */
class WordsCapture(private val restCaller: RestCaller) {

    fun getWordList(wordCaptureCallback: WordCaptureCallback) {
        try {
            wordCaptureCallback.onSuccess(restCaller.retrieveWordsJson())
        } catch (e: MissingResourceException) {
            wordCaptureCallback.onError()
        }

    }
}
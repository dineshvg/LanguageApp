package dinesh.example.language.game.network

import dinesh.example.language.game.model.WordPair

/**
 * Created by dineshvg on 28.02.19 for LanguageGame in dinesh.example.language.game.network.
 * 02: 36
 */
interface WordCaptureCallback {

    fun onSuccess(list: List<WordPair>)

    fun onError()
}
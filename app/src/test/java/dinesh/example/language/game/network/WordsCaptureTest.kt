package dinesh.example.language.game.network

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import dinesh.example.language.game.model.WordPair
import org.junit.Test

/**
 * Created by dineshvg on 28.02.19 for LanguageGame in dinesh.example.language.game.network.
 * 00: 30
 */
class WordsCaptureTest {

    @Test
    fun getWordListSuccess() {
        val wordCaptureCallback: WordCaptureCallback = mock()
        val wordsCapture = WordsCapture(MockImplSuccess())
        wordsCapture.getWordList(wordCaptureCallback)
        verify(wordCaptureCallback, times(1)).onSuccess(emptyList())
    }
}

class MockImplSuccess : RestCaller {
    override fun retrieveWordsJson(): List<WordPair> {
        return emptyList()
    }

}

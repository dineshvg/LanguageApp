package dinesh.example.language.game.view

import dinesh.example.language.game.model.WordPair
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Created by dineshvg on 28.02.19 for LanguageGame in dinesh.example.language.game.view.
 * 14: 49
 */
class PresenterTest {

    @Test
    fun checkMatchTest() {
        val presenter = Presenter()

        presenter.challengeWordPair = WordPair("hey", "ola")
        presenter.choiceInLanguageTwo = WordPair("hey", "ola")
        assertEquals(presenter.checkMatch(true), true)

        presenter.choiceInLanguageTwo = WordPair("good", "buena")
        assertEquals(presenter.checkMatch(true), false)
    }

    @Test
    fun getRandomValForChoiceTest() {
        val presenter = Presenter()
        loadWordList(presenter)

        assertNotNull(presenter.getRandomValForChoice(3))
        //loop 1 test
        when (presenter.getRandomValForChoice(3)) {
            in 0..5 -> assert(true)
            else -> assert(false)
        }

        assertNotNull(presenter.getRandomValForChoice(presenter.wordList.size - 1))
        //loop 2 test
        when (presenter.getRandomValForChoice(presenter.wordList.size - 1)) {
            in presenter.wordList.size - 5..presenter.wordList.size -> assert(true)
            else -> assert(false)
        }
    }

    @Test
    fun loadChallengeWordTest() {
        val presenter = Presenter()
        loadWordList(presenter)

        val triple = presenter.loadChallengeWord()
        assertNotNull(triple)

    }

    private fun loadWordList(presenter: Presenter) {
        presenter.wordList = listOf(
            WordPair("hey", "ola"),
            WordPair("good", "buena"),
            WordPair("hey", "ola"),
            WordPair("good", "buena"),
            WordPair("hey", "ola"),
            WordPair("good", "buena"),
            WordPair("hey", "ola"),
            WordPair("good", "buena"),
            WordPair("hey", "ola"),
            WordPair("good", "buena"),
            WordPair("hey", "ola"),
            WordPair("good", "buena")
        )
    }
}
package dinesh.example.language.game.network

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import dinesh.example.language.game.model.WordPair
import java.util.*

/**
 * Created by dineshvg on 28.02.19 for LanguageGame in dinesh.example.language.game.network.
 * 14: 32
 */
class RestCallerImpl : RestCaller {

    override fun retrieveWordsJson(): List<WordPair> {
        FuelManager.instance.basePath = BASE_PATH
        val response = WORDS_LINK.httpGet().responseString()
        return WordPair.Deserializer()
            .deserializeWordPairList(
                response.third.component1() ?: throw MissingResourceException(
                    "List cannot be retrieved",
                    WordPair::class.simpleName,
                    "No key required"
                )
            )
    }
}
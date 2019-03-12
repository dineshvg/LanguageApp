package dinesh.example.language.game.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonEncodingException
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

/**
 * Created by dineshvg on 28.02.19 for LanguageGame in dinesh.example.language.game.model.
 * 00: 33
 */
data class WordPair(
    val text_eng: String,
    val text_spa: String
) {
    class Deserializer : ResponseDeserializable<WordPair> {

        fun deserializeWordPairList(content: String): List<WordPair> {
            val listType = Types.newParameterizedType(List::class.java, WordPair::class.java)
            val adapter: JsonAdapter<List<WordPair>> = Moshi.Builder().build().adapter(listType)
            return adapter.fromJson(content) ?: throw JsonEncodingException("Error deserializing wordpair")
        }
    }

}
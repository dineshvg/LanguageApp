# LanguageApp
A language app built in kotlin. English and Spanish words are compared with a falling animation.

### Falling words

The player will see a word in language "one" on the screen. While this is displayed, a word from language "two" will fall from the top of the screen.
The player will have to choose if the falling word is a correct or wrong translation. The answer has to be given before the word reaches the bottom of the screen.

A counter of the the number of correct answers and the number of times the game has been played is displayed in the screen.

## Libraries used
    * implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    * implementation "org.jetbrains.kotlin:kotlin-reflect:1.3.21"
    * implementation 'com.android.support:appcompat-v7:28.0.0'
    * implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    * androidTestImplementation 'com.android.support.test:runner:1.0.2'
    * androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    
    * implementation "org.jetbrains.anko:anko:$anko_version"
    * implementation "org.jetbrains.anko:anko-commons:$anko_version"
   
    * implementation 'com.jakewharton.timber:timber:4.7.1'
 
    * implementation "com.github.kittinunf.fuel:fuel:$fuel_version", {exclude group: 'com.github.kittinunf.result', module: 'result'}
    * implementation "com.github.kittinunf.fuel:fuel-moshi:$fuel_version", {exclude group: 'com.github.kittinunf.result', module: 'result'}
    * implementation "com.github.kittinunf.result:result:$fuel_result_version", {exclude group: 'org.jetbrains.kotlin', module: 'kotlin-stdlib'}
    * testImplementation "com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0"
    * testImplementation 'junit:junit:4.12'
    

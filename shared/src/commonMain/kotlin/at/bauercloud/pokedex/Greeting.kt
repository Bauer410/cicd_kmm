package at.bauercloud.pokedex

class Greeting(private val platform: Platform) {

    fun greet(): String {
        return "This text is from KMM with platform: ${platform.name}!"
    }
}
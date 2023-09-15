package Config

class Config {

    fun gerarID(): String {
        val caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        val tamanho = 6
        val random = java.util.Random()
        val id = StringBuilder()

        repeat(tamanho) {
            val index = random.nextInt(caracteres.length)
            id.append(caracteres[index])
        }

        return id.toString()
    }

}
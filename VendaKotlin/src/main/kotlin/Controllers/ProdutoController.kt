package Controllers

import Config.Config
import Models.Produto
import Views.menuProduto

class ProdutoController {

    val gerarID = Config();
    val listaProtudos = mutableListOf<Produto>()
    val retornar = menuProduto()

    val id = gerarID.gerarID()

    init{
        listaProtudos.add(Produto(id,"Notebook Lenovo", 5000.0))
    }

    fun cadastroProduto(){

        println("Informe o nome do produto: ")
        val nome = readLine()
        println("Informe o valor do produto: ")
        val valorStg = readLine()

        val valor = valorStg?.toDouble()
        val id = gerarID.gerarID()

        if(nome != null && valor != null) {
            val produto = Produto(id, nome, valor)

            listaProtudos.add(produto)
            println("${produto.nome} Cadastrado com sucesso!!")
        }else{
            println("Erro ao cadastrar, revise os dados informados")
        }

        retornar.mostrarMenu()
    }

    fun consultarProdutos(){
        println("Produtos Cadastrados: ")
        listaProtudos.forEach{produto ->
            println("ID: ${produto.id} | Nome: ${produto.nome} | Valor: R$${produto.valor}")
            println("-----------------------------------------")
        }
    retornar.mostrarMenu()
    }

    fun removerProduto(){
        println("Informe o código do produto que deseja remover: ")
        val id = readLine()

        if(id != null){
            val produtoRemover = listaProtudos.find{it.id == id}
            if(produtoRemover != null){
                listaProtudos.remove(produtoRemover)
                println("Produto ${produtoRemover.nome} removido com sucesso!")
            }else(
                println("Produto não encontrado")
            )
        }else{
            println("Código inválido")
        }

    retornar.mostrarMenu()
    }

    fun atualizarProduto(){
        println("Informe o código do produto que deseja atualizar: ")
        val id = readLine()

        if(id != null){
            val produtoAtualizar = listaProtudos.find { it.id == id }
            if(produtoAtualizar != null){
                println("Informe o nome do produto: ")
                val novoNome = readLine()
                print("Informe o valor do produto: ")
                val novoValorString = readLine()

                if(novoNome != null && novoValorString != null) {
                    val novoValor = novoValorString.toDouble()

                    produtoAtualizar.nome = novoNome
                    produtoAtualizar.valor = novoValor

                    println("Produto ${novoNome} atualizado com sucesso")
                }
            }else{
                println("Produto não encontrado")
            }
        }else{
            println("Código inválido")
        }
    retornar.mostrarMenu()
    }

}
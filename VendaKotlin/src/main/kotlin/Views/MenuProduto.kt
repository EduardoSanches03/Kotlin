package Views

import Controllers.ProdutoController

val produtoController = ProdutoController();
val voltarinicio = menuInicial();

class menuProduto {

    fun mostrarMenu() {
        println("Informe a opção desejada: ");
        println("1 - Cadastro de produto");
        println("2 - Consultar produtos");
        println("3 - Remover produto cadastrado");
        println("4 - Atualizar dados do produto");
        println("0 - Sair")
        val opcao = readLine();

        when (opcao) {
            "1" -> produtoController.cadastroProduto();
            "2" -> produtoController.consultarProdutos()
            "3" -> produtoController.removerProduto()
            "4" -> produtoController.atualizarProduto()
            "0" -> voltarinicio.menuInicial()
            else -> println("Opção Inválida")
        }
    }
}
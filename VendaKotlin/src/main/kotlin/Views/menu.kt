package Views

val menuCliente = menuClientes()
val menuProdutos = menuProduto()
val menuVenda = MenuVenda()

class menuInicial {

    fun menuInicial() {
        println("Informe a opção desejada: ");
        println("1 - Menu Clientes ");
        println("2 - Menu Produtos ");
        println("3 - Menu Vendas ");
        val opcao = readLine();

        when (opcao) {
            "1" -> menuCliente.mostrarMenu();
            "2" -> menuProdutos.mostrarMenu()
            "3" -> menuVenda.mostrarMenu()
        }

    }
}

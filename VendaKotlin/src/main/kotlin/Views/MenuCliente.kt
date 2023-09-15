package Views

import Controllers.ClienteController
val clienteController = ClienteController();
val inicio = menuInicial();

class menuClientes {

    fun mostrarMenu() {
        println("Informe a opção desejada: ");
        println("1 - Cadastro de CLientes ");
        println("2 - Consulta de Clientes");
        println("3 - Apagar registro de Cliente");
        println("4 - Atualizar cadastro do Cliente");
        println("0 - Sair")
        val opcao = readLine();

        when (opcao) {
            "1" -> clienteController.cadastroCliente();
            "2" -> clienteController.consultarClientes()
            "3" -> clienteController.removerCadastro()
            "4" -> clienteController.atualizarCadastro()
            "0" -> inicio.menuInicial()
            else -> println("Opção Inválida")
        }
    }
}
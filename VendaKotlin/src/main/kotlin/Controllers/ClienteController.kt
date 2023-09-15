package Controllers

import Models.Cliente
import Views.menuClientes

class ClienteController {

    val listaClientes = mutableListOf<Cliente>()

    init {
        listaClientes.add(Cliente("1", "Eduardo", "19"))
    }

    val retornar = menuClientes()

    fun cadastroCliente() {
        println("Informe o cpf do cliente: ")
        val cpf = readLine()
        println("Informe o nome do cliente: ")
        val nome = readLine()
        println("Informe a idade do cliente: ")
        val idade = readLine()

        if (cpf != null && nome != null && idade != null) {

            val cliente = Cliente(cpf, nome, idade)

            listaClientes.add(cliente)

            println("-------------------------------")
            println("Cliente adicionado: ${cliente.nome}")
            println("-------------------------------")

        } else {
            println("Erro ao cadastrar o cliente. Verifique os dados fornecidos.")
        }
        retornar.mostrarMenu()
    }


    fun consultarClientes() {
        println("Clientes cadastrados:")
        listaClientes.forEach { cliente ->
            println("CPF: ${cliente.cpf} | Nome: ${cliente.nome} | Idade: ${cliente.idade}")
            println("-----------------------------------------")
        }

        retornar.mostrarMenu()
    }

    fun removerCadastro() {

        println("Informe o CPF do cliente que deseja remover: ")
        val cpf = readLine()

        if (cpf != null) {
            val clienteRemover = listaClientes.find { it.cpf == cpf }

            if (clienteRemover != null) {
                listaClientes.remove(clienteRemover)
                println("CPF: ${clienteRemover.cpf} removido com sucesso!")
            } else {
                println("CPF não encontrado")
            }

        } else {
            println("CPF inválido")
        }

        retornar.mostrarMenu()
    }

    fun atualizarCadastro() {

        println("Informe o CPF do cliente que deseja atualizar: ")
        val cpf = readLine()

        if (cpf != null) {
            val clienteAtualizar = listaClientes.find { it.cpf == cpf }
            if (clienteAtualizar != null) {
                println("Informe o nome do cliente: ")
                val novoNome = readLine()
                println("Informe a idade do cliente: ")
                val novaIdade = readLine()

                if (novoNome != null && novaIdade != null) {

                    clienteAtualizar.nome = novoNome
                    clienteAtualizar.idade = novaIdade

                    println("Cadastro do cliente com CPF $cpf atualizado com sucesso.")

                } else {
                    println("Cliente não encontrado")
                }
            } else {
                println("CPF inválido")
            }

        }

        retornar.mostrarMenu()
    }
}
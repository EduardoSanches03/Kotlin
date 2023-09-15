package Controllers

import Config.Config
import Models.Cliente
import Models.Venda
import Views.MenuVenda
import Views.clienteController
import Views.produtoController

class VendaController {

    val teste = produtoController.listaProtudos[0]
    val teste2 = clienteController.listaClientes[0]

    val listaVendas = mutableListOf<Venda>()
    val gerarId = Config();
    val retornar = MenuVenda()

    init {
        listaVendas.add(Venda("TESTE", teste, teste2, 5000.0))
    }

    fun realizarVenda(){
        println("Informe o cpf do cliente: ")
        val cpf = readLine()

        val cpfCliente = clienteController.listaClientes.find { it.cpf == cpf }
        if (cpfCliente != null){
            println("Informe o código do produto comprado: ")
            val codigo = readLine()

            val idProduto = produtoController.listaProtudos.find { it.id == codigo }

            if (idProduto != null){
                println("Informe a quantidade de produtos: ")
                val quantidadeStg = readLine()

                if (quantidadeStg != null) {
                    val quantidade = quantidadeStg.toInt()

                    val idVenda = gerarId.gerarID()
                    val valor = idProduto.valor * quantidade

                    val venda = Venda(idVenda, idProduto, cpfCliente, valor)
                    listaVendas.add(venda)

                    println("Venda Realizada com sucesso!!")

                }else{
                    println("Quantidade inválida")
                }
            }else{
              println("Produto Inválido")
            }
        }else{
            println("Cpf inválido")
        }

        retornar.mostrarMenu()

    }

    fun consultarVendas(){
        println("Lista de Vendas: ")
        listaVendas.forEach { venda ->
            println("Registro da Venda: ${venda.id} Cliente: ${venda.cliente.nome} ${venda.cliente.cpf} Produto: ${venda.produto.nome} Valor da Venda: ${venda.valor}")
            println("---------------------------------------------------------------------")
        }
        retornar.mostrarMenu()
    }

    fun removerVenda(){
        println("Informe o registro da venda para remover: ")
        val registro = readLine()

        val idVenda = listaVendas.find { it.id == registro }

        if (idVenda != null){
            listaVendas.remove(idVenda)

            retornar.mostrarMenu()
        }else
            println("Código inválido")

        retornar.mostrarMenu()
    }

}
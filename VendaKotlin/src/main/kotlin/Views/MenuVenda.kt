package Views

import Controllers.VendaController

val VendaController = VendaController()
val retornarInicio = menuInicial()

class MenuVenda {
    fun mostrarMenu(){
        println("Selecione a opção desejada: ")
        println("1 - Realizar venda")
        println("2 - Consultar Vendas")
        println("3 - Remover Venda" )
        println("0 - Voltar")
        val opção = readLine()

        when(opção){
            "1" -> VendaController.realizarVenda()
            "2" -> VendaController.consultarVendas()
            "3" -> VendaController.removerVenda()
            "0" -> retornarInicio.menuInicial()
        }
    }

}
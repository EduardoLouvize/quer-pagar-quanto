package br.edu.infnet.querPagar.Dao

import br.edu.infnet.querPagar.model.Produto

class ProdutosDao {

    fun adiciona(produto: Produto){
        listaProdutos.add(produto)
    }

    fun listarTodos(): List<Produto>{
        return listaProdutos.toList()
    }

    companion object {
        private var listaProdutos = mutableListOf<Produto>()
    }
}
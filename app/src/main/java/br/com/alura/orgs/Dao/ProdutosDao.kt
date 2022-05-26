package br.com.alura.orgs.Dao

import br.com.alura.orgs.model.Produto

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
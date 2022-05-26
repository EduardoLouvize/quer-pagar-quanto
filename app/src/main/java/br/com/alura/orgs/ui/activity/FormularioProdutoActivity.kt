package br.com.alura.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import br.com.alura.orgs.Dao.ProdutosDao
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        btnSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()
            val campoDescricao = findViewById<EditText>(R.id.descricao)
            val descricao = campoDescricao.text.toString()
            val campoValor = findViewById<EditText>(R.id.valor)
            val valorString = campoValor.text.toString()
            val valor = if (valorString.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorString)
            }

            val produtoNovo = Produto(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            Log.i("FormularioProdutoActiv", "onCreate: $produtoNovo")
            val dao = ProdutosDao()
            dao.adiciona(produtoNovo)
            Log.i("FormularioProdutoActiv", "onCreate: ${dao.listarTodos()}")
            finish()

        }
    }


}
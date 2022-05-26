package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.Dao.ProdutosDao
import br.com.alura.orgs.R
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main){

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        val reciclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dao = ProdutosDao()
        Log.i("MainActivity", "onResume: ${dao.listarTodos()}")
        reciclerView.adapter = ListaProdutosAdapter(context = this, listaProdutos = dao.listarTodos())
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }

}
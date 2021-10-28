package com.example.apimarvel_2021_2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apimarvel_2021_2.R
import com.example.apimarvel_2021_2.Sessao
import com.example.apimarvel_2021_2.model.Hero
import com.example.apimarvel_2021_2.model.Thumbnail
import com.example.apimarvel_2021_2.ui.adapters.HeroAdapter

class ListagemDeHeroisFragment : Fragment() {

    lateinit var recycleViewListagemDeHerois: RecyclerView
    lateinit var heroAdapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        heroAdapter = HeroAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_listagem_de_herois, container, false)

        recycleViewListagemDeHerois = view.findViewById(R.id.rv_listagem_de_herois)
        recycleViewListagemDeHerois.layoutManager = LinearLayoutManager(context)
        recycleViewListagemDeHerois.setHasFixedSize(true)
        recycleViewListagemDeHerois.adapter = heroAdapter

        if(Sessao.listaDeHerois != null){
            heroAdapter.setListaDeHerois(Sessao.listaDeHerois!!)
        }
        else{
            Toast.makeText(requireContext(),"Não foi possível exibir lista de herois.",Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
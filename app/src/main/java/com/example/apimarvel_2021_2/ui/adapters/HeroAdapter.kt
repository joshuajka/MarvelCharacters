package com.example.apimarvel_2021_2.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apimarvel_2021_2.R
import com.example.apimarvel_2021_2.model.Hero

class HeroAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listaDeHerois: List<Hero> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  HeroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.hero_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is HeroViewHolder ->{
                holder.bind(listaDeHerois[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return listaDeHerois.size
    }

    fun setListaDeHerois(listaDeHerois: List<Hero>){
        this.listaDeHerois = listaDeHerois
    }

    class HeroViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val fotoHeroi = itemView.findViewById<ImageView>(R.id.iv_hero_foto)
        val nomeHeroi = itemView.findViewById<TextView>(R.id.tv_heroi_nome)
        val dataHeroi = itemView.findViewById<TextView>(R.id.tv_heroi_data)
        val descricaoHeroi = itemView.findViewById<TextView>(R.id.tv_heroi_descricao)

        fun bind(hero: Hero){
            fotoHeroi.load(hero.imagemDoHeroi.getURL())
            nomeHeroi.text = hero.nome
            dataHeroi.text = hero.dataDeModicacao
            descricaoHeroi.text = hero.descricao
        }
    }

}
package com.example.apimarvel_2021_2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.navigation.fragment.findNavController
import com.example.apimarvel_2021_2.R
import com.example.apimarvel_2021_2.Sessao
import com.example.apimarvel_2021_2.model.Hero
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.gson.GsonBuilder
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class LoginFragment : Fragment() {

    lateinit var botaoEntrar: Button
    lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        botaoEntrar = view.findViewById(R.id.bt_entrar)
        progressBar = view.findViewById(R.id.pb_progress_bar)

        botaoEntrar.setOnClickListener{
            progressBar.visibility = View.VISIBLE
            //findNavController().navigate(R.id.listagemDeHeroisFragment)
            val URLBase = "https://gateway.marvel.com/v1/public/characters?ts=1&apikey=b435b45e78d5e0250c8b91297f19afa1&hash=fd57cc6af1dd9691341efbd69bc73ee3"
            val request = Request.Builder().url(URLBase).build()
            val client = OkHttpClient()

            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    MaterialAlertDialogBuilder(requireContext())
                        .setTitle("Erro!")
                        .setMessage("Não Foi possível obter a lista de herois. ")
                        .setNegativeButton("Entendi",null)
                        .show()
                }

                override fun onResponse(call: Call, response: Response) {
                    val json = response.body!!.string()
                    var jsonObject = JSONObject(json)
                    jsonObject = jsonObject.getJSONObject("data")
                    val jsonArray = jsonObject.getJSONArray("results")

                    val gson = GsonBuilder().create()
                    Sessao.listaDeHerois = gson.fromJson(jsonArray.toString(),Array<Hero>::class.java).toList()


                    requireActivity().runOnUiThread {
                        findNavController().navigate(R.id.listagemDeHeroisFragment)
                    }

                }
            })

        }

        return view
    }
}
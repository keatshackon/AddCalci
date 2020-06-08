package com.keatssalazar.addcalci.Screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.keatssalazar.addcalci.R
import com.keatssalazar.addcalci.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    private lateinit var binding:FragmentGameBinding
    private lateinit var viewModel:GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View ?{
        // Inflate the layout for this fragment

        Log.i("keats","main")
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_game,container,false)



        binding.submit.setOnClickListener {
            if((binding.edt1.text.toString())!="" && (binding.edt2.text.toString())!=""){

                val a:Long=binding.edt1.text.toString().toLong()
                val b:Long=binding.edt2.text.toString().toLong()

                viewModel.calculate(a,b)
            }
            else{
                Toast.makeText(context,"Please Fill All The Field",Toast.LENGTH_LONG).show()
            }

        }
        viewModel.result.observe(viewLifecycleOwner, Observer {
            binding.resulttext.text=it.toString()
        })
        return binding.root

    }

}

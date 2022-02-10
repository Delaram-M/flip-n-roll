package com.example.flipnroll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flipnroll.databinding.FragmentCoinBinding
import kotlin.random.Random
import kotlin.random.nextInt

const val HEAD = "HEAD"
const val TAIL = "TAIL"

class CoinFragment : Fragment() {

    private var _binding: FragmentCoinBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var coin: Coin

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCoinBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coin = Coin()
        binding.flipButton.setOnClickListener { flip() }
    }

    private fun flip(){
        coin.flip()
        val image = when(coin.side){
            HEAD -> R.drawable.head
            else -> R.drawable.tail
        }
        binding.coinImage.setImageResource(image)
        binding.coinImage.contentDescription = getString(R.string.coin_description, coin.side).lowercase()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



class Coin{
    var side: String = TAIL

    fun flip(){
        when(Random.nextInt(0..1)){
            0 -> side = TAIL
            1 -> side = HEAD
        }
    }

}
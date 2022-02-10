package com.example.flipnroll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flipnroll.databinding.FragmentDiceBinding
import kotlin.random.Random
import kotlin.random.nextInt

class DiceFragment : Fragment() {

    private var _binding: FragmentDiceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var dice: Dice

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDiceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dice = Dice()
        binding.rollButton.setOnClickListener { roll() }
    }


    private fun roll(){
        dice.roll()
        val image = when(dice.side){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.diceImage.setImageResource(image)
        binding.diceImage.contentDescription = getString(R.string.dice_description, dice.side).lowercase()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


class Dice {
    var side = 1

    fun roll(){
        side = Random.nextInt(1..6)
    }

}
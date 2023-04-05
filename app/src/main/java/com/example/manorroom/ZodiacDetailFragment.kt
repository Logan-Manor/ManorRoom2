package com.example.manorroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.manorroom.databinding.FragmentZodiacDetailBinding
import java.util.*

class ZodiacDetailFragment : Fragment() {
    private var _binding: FragmentZodiacDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private lateinit var zodiac: Zodiac

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        zodiac = Zodiac(
            id = UUID.randomUUID(),
            name = "",
            description = "",
            symbol = "",
            month = ""
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            FragmentZodiacDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            zodiacName.doOnTextChanged { text ->
                zodiac = zodiac.copy(name = text.toString())
            }

            zodiacDescription.doOnTextChanged { text ->
                    zodiac = zodiac.copy(description = text.toString())
            }

            zodiacSymbol.doOnTextChanged { text ->
                zodiac = zodiac.copy(symbol = text.toString())
            }

            zodiacMonth.doOnTextChanged { text ->
                zodiac = zodiac.copy(month = text.toString())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
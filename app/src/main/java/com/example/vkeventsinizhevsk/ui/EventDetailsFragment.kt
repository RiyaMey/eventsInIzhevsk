package com.example.vkeventsinizhevsk.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vkeventsinizhevsk.R
import com.example.vkeventsinizhevsk.databinding.FragmentEventDetailsBinding
import com.example.vkeventsinizhevsk.model.Event

/**
 * A simple [Fragment] subclass.
 * Use the [EventDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventDetailsFragment : Fragment() {
    private var _binding: FragmentEventDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var eventItem: Event
    private val eventTitleKey = "event_title"
    private val eventDateKey = "event_date"
    private val eventImgKey = "event_img"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            eventItem = Event(
                it.get(eventImgKey) as Int,
                it.get(eventTitleKey) as Int,
                it.get(eventDateKey) as Int
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentEventDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: заменить данные для примера на параметры от главного экрана
        binding.eventDetailTitle.text = context?.resources?.getString(eventItem.titleResId).toString()
        binding.eventDetailDate.text = context?.resources?.getString(eventItem.dateTimeResId).toString()
        binding.eventDetailDescription.text = context?.resources?.getString(R.string.description_rising_Sun).toString()
        binding.eventDetailImg.setImageResource(eventItem.avatarResId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
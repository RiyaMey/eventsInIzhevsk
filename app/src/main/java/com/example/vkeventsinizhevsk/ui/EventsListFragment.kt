package com.example.vkeventsinizhevsk.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.vkeventsinizhevsk.adapter.EventItemAdapter
import com.google.android.material.datepicker.MaterialDatePicker
import com.example.vkeventsinizhevsk.databinding.FragmentEventsListBinding

//  TODO: данный передавать по действию или все держать в общей модели

class EventsListFragment() : Fragment() {
    private  var _binding: FragmentEventsListBinding? = null
    private  val binding get() = _binding!!
    private val viewModel: EventListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentEventsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.getDataSet()

        viewModel.dataSet.observe(viewLifecycleOwner,
            { newSet ->
                val recycleView = binding.eventsRecycleView
//                recycleView.adapter = EventItemAdapter(this, newSet)
                recycleView.setHasFixedSize(true) // TODO: возможно придется изменить
            })

        viewModel.startDate.observe(viewLifecycleOwner,
            { newStartDate ->
                binding.startTime.text = newStartDate
            })

        viewModel.endDate.observe(viewLifecycleOwner,
            { newEndDate ->
                binding.endTime.text = newEndDate
            })
        // TODO: удалить, когда добавлю dataBinding
        binding.startTime.setOnClickListener {
            chooseStartDate()
        }

        // TODO: удалить, когда добавлю dataBinding
        binding.endTime.setOnClickListener {
            chooseEndDate()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun chooseStartDate() {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Выберите начальную дату")
                .build()
        activity?.let { it -> datePicker.show(it.supportFragmentManager, "tag") }

        datePicker.addOnPositiveButtonClickListener {
//            Log.d("tag", "chooseStartDate ${datePicker.selection}")
            viewModel.setNewStartDate(datePicker.selection.toString())
        }
    }

    private fun chooseEndDate() {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Выберите конечную дату")
                .build()
        activity?.let { it1 -> datePicker.show(it1.supportFragmentManager, "tag") }

        datePicker.addOnPositiveButtonClickListener {
//            Log.d("tag", "chooseEndDate ${datePicker.selection}")
            viewModel.setNewEndDate(datePicker.selection.toString())
        }
    }
}
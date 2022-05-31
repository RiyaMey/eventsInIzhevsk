package com.example.vkeventsinizhevsk.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.vkeventsinizhevsk.R
import com.example.vkeventsinizhevsk.model.Event
import com.example.vkeventsinizhevsk.ui.EventsListFragment
import com.example.vkeventsinizhevsk.ui.EventsListFragmentDirections

/**
 * Adapter for the RecyclerView in EventListFragment. Displays data object.
 */
class EventItemAdapter(
    private val context: EventsListFragment,
    private val dataset: List<Event>
): RecyclerView.Adapter<EventItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val imgView: ImageView = view.findViewById(R.id.eventImage)
        val titleView: TextView = view.findViewById(R.id.event_title_view)
        val dateView: TextView = view.findViewById(R.id.event_date_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.event_list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.imgView.setImageResource(item.avatarResId)
        holder.titleView.text = context.resources.getString(item.titleResId)
        holder.dateView.text = context.resources.getString(item.dateTimeResId)
        holder.itemView.setOnClickListener{
            // TODO:  перед переходом на дет стр кешировать данные
            val action = EventsListFragmentDirections.actionEventsListFragmentToEventDetailsFragment(
                item.titleResId, item.dateTimeResId, item.avatarResId)
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = dataset.size
}
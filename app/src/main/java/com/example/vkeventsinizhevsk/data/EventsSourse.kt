package com.example.vkeventsinizhevsk.data

import com.example.vkeventsinizhevsk.R
import com.example.vkeventsinizhevsk.model.Event

// TODO: get events from vk api
class EventsSourse {
    /**
     * Return a list of Events object. Examle for creation recycle view
     */
    fun loadEvents(): List<Event> {
        return listOf<Event>(
            Event(R.drawable.berns_of_venus, R.string.birth_of_Venus, R.string.date_birth_of_Venus),
            Event(R.drawable.christ_carrying_the_cross, R.string.christ_carrying_the_cross, R.string.date_christ_carrying_the_cross),
            Event(R.drawable.creation_of_adam, R.string.creation_of_Adam, R.string.date_creation_of_Adam),
            Event(R.drawable.gioconda, R.string.gioconda, R.string.date_gioconda),
            Event(R.drawable.girl_with_a_pearl_earring, R.string.girl_with_a_pearl_earring, R.string.date_girl_with_a_pearl_earring),
            Event(R.drawable.meninas, R.string.meninas, R.string.date_meninas),
            Event(R.drawable.rising_sun, R.string.rising_Sun, R.string.date_rising_Sun),
            Event(R.drawable.secret_supper, R.string.secret_supper, R.string.date_secret_supper),
            Event(R.drawable.sistine_madonna, R.string.Sistine_Madonna, R.string.date_Sistine_Madonna),
            Event(R.drawable.the_garden_of_earthly_delights, R.string.the_garden_of_earthly_delights, R.string.date_the_garden_of_earthly_delights),
        )
    }
}
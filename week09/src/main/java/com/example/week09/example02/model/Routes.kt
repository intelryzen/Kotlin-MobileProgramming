package com.example.week09.example02.model

sealed class Routes(val route: String, val isRoot: Boolean = true) {
    object Home : Routes("Home")
    object Contacts : Routes("Contacts")
    object Favorites : Routes("Favorites")
    object AddContacts : Routes("AddContacts", isRoot = false)

    companion object {
        fun getRoute(route: String): Routes {
            return when (route) {
                Home.route -> Home
                Contacts.route -> Contacts
                Favorites.route -> Favorites
                AddContacts.route -> AddContacts
                else -> Home
            }
        }
    }
}
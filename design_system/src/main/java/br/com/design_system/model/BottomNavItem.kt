package br.com.design_system.model

import androidx.annotation.DrawableRes

interface BottomNavItem {
    val route: String
    @get:DrawableRes val icon: Int
}
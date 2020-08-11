package com.exomind.albums.presentation.coreview

import androidx.navigation.NavDirections
import androidx.navigation.Navigator


sealed class NavDirectionWrapper
data class SimpleNav(val navDirections: NavDirections) : NavDirectionWrapper()
data class NavWithExtras(val navDirections: NavDirections, val extras: Navigator.Extras) : NavDirectionWrapper()
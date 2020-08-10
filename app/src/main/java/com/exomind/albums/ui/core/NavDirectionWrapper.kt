package com.transdev.mobime.presentation.coreview

import android.os.Bundle
import androidx.navigation.NavDirections
import androidx.navigation.Navigator


sealed class NavDirectionWrapper
data class SimpleNav(val navDirections: NavDirections) : NavDirectionWrapper()
data class NavWithExtras(val navDirections: NavDirections, val extras: Navigator.Extras) : NavDirectionWrapper()

sealed class GraphDirectionWrapper(open val graphId: Int)
data class GraphNav(override val graphId: Int) : GraphDirectionWrapper(graphId)
data class GraphNavWithExtras(override val graphId: Int, val args: Bundle) : GraphDirectionWrapper(graphId)
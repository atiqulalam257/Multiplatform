package com.atiq.mp.ui.scene.main

import com.atiq.mp.core.ViewModel
import com.atiq.mp.ui.tab.TabItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel {
    val tabItems = MutableStateFlow(
        listOf(
            TabItem.MoviesTab(),
            TabItem.TvShowsTab(),
            TabItem.SearchTab(),
            TabItem.AccountTab()
        )
    ).asStateFlow()
}

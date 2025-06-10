package com.atiq.mp.ui.tab

import multiplateform.composeapp.generated.resources.Res
import multiplateform.composeapp.generated.resources.ic_tabbar_movie
import multiplateform.composeapp.generated.resources.ic_tabbar_profile
import multiplateform.composeapp.generated.resources.ic_tabbar_search
import multiplateform.composeapp.generated.resources.ic_tabbar_tv_svg
import multiplateform.composeapp.generated.resources.tab_movies
import multiplateform.composeapp.generated.resources.tab_profile
import multiplateform.composeapp.generated.resources.tab_search
import multiplateform.composeapp.generated.resources.tab_tv
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

sealed class TabItem(
    val title: StringResource,
    val icon: DrawableResource,
) {

    val key: String = this::class.simpleName!!

    class MoviesTab : TabItem(
        Res.string.tab_movies,
        Res.drawable.ic_tabbar_movie,
    )

    class TvShowsTab : TabItem(
        Res.string.tab_tv,
        Res.drawable.ic_tabbar_tv_svg,
    )

    class SearchTab : TabItem(
        Res.string.tab_search,
        Res.drawable.ic_tabbar_search,
    )

    class AccountTab : TabItem(
        Res.string.tab_profile,
        Res.drawable.ic_tabbar_profile,
    )
}

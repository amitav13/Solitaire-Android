package com.amitavkhandelwal.solitaire

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource

/**
 * Created by amitavk on 08/06/17.
 */
class FoundationPileView(context: Context, val index: Int) : ImageView(context) {
    init {
        imageResource = emptyPileDrawable
        setOnClickListener {
            GamePresenter.onFoundationTap(index)
        }
    }

    fun update() {
        val cards = GameModel.foundationPiles[index].cards
        imageResource = if (cards.size > 0) getResIdForCard(cards.last()) else emptyPileDrawable
    }
}

/**
 * This pulls the [WASTEPILEVIEW_FACTORY] from [WastePileView] into a single line. Too concise? Probably.
 */
fun ViewManager.foundationPileView(index: Int, init: FoundationPileView.() -> Unit = {})
        = ankoView({ FoundationPileView(it, index) }, 0, init)
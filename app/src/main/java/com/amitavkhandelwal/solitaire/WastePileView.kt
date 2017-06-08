package com.amitavkhandelwal.solitaire

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource

/**
 * Created by amitavk on 08/06/17.
 */
class WastePileView(context: Context) : ImageView(context) {
    init {
        imageResource = emptyPileDrawable
        setOnClickListener {
            GamePresenter.onWasteTap()
        }
    }

    fun update() {
        val cards = GameModel.wastePile
        imageResource = if (cards.size > 0) getResIdForCard(cards.last()) else emptyPileDrawable
    }
}

val WASTEPILEVIEW_FACTORY = { ctx : Context -> WastePileView(ctx) }
fun ViewManager.wastePileView(init: WastePileView.() -> Unit = {}) = ankoView(WASTEPILEVIEW_FACTORY, 0, init)
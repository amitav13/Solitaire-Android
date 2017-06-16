package com.amitavkhandelwal.solitaire

import android.content.Context
import android.view.ViewManager
import org.jetbrains.anko._RelativeLayout
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.dip
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.imageView

/**
 * Created by amitavk on 08/06/17.
 */
class TableauPileView(context: Context, val index: Int) : _RelativeLayout(context) {
    init {
        addViews()
    }

    fun update() {
        removeAllViews()
        addViews()
    }

    private fun addViews() {
        val cards = GameModel.tableauPiles[index].cards
        cards.forEachIndexed { i, card ->
            imageView {
                y = (i * dip(22)).toFloat()
                imageResource = if (card.faceUp) getResIdForCard(card) else cardBackDrawable
                setOnClickListener {
                    GamePresenter.onTableauTap(index, i)
                }
            }.lparams(context.cardWidth, context.cardHeight)
        }
    }
}

fun ViewManager.tableauPileView(index: Int, init: TableauPileView.() -> Unit = {})
        = ankoView({ TableauPileView(it, index) }, 0, init)

package org.example.application.domain.repos

import position.Position

interface GameRepo {
    fun getBoard()
    fun getMoves(piece: Position)
}
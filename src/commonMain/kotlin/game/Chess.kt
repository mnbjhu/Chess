package game

import position.Parser
import position.Position

data class Chess(val board: Position = Parser.Companion.ToPosition.fen(Position.INITIAL_POSITION))

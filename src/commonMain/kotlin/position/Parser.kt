package position

/** Provides static methods to transform Position
 * into standard chess notation and vice versa */
class Parser {
    companion object {
        object ToNotation {
            /**
             * Transform board position into Forsyth-Edwards notation
             * @param position State of the board
             */
            fun fen(position: Position): String {
                return TODO();
            }

            /**
             * Transform board position into portable game notation
             * @param position State of the board
             */
            fun pgn(position: Position): String {
                return TODO();
            }
        }

        object ToPosition {
            /**
             * Transform FEN notation into a board Position
             * @param notation FEN notation
             */
            fun fen(notation: String, cb: (String) -> Unit = {}): Position {
                val (ranks, sideToMove, castlingRights, enPassantTargetSquare, halfMoveClock, fullMoveClock) = notation.split(
                    ' '
                )
                val expanded: MutableList<List<String>> = mutableListOf();

                ranks.split('/').forEach { pieces ->
                    var rank = ""
                    pieces.split("").forEach { piece ->
                        val _piece = piece[0]
                        if (_piece.isDigit()) {
                            for (i in 1.._piece.digitToInt()) rank += _piece
                        } else rank += piece
                    }
                    expanded.add(rank.split(""))
                }

                cb(expanded.joinToString());
                val position = Position()
                return position
            }

            /**
             * Transform PGN notation into a board Position
             * @param notation PGN notation
             */
            fun pgn(notation: String): Position {
                return TODO()
            }
        }
    }
}

operator fun <T> List<T>.component6() = this[5];
operator fun <T> List<T>.component7() = this[6];

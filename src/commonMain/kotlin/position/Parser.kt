package position

/** Provides static methods to transform Position
 * into standard chess notation and vice versa */
class Parser {
    companion object {
        object toNotation {
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

        object toPosition {
            /**
             * Transform FEN notation into a board Position
             * @param notation FEN notation
             */
            fun fen(notation: String): Position {
                val (ranks, sideToMove, castlingRights, enPassantTargetSquare, halfMoveClock, fullMoveClock) = notation.split(
                    ' '
                );

                val pieces = ranks.split('/').map {
                    var counter = 0;
                    it.forEachIndexed { index, c ->
                        counter += if ("$c".toRegex().containsMatchIn("[0-9]")) c.code else 1
                    }
                }

                print(notation.split('/'))
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

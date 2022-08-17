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
                return TODO()
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
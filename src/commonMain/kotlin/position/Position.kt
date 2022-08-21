package position

/** Enumeration of piece colors */
enum class PieceColor {
    WHITE,
    BLACK
}

/** Enumeration of pieces mapped to their values */
enum class Piece(i: Int) {
    PAWN(1),
    KNIGHT(3),
    BISHOP(3),
    ROOK(5),
    QUEEN(9),
    KING(Int.MAX_VALUE)
}

class CastlingRight {
    var kingside: Boolean = false
    var queenside: Boolean = false
}

/** The Position class describes the state of the board */
class Position {
    companion object {
        const val INITIAL_POSITION = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
    }

    val castlingRights: List<CastlingRight> = listOf<CastlingRight>(CastlingRight(), CastlingRight())
    var sideToMove: PieceColor = PieceColor.WHITE
    var enPassantTargetSquare: Int = 0
    var halfMoveClock: Int = 0
    var fullMoveClock: Int = 1
    var pieces: Array<Bitboard> = Array(32) {
        Bitboard(
            if (it < 15) PieceColor.WHITE else PieceColor.BLACK,
            if (it % 16 < 8) Piece.PAWN else {
                when (it % 8) {
                    0, 7 -> Piece.ROOK
                    1, 6 -> Piece.KNIGHT
                    2, 5 -> Piece.BISHOP
                    3 -> {
                        if (it < 15) Piece.KING else Piece.QUEEN
                    }

                    4 -> {
                        if (it < 15) Piece.QUEEN else Piece.KING
                    }

                    else -> {
                        Piece.PAWN
                    }
                }
            }
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Position

        if (castlingRights != other.castlingRights) return false
        if (sideToMove != other.sideToMove) return false
        if (!pieces.contentEquals(other.pieces)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = castlingRights.hashCode()
        result = 31 * result + sideToMove.hashCode()
        result = 31 * result + enPassantTargetSquare
        result = 31 * result + halfMoveClock
        result = 31 * result + fullMoveClock
        result = 31 * result + pieces.contentHashCode()
        return result
    }
}


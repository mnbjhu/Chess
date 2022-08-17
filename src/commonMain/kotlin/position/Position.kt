package position

enum class PieceColor {
    WHITE,
    BLACK
}

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

class Position {
    val castlingRights: List<CastlingRight> = listOf<CastlingRight>(CastlingRight(), CastlingRight())
    val sideToMove: PieceColor = PieceColor.WHITE
    val enPassantTargetSquares: MutableList<Int> = mutableListOf()
    val halfMoveClock: Int = 0
    val pieces: Array<Bitboard> = Array(32) {
        Bitboard(
            if (it > 15) PieceColor.WHITE else PieceColor.BLACK,
            when (it % 16 < 8) {
                true -> Piece.PAWN
                false -> Piece.values()[it % 6 + 1]
            }
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Position

        if (castlingRights != other.castlingRights) return false
        if (sideToMove != other.sideToMove) return false
        if (enPassantTargetSquares != other.enPassantTargetSquares) return false
        if (halfMoveClock != other.halfMoveClock) return false
        if (!pieces.contentEquals(other.pieces)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = castlingRights.hashCode()
        result = 31 * result + sideToMove.hashCode()
        result = 31 * result + enPassantTargetSquares.hashCode()
        result = 31 * result + halfMoveClock
        result = 31 * result + pieces.contentHashCode()
        return result
    }
}


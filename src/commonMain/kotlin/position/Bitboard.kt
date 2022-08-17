package position

data class Bitboard(val pieceColor: PieceColor, val piece: Piece) {
    val squares: ByteArray = ByteArray(64)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Bitboard

        if (!squares.contentEquals(other.squares)) return false

        return true
    }

    override fun hashCode(): Int {
        return squares.contentHashCode()
    }
}
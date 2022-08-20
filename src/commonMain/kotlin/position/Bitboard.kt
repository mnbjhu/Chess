package position

data class Bitboard(val pieceColor: PieceColor, val piece: Piece) {
    val squares: ByteArray = ByteArray(64)
    override fun equals(other: Any?) = other is Bitboard && squares.contentEquals(other.squares)
    override fun hashCode(): Int {
        return squares.contentHashCode()
    }
}
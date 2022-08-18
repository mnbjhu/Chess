(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin', 'kotlin-react', 'react-dom/client', 'react', 'kotlin-react-dom', 'kotlin-csstype', 'kotlin-emotion', 'kotlin-react-core'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'), require('kotlin-react'), require('react-dom/client'), require('react'), require('kotlin-react-dom'), require('kotlin-csstype'), require('kotlin-emotion'), require('kotlin-react-core'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'Chess'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'Chess'.");
    }
    if (typeof this['kotlin-react'] === 'undefined') {
      throw new Error("Error loading module 'Chess'. Its dependency 'kotlin-react' was not found. Please, check whether 'kotlin-react' is loaded prior to 'Chess'.");
    }
    if (typeof this['react-dom/client'] === 'undefined') {
      throw new Error("Error loading module 'Chess'. Its dependency 'react-dom/client' was not found. Please, check whether 'react-dom/client' is loaded prior to 'Chess'.");
    }
    if (typeof react === 'undefined') {
      throw new Error("Error loading module 'Chess'. Its dependency 'react' was not found. Please, check whether 'react' is loaded prior to 'Chess'.");
    }
    if (typeof this['kotlin-react-dom'] === 'undefined') {
      throw new Error("Error loading module 'Chess'. Its dependency 'kotlin-react-dom' was not found. Please, check whether 'kotlin-react-dom' is loaded prior to 'Chess'.");
    }
    if (typeof this['kotlin-csstype'] === 'undefined') {
      throw new Error("Error loading module 'Chess'. Its dependency 'kotlin-csstype' was not found. Please, check whether 'kotlin-csstype' is loaded prior to 'Chess'.");
    }
    if (typeof this['kotlin-emotion'] === 'undefined') {
      throw new Error("Error loading module 'Chess'. Its dependency 'kotlin-emotion' was not found. Please, check whether 'kotlin-emotion' is loaded prior to 'Chess'.");
    }
    if (typeof this['kotlin-react-core'] === 'undefined') {
      throw new Error("Error loading module 'Chess'. Its dependency 'kotlin-react-core' was not found. Please, check whether 'kotlin-react-core' is loaded prior to 'Chess'.");
    }
    root.Chess = factory(typeof Chess === 'undefined' ? {} : Chess, kotlin, this['kotlin-react'], this['react-dom/client'], react, this['kotlin-react-dom'], this['kotlin-csstype'], this['kotlin-emotion'], this['kotlin-react-core']);
  }
}(this, function (_, Kotlin, $module$kotlin_react, $module$react_dom_client, $module$react, $module$kotlin_react_dom, $module$kotlin_csstype, $module$kotlin_emotion, $module$kotlin_react_core) {
  'use strict';
  var $$importsForInline$$ = _.$$importsForInline$$ || (_.$$importsForInline$$ = {});
  var throwCCE = Kotlin.throwCCE;
  var contentEquals = Kotlin.arrayEquals;
  var contentHashCode = Kotlin.arrayHashCode;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var split = Kotlin.kotlin.text.split_o64adg$;
  var print = Kotlin.kotlin.io.print_s8jyv4$;
  var NotImplementedError_init = Kotlin.kotlin.NotImplementedError;
  var Enum = Kotlin.kotlin.Enum;
  var throwISE = Kotlin.throwISE;
  var equals = Kotlin.equals;
  var hashCode = Kotlin.hashCode;
  var listOf = Kotlin.kotlin.collections.listOf_i5x0yv$;
  var Array_0 = Array;
  var ensureNotNull = Kotlin.ensureNotNull;
  var Unit = Kotlin.kotlin.Unit;
  var create = $module$kotlin_react.react.create_gax9jq$;
  var createRoot = $module$react_dom_client.createRoot;
  var useState = $module$react.useState;
  var html = $module$kotlin_react_dom.react.dom.html;
  var InputType$text = {button: 'button', checkbox: 'checkbox', color: 'color', date: 'date', datetimeLocal: 'datetime-local', email: 'email', file: 'file', hidden: 'hidden', image: 'image', month: 'month', number: 'number', password: 'password', radio: 'radio', range: 'range', reset: 'reset', search: 'search', submit: 'submit', tel: 'tel', text: 'text', time: 'time', url: 'url', week: 'week'}.text;
  var FC = $module$kotlin_react.react.FC_4y0n3r$;
  var css = $module$kotlin_emotion.$$importsForInline$$['@emotion/css'].css;
  PieceColor.prototype = Object.create(Enum.prototype);
  PieceColor.prototype.constructor = PieceColor;
  Piece.prototype = Object.create(Enum.prototype);
  Piece.prototype.constructor = Piece;
  function Bitboard(pieceColor, piece) {
    this.pieceColor = pieceColor;
    this.piece = piece;
    this.squares = new Int8Array(64);
  }
  Bitboard.prototype.equals = function (other) {
    var tmp$, tmp$_0;
    if (this === other)
      return true;
    if (other == null || !((tmp$ = Kotlin.getKClassFromExpression(this)) != null ? tmp$.equals(Kotlin.getKClassFromExpression(other)) : null))
      return false;
    Kotlin.isType(tmp$_0 = other, Bitboard) ? tmp$_0 : throwCCE();
    if (!contentEquals(this.squares, other.squares))
      return false;
    return true;
  };
  Bitboard.prototype.hashCode = function () {
    return contentHashCode(this.squares);
  };
  Bitboard.$metadata$ = {kind: Kind_CLASS, simpleName: 'Bitboard', interfaces: []};
  Bitboard.prototype.component1 = function () {
    return this.pieceColor;
  };
  Bitboard.prototype.component2 = function () {
    return this.piece;
  };
  Bitboard.prototype.copy_tyi1d1$ = function (pieceColor, piece) {
    return new Bitboard(pieceColor === void 0 ? this.pieceColor : pieceColor, piece === void 0 ? this.piece : piece);
  };
  Bitboard.prototype.toString = function () {
    return 'Bitboard(pieceColor=' + Kotlin.toString(this.pieceColor) + (', piece=' + Kotlin.toString(this.piece)) + ')';
  };
  function Parser$Companion() {
    Parser$Companion_instance = this;
  }
  var Parser$Companion$toNotation_instance = null;
  function Parser$Companion$toPosition() {
    Parser$Companion$toPosition_instance = this;
  }
  Parser$Companion$toPosition.prototype.fen_61zpoe$ = function (notation) {
    var tmp$ = split(notation, Kotlin.charArrayOf(32));
    var ranks = tmp$.get_za3lpa$(0);
    var sideToMove = tmp$.get_za3lpa$(1);
    var castlingRights = tmp$.get_za3lpa$(2);
    var enPassantTargetSquare = tmp$.get_za3lpa$(3);
    var halfMoveClock = tmp$.get_za3lpa$(4), fullMoveClock = component6(tmp$);
    print(split(notation, Kotlin.charArrayOf(47)));
    var position = new Position();
    return sideToMove;
  };
  Parser$Companion$toPosition.prototype.pgn_61zpoe$ = function (notation) {
    throw new NotImplementedError_init();
  };
  Parser$Companion$toPosition.$metadata$ = {kind: Kind_OBJECT, simpleName: 'toPosition', interfaces: []};
  var Parser$Companion$toPosition_instance = null;
  function Parser$Companion$toPosition_getInstance() {
    if (Parser$Companion$toPosition_instance === null) {
      new Parser$Companion$toPosition();
    }
    return Parser$Companion$toPosition_instance;
  }
  var Parser$Companion_instance = null;
  function component6($receiver) {
    return $receiver.get_za3lpa$(5);
  }
  function PieceColor(name, ordinal) {
    Enum.call(this);
    this.name$ = name;
    this.ordinal$ = ordinal;
  }
  function PieceColor_initFields() {
    PieceColor_initFields = function () {
    };
    PieceColor$WHITE_instance = new PieceColor('WHITE', 0);
    PieceColor$BLACK_instance = new PieceColor('BLACK', 1);
  }
  var PieceColor$WHITE_instance;
  function PieceColor$WHITE_getInstance() {
    PieceColor_initFields();
    return PieceColor$WHITE_instance;
  }
  var PieceColor$BLACK_instance;
  function PieceColor$BLACK_getInstance() {
    PieceColor_initFields();
    return PieceColor$BLACK_instance;
  }
  PieceColor.$metadata$ = {kind: Kind_CLASS, simpleName: 'PieceColor', interfaces: [Enum]};
  function PieceColor$values() {
    return [PieceColor$WHITE_getInstance(), PieceColor$BLACK_getInstance()];
  }
  PieceColor.values = PieceColor$values;
  function PieceColor$valueOf(name) {
    switch (name) {
      case 'WHITE':
        return PieceColor$WHITE_getInstance();
      case 'BLACK':
        return PieceColor$BLACK_getInstance();
      default:
        throwISE('No enum constant position.PieceColor.' + name);
    }
  }
  PieceColor.valueOf_61zpoe$ = PieceColor$valueOf;
  function Piece(name, ordinal, i) {
    Enum.call(this);
    this.name$ = name;
    this.ordinal$ = ordinal;
  }
  function Piece_initFields() {
    Piece_initFields = function () {
    };
    Piece$PAWN_instance = new Piece('PAWN', 0, 1);
    Piece$KNIGHT_instance = new Piece('KNIGHT', 1, 3);
    Piece$BISHOP_instance = new Piece('BISHOP', 2, 3);
    Piece$ROOK_instance = new Piece('ROOK', 3, 5);
    Piece$QUEEN_instance = new Piece('QUEEN', 4, 9);
    Piece$KING_instance = new Piece('KING', 5, 2147483647);
  }
  var Piece$PAWN_instance;
  function Piece$PAWN_getInstance() {
    Piece_initFields();
    return Piece$PAWN_instance;
  }
  var Piece$KNIGHT_instance;
  function Piece$KNIGHT_getInstance() {
    Piece_initFields();
    return Piece$KNIGHT_instance;
  }
  var Piece$BISHOP_instance;
  function Piece$BISHOP_getInstance() {
    Piece_initFields();
    return Piece$BISHOP_instance;
  }
  var Piece$ROOK_instance;
  function Piece$ROOK_getInstance() {
    Piece_initFields();
    return Piece$ROOK_instance;
  }
  var Piece$QUEEN_instance;
  function Piece$QUEEN_getInstance() {
    Piece_initFields();
    return Piece$QUEEN_instance;
  }
  var Piece$KING_instance;
  function Piece$KING_getInstance() {
    Piece_initFields();
    return Piece$KING_instance;
  }
  Piece.$metadata$ = {kind: Kind_CLASS, simpleName: 'Piece', interfaces: [Enum]};
  function Piece$values() {
    return [Piece$PAWN_getInstance(), Piece$KNIGHT_getInstance(), Piece$BISHOP_getInstance(), Piece$ROOK_getInstance(), Piece$QUEEN_getInstance(), Piece$KING_getInstance()];
  }
  Piece.values = Piece$values;
  function Piece$valueOf(name) {
    switch (name) {
      case 'PAWN':
        return Piece$PAWN_getInstance();
      case 'KNIGHT':
        return Piece$KNIGHT_getInstance();
      case 'BISHOP':
        return Piece$BISHOP_getInstance();
      case 'ROOK':
        return Piece$ROOK_getInstance();
      case 'QUEEN':
        return Piece$QUEEN_getInstance();
      case 'KING':
        return Piece$KING_getInstance();
      default:
        throwISE('No enum constant position.Piece.' + name);
    }
  }
  Piece.valueOf_61zpoe$ = Piece$valueOf;
  function CastlingRight() {
    this.kingside = false;
    this.queenside = false;
  }
  CastlingRight.$metadata$ = {kind: Kind_CLASS, simpleName: 'CastlingRight', interfaces: []};
  function Position() {
    Position$Companion_getInstance();
    this.castlingRights = listOf([new CastlingRight(), new CastlingRight()]);
    this.sideToMove = PieceColor$WHITE_getInstance();
    this.enPassantTargetSquare = 0;
    this.halfMoveClock = 0;
    this.fullMoveClock = 1;
    var array = Array_0(32);
    var tmp$;
    tmp$ = array.length - 1 | 0;
    for (var i = 0; i <= tmp$; i++) {
      var tmp$_0, tmp$_1;
      tmp$_0 = i < 15 ? PieceColor$WHITE_getInstance() : PieceColor$BLACK_getInstance();
      if ((i % 16 | 0) < 8)
        tmp$_1 = Piece$PAWN_getInstance();
      else {
        switch (i % 8 | 0) {
          case 0:
          case 7:
            tmp$_1 = Piece$ROOK_getInstance();
            break;
          case 1:
          case 6:
            tmp$_1 = Piece$KNIGHT_getInstance();
            break;
          case 2:
          case 5:
            tmp$_1 = Piece$BISHOP_getInstance();
            break;
          case 3:
            tmp$_1 = i < 15 ? Piece$KING_getInstance() : Piece$QUEEN_getInstance();
            break;
          case 4:
            tmp$_1 = i < 15 ? Piece$QUEEN_getInstance() : Piece$KING_getInstance();
            break;
          default:
            tmp$_1 = Piece$PAWN_getInstance();
            break;
        }
      }
      array[i] = new Bitboard(tmp$_0, tmp$_1);
    }
    this.pieces = array;
  }
  function Position$Companion() {
    Position$Companion_instance = this;
    this.INITIAL_POSITION = 'rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1';
  }
  Position$Companion.$metadata$ = {kind: Kind_OBJECT, simpleName: 'Companion', interfaces: []};
  var Position$Companion_instance = null;
  function Position$Companion_getInstance() {
    if (Position$Companion_instance === null) {
      new Position$Companion();
    }
    return Position$Companion_instance;
  }
  Position.prototype.equals = function (other) {
    var tmp$, tmp$_0;
    if (this === other)
      return true;
    if (other == null || !((tmp$ = Kotlin.getKClassFromExpression(this)) != null ? tmp$.equals(Kotlin.getKClassFromExpression(other)) : null))
      return false;
    Kotlin.isType(tmp$_0 = other, Position) ? tmp$_0 : throwCCE();
    if (!equals(this.castlingRights, other.castlingRights))
      return false;
    if (this.sideToMove !== other.sideToMove)
      return false;
    if (!contentEquals(this.pieces, other.pieces))
      return false;
    return true;
  };
  Position.prototype.hashCode = function () {
    var result = hashCode(this.castlingRights);
    result = (31 * result | 0) + this.sideToMove.hashCode() | 0;
    result = (31 * result | 0) + this.enPassantTargetSquare | 0;
    result = (31 * result | 0) + this.halfMoveClock | 0;
    result = (31 * result | 0) + this.fullMoveClock | 0;
    result = (31 * result | 0) + contentHashCode(this.pieces) | 0;
    return result;
  };
  Position.$metadata$ = {kind: Kind_CLASS, simpleName: 'Position', interfaces: []};
  function main$lambda($receiver) {
    $receiver.name = 'Kotlin/JS';
    return Unit;
  }
  function main() {
    var container = document.createElement('div');
    ensureNotNull(document.body).appendChild(container);
    var welcome = create(Welcome, main$lambda);
    createRoot(container).render(welcome);
  }
  function Welcome$lambda$lambda($receiver) {
    var $receiver_0 = {};
    $receiver_0.padding = (5).toString() + 'px';
    $receiver.className = css($receiver_0);
    $receiver.unaryPlus_pdl1vz$(JSON.stringify(Parser$Companion$toPosition_getInstance().fen_61zpoe$(Position$Companion_getInstance().INITIAL_POSITION)));
    return Unit;
  }
  function Welcome$lambda$lambda$lambda(closure$name) {
    return function (event) {
      var $this = closure$name;
      var value = event.target.value;
      $this[1](value);
      return Unit;
    };
  }
  function Welcome$lambda$lambda_0(closure$name) {
    return function ($receiver) {
      var $receiver_0 = {};
      $receiver_0.marginTop = (5).toString() + 'px';
      $receiver_0.marginBottom = (5).toString() + 'px';
      $receiver_0.fontSize = (14).toString() + 'px';
      $receiver.className = css($receiver_0);
      $receiver.type = InputType$text;
      $receiver.value = closure$name[0];
      $receiver.onChange = Welcome$lambda$lambda$lambda(closure$name);
      return Unit;
    };
  }
  function Welcome$lambda($receiver, props) {
    var name = useState(props.name);
    $receiver.invoke_gax9jq$(html.ReactHTML.div, Welcome$lambda$lambda);
    $receiver.invoke_gax9jq$(html.ReactHTML.input, Welcome$lambda$lambda_0(name));
    return Unit;
  }
  var Welcome;
  var package$position = _.position || (_.position = {});
  package$position.Bitboard = Bitboard;
  Object.defineProperty(Parser$Companion.prototype, 'toPosition', {get: Parser$Companion$toPosition_getInstance});
  package$position.component6_2p1efm$ = component6;
  Object.defineProperty(PieceColor, 'WHITE', {get: PieceColor$WHITE_getInstance});
  Object.defineProperty(PieceColor, 'BLACK', {get: PieceColor$BLACK_getInstance});
  package$position.PieceColor = PieceColor;
  Object.defineProperty(Piece, 'PAWN', {get: Piece$PAWN_getInstance});
  Object.defineProperty(Piece, 'KNIGHT', {get: Piece$KNIGHT_getInstance});
  Object.defineProperty(Piece, 'BISHOP', {get: Piece$BISHOP_getInstance});
  Object.defineProperty(Piece, 'ROOK', {get: Piece$ROOK_getInstance});
  Object.defineProperty(Piece, 'QUEEN', {get: Piece$QUEEN_getInstance});
  Object.defineProperty(Piece, 'KING', {get: Piece$KING_getInstance});
  package$position.Piece = Piece;
  package$position.CastlingRight = CastlingRight;
  Object.defineProperty(Position, 'Companion', {get: Position$Companion_getInstance});
  package$position.Position = Position;
  _.main = main;
  $$importsForInline$$['kotlin-emotion'] = $module$kotlin_emotion;
  $$importsForInline$$['kotlin-react-core'] = $module$kotlin_react_core;
  Welcome = FC(Welcome$lambda);
  main();
  return _;
}));

//# sourceMappingURL=Chess.js.map

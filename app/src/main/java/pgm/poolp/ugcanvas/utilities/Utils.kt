package pgm.poolp.ugcanvas.utilities

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object Utils {
    fun getRangeThrowing(posPlayer_: String, posBall_: String): Bomb? {
        val throwingBallGraphLong = 13
        val posPlayer = posPlayer_.split("_".toRegex()).toTypedArray()
        val playeri = posPlayer[0].toInt()
        val playerj = posPlayer[1].toInt()
        val posBall = posBall_.split("_".toRegex()).toTypedArray()
        val balli = posBall[0].toInt()
        val ballj = posBall[1].toInt()
        var distancei = balli - playeri
        if (distancei < 0) distancei = -distancei
        var distancej = ballj - playerj
        if (distancej < 0) distancej = -distancej
        if (distancei < 0 || distancei > throwingBallGraphLong || distancej < 0 || distancej > throwingBallGraphLong) {
            return null
        }
        val rows = arrayOf(arrayOf(Bomb.B, Bomb.B, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O), arrayOf(Bomb.B, Bomb.B, Bomb.B, Bomb.B, Bomb.B, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O), arrayOf(Bomb.B, Bomb.B, Bomb.B, Bomb.B, Bomb.B, Bomb.B, Bomb.B, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O), arrayOf(Bomb.L, Bomb.L, Bomb.L, Bomb.B, Bomb.B, Bomb.B, Bomb.B, Bomb.B, Bomb.B, Bomb.O, Bomb.O, Bomb.O, Bomb.O, Bomb.O), arrayOf(Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.B, Bomb.B, Bomb.B, Bomb.B, Bomb.B, Bomb.O, Bomb.O, Bomb.O, Bomb.O), arrayOf(Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.B, Bomb.B, Bomb.B, Bomb.B, Bomb.O, Bomb.O, Bomb.O), arrayOf(Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.B, Bomb.B, Bomb.B, Bomb.O, Bomb.O, Bomb.O), arrayOf(Bomb.S, Bomb.S, Bomb.S, Bomb.S, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.B, Bomb.B, Bomb.B, Bomb.O, Bomb.O), arrayOf(Bomb.S, Bomb.S, Bomb.S, Bomb.S, Bomb.S, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.B, Bomb.B, Bomb.B, Bomb.O, Bomb.O), arrayOf(Bomb.S, Bomb.S, Bomb.S, Bomb.S, Bomb.S, Bomb.S, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.B, Bomb.B, Bomb.B, Bomb.O), arrayOf(Bomb.Q, Bomb.Q, Bomb.S, Bomb.S, Bomb.S, Bomb.S, Bomb.S, Bomb.L, Bomb.L, Bomb.L, Bomb.B, Bomb.B, Bomb.B, Bomb.O), arrayOf(Bomb.Q, Bomb.Q, Bomb.Q, Bomb.S, Bomb.S, Bomb.S, Bomb.S, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.B, Bomb.B, Bomb.O), arrayOf(Bomb.Q, Bomb.Q, Bomb.Q, Bomb.Q, Bomb.S, Bomb.S, Bomb.S, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.B, Bomb.B, Bomb.B), arrayOf(Bomb.O, Bomb.Q, Bomb.Q, Bomb.Q, Bomb.S, Bomb.S, Bomb.S, Bomb.L, Bomb.L, Bomb.L, Bomb.L, Bomb.B, Bomb.B, Bomb.B))
        return rows[throwingBallGraphLong - distancej][distancei]
    }

    /*
    fun getStartPosition(board: Board, position_: String, player_: WhichPlayer?): String? {
        return when (player_) {
            WhichPlayer.LOCAL -> {
                val positions = position_.split("_".toRegex()).toTypedArray()
                var i = positions[0].toInt()
                val boardWidth = board.boardWithSquares
                i = boardWidth / 2 - 1 + i
                var j = positions[1].toInt()
                j = j - 1
                i.toString() + "_" + j
            }
            WhichPlayer.REMOTE -> {
                val positions = position_.split("_".toRegex()).toTypedArray()
                var i = positions[0].toInt()
                val boardWidth = board.boardWithSquares
                i = boardWidth / 2 - i
                var j = positions[1].toInt()
                val boardHeight = board.boardHeightSquares
                j = boardHeight - j

                //j = j -1;
                i.toString() + "_" + j
            }
            else -> null
        }
    }
    */

    fun getPos2FromPos1(pos1: String, pos2: String): CardinalEnum? {
        val positions1 = pos1.split("_".toRegex()).toTypedArray()
        val i1 = positions1[0].toInt()
        val j1 = positions1[1].toInt()
        val positions2 = pos2.split("_".toRegex()).toTypedArray()
        val i2 = positions2[0].toInt()
        val j2 = positions2[1].toInt()
        if (i1 - 1 == i2 && j1 == j2) {
            return CardinalEnum.NORTH
        } else if (i1 - 1 == i2 && j1 + 1 == j2) {
            return CardinalEnum.NORTH_EAST
        } else if (i1 == i2 && j1 + 1 == j2) {
            return CardinalEnum.EAST
        } else if (i1 + 1 == i2 && j1 + 1 == j2) {
            return CardinalEnum.SOUTH_EAST
        } else if (i1 + 1 == i2 && j1 == j2) {
            return CardinalEnum.SOUTH
        } else if (i1 + 1 == i2 && j1 - 1 == j2) {
            return CardinalEnum.SOUTH_WEST
        } else if (i1 == i2 && j1 - 1 == j2) {
            return CardinalEnum.WEST
        } else if (i1 - 1 == i2 && j1 - 1 == j2) {
            return CardinalEnum.NORTH_WEST
        }
        return null
    }

    fun getOfficialPosFromCardinalPoint(officialPos: String, cardinalEnum: CardinalEnum): String {

        val numberedPos = fromOfficialPosToNumberedPos(officialPos)

        val positions = numberedPos.split("_".toRegex()).toTypedArray()
        var i = positions[0].toInt()
        var j = positions[1].toInt()

        val newNumberedPost = when (cardinalEnum) {
            CardinalEnum.NORTH -> {
                i.toString() + "_" + (--j).toString()
            }
            CardinalEnum.NORTH_EAST -> {
                (++i).toString() + "_" + (--j).toString()
            }
            CardinalEnum.EAST -> {
                (++i).toString() + "_" + j.toString()
            }
            CardinalEnum.SOUTH_EAST -> {
                (++i).toString() + "_" + (++j).toString()
            }
            CardinalEnum.SOUTH -> {
                i.toString() + "_" + (++j).toString()
            }
            CardinalEnum.SOUTH_WEST -> {
                (--i).toString() + "_" + (++j).toString()
            }
            CardinalEnum.WEST -> {
                (--i).toString() + "_" + j.toString()
            }
            CardinalEnum.NORTH_WEST -> {
                (--i).toString() + "_" + (--j).toString()
            }
        }
        return fromNumberedPosToOfficialPos(newNumberedPost)
    }

    fun getPushedAwayPositions(cardinalEnum: CardinalEnum?): Array<CardinalEnum?>? {
        var cardinalEnums: Array<CardinalEnum?>? = null
        when (cardinalEnum) {
            CardinalEnum.NORTH -> {
                cardinalEnums = arrayOfNulls(3)
                cardinalEnums[0] = CardinalEnum.NORTH_WEST
                cardinalEnums[1] = CardinalEnum.NORTH
                cardinalEnums[2] = CardinalEnum.NORTH_EAST
            }
            CardinalEnum.NORTH_EAST -> {
                cardinalEnums = arrayOfNulls(3)
                cardinalEnums[0] = CardinalEnum.NORTH
                cardinalEnums[1] = CardinalEnum.NORTH_EAST
                cardinalEnums[2] = CardinalEnum.EAST
            }
            CardinalEnum.EAST -> {
                cardinalEnums = arrayOfNulls(3)
                cardinalEnums[0] = CardinalEnum.NORTH_EAST
                cardinalEnums[1] = CardinalEnum.EAST
                cardinalEnums[2] = CardinalEnum.SOUTH_EAST
            }
            CardinalEnum.SOUTH_EAST -> {
                cardinalEnums = arrayOfNulls(3)
                cardinalEnums[0] = CardinalEnum.EAST
                cardinalEnums[1] = CardinalEnum.SOUTH_EAST
                cardinalEnums[2] = CardinalEnum.SOUTH
            }
            CardinalEnum.SOUTH -> {
                cardinalEnums = arrayOfNulls(3)
                cardinalEnums[0] = CardinalEnum.SOUTH_WEST
                cardinalEnums[1] = CardinalEnum.SOUTH
                cardinalEnums[2] = CardinalEnum.SOUTH_EAST
            }
            CardinalEnum.SOUTH_WEST -> {
                cardinalEnums = arrayOfNulls(3)
                cardinalEnums[0] = CardinalEnum.WEST
                cardinalEnums[1] = CardinalEnum.SOUTH_WEST
                cardinalEnums[2] = CardinalEnum.SOUTH
            }
            CardinalEnum.WEST -> {
                cardinalEnums = arrayOfNulls(3)
                cardinalEnums[0] = CardinalEnum.NORTH_WEST
                cardinalEnums[1] = CardinalEnum.WEST
                cardinalEnums[2] = CardinalEnum.SOUTH_WEST
            }
            CardinalEnum.NORTH_WEST -> {
                cardinalEnums = arrayOfNulls(3)
                cardinalEnums[0] = CardinalEnum.NORTH
                cardinalEnums[1] = CardinalEnum.NORTH_WEST
                cardinalEnums[2] = CardinalEnum.WEST
            }
            else -> {}
        }
        return cardinalEnums
    }

    /*
    fun switchSidePosition(board: Board, position_: String): String {
        val positions = position_.split("_".toRegex()).toTypedArray()
        var i = positions[0].toInt()
        val boardWidth = board.boardWithSquares
        i = boardWidth - 1 - i
        var j = positions[1].toInt()
        val boardHeight = board.boardHeightSquares
        j = boardHeight - 1 - j
        return i.toString() + "_" + j
    }
    */

    private fun fromCharToInt(number:Char): Int {
        return  when (number) {
            'A' -> 1
            'B' -> 2
            'C' -> 3
            'D' -> 4
            'E' -> 5
            'F' -> 6
            'G' -> 7
            'H' -> 8
            'I' -> 9
            'J' -> 10
            'K' -> 11
            'L' -> 12
            'M' -> 13
            'N' -> 14
            'O' -> 15
            else -> -1
        }
    }

    private fun fromIntToChar(number:Int): Char  {
        return  when (number) {
            1 -> 'A'
            2 -> 'B'
            3 -> 'C'
            4 -> 'D'
            5 -> 'E'
            6 -> 'F'
            7 -> 'G'
            8 -> 'H'
            9 -> 'I'
            10 -> 'J'
            11 -> 'K'
            12 -> 'L'
            13 -> 'M'
            14 -> 'N'
            15 -> 'O'
            else -> 'A'
        }
    }

    fun fromOfficialPosToNumberedPos(officialPos:String): String {

        val xChar = officialPos[0]
        val yNumber = officialPos.subSequence(1, officialPos.length).toString().toInt()

        val intValue = 15 - yNumber + 1

        return fromCharToInt(xChar).toString() + "_" + intValue.toString()
    }

    private fun fromNumberedPosToOfficialPos(realPos:String): String {

        val positions = realPos.split("_".toRegex()).toTypedArray()
        val i = positions[0].toInt()
        val j = 15 - positions[1].toInt() + 1

        return fromIntToChar(i).toString() + j
    }

    private fun fromNumberedPosToInArraysPos(numberedPos:String): String {

        val positions = numberedPos.split("_".toRegex()).toTypedArray()
        val i = positions[0].toInt()
        val j = positions[1].toInt()

        return (j-1).toString() + "_" + (i-1).toString()
    }

    private fun fromInArraysPosToNumberedPos(inArrayPos: String): String {

        val positions = inArrayPos.split("_".toRegex()).toTypedArray()
        val i = positions[0].toInt()
        val j = positions[1].toInt()

        return (j+1).toString() + "_" + (i+1).toString()
    }

    fun fromOfficialPosToInArraysPos(officialPos: String): String
    {
        val numberedPos = fromOfficialPosToNumberedPos(officialPos)
        return fromNumberedPosToInArraysPos(numberedPos)
    }

    fun fromInArraysPosToOfficialPos(inArrayPos: String): String
    {
        val numberedPos = fromInArraysPosToNumberedPos(inArrayPos)
        return fromNumberedPosToOfficialPos(numberedPos)
    }


    fun dice6(): Int {
        //val rand = Random()
        //val min = 1
        //val max = 6
        //return rand.nextInt(max - min + 1) + min
        return (1..6).random()

        //return min + (int)(Math.random() * ((max-min) + 1) );
    }

    /*
    fun isPosOutOfBoard(board: Board, position: String): Boolean {
        val positions = position.split("_".toRegex()).toTypedArray()
        val i = positions[0].toInt()
        val j = positions[1].toInt()
        val boardWidth = board.boardWithSquares
        val boardHeight = board.boardHeightSquares
        return i < 0 || i >= boardWidth || j < 0 || j >= boardHeight
    }
    */

    enum class CardinalEnum {
        NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST
    }

    //private static final String Q = "quick_pass";
    //private static final String S = "short_pass";
    //private static final String L = "long_pass";
    //private static final String B = "long_bomb";
    enum class Bomb {
        Q,  // quick pass
        S,  // short pass
        L,  // long pass
        B,  // long bomb
        O // out
    }

    enum class WhichPlayer {
        LOCAL, REMOTE
    }
}
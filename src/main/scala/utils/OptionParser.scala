package utils

import moving.MoveDirection

object OptionParser{
    def convertData(args: List[String]): List[MoveDirection] = {
        args.map {
            case arg if arg.length > 1 => throw new IllegalArgumentException(s"$arg is too long")
            case "f" => MoveDirection.FORWARD
            case "r" => MoveDirection.RIGHT
            case "b" => MoveDirection.BACKWARD
            case "l" => MoveDirection.LEFT
            case arg if true => throw new IllegalArgumentException(s"$arg is not a legal move specification")
        }
    }
}
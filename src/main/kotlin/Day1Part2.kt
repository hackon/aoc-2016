/**
 * Created by haakon on 07.12.16.
 */
import com.sun.javafx.geom.Vec2d
import java.awt.Point

/**
 * Created by haakon on 07.12.16.
 */


fun main(args: Array<String>) {
  val data = "L3, R1, L4, L1, L2, R4, L3, L3, R2, R3, L5, R1, R3, L4, L1, L2, R2, R1, L4, L4, R2, L5, R3, R2, R1, L1, L2, R2, R2, L1, L1, R2, R1, L3, L5, R4, L3, R3, R3, L5, L190, L4, R4, R51, L4, R5, R5, R2, L1, L3, R1, R4, L3, R1, R3, L5, L4, R2, R5, R2, L1, L5, L1, L1, R78, L3, R2, L3, R5, L2, R2, R4, L1, L4, R1, R185, R3, L4, L1, L1, L3, R4, L4, L1, R5, L5, L1, R5, L1, R2, L5, L2, R4, R3, L2, R3, R1, L3, L5, L4, R3, L2, L4, L5, L4, R1, L1, R5, L2, R4, R2, R3, L1, L1, L4, L3, R4, L3, L5, R2, L5, L1, L1, R2, R3, L5, L3, L2, L1, L4, R4, R4, L2, R3, R1, L2, R1, L2, L2, R3, R3, L1, R4, L5, L3, R4, R4, R1, L2, L5, L3, R1, R4, L2, R5, R4, R2, L5, L3, R4, R1, L1, R5, L3, R1, R5, L2, R1, L5, L2, R2, L2, L3, R3, R3, R1"
      .splitToSequence(",")
      .map(String::trim)
      .map { s -> Pair(s.toCharArray()[0], s.substring(1).toInt()) }
      .toList()
  val directionMap = listOf(Point(1, 0), Point(0, 1), Point(-1, 0), Point(0, -1))
  val points: MutableMap<Point, Int> = mutableMapOf()



  val currentPoint = Point(0, 0)
  var distance = 0
  points.put(Point(currentPoint), distance)
  var index = 0
  val lastIndex = directionMap.size - 1
  var foundFirstIntersection = false
  for (direction in data) {
    when (direction.first) {
      'R' -> when (index) {
        3 -> index = 0
        else -> index += 1
      }
      'L' -> when (index) {
        0 -> index = lastIndex
        else -> index -= 1
      }
    }

    IntRange(1, direction.second).forEach {
      currentPoint.translate(directionMap[index].x, directionMap[index].y)
      if (!foundFirstIntersection && points.contains(currentPoint)) {
        print(currentPoint)
        println("distanse: ${Math.abs(currentPoint.x) + Math.abs(currentPoint.y)}")
        foundFirstIntersection = true
      } else {
        points.put(Point(currentPoint), distance)
      }
    }
  }
  println(Math.abs(distance))
}

import java.io.File
import java.nio.charset.Charset

/**
 * Created by haakon on 16.12.16.
 */

fun readIn(day:String) = File("src/main/resources/$day.txt").readLines(Charset.defaultCharset())
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.Charset


class Compile (
    val path: String

    ) {

    fun fileGet(): MutableList<String> {

        val files = mutableListOf<String>()

        File(path).walk().forEach {
            files.add(it.path)
        }

//        // 1. ProcessBuilderインスタンスを生成する
//        val p = ProcessBuilder("ls", path)
//
//        // 2. プロセスを開始する
//        val process = p.start()
//
//        // 3. 結果を受け取る
//        try {
//            val r = BufferedReader(InputStreamReader(process.inputStream, Charset.defaultCharset()))
//
//            do{
//                val line:String? = r.readLine()
//                if(!line.isNullOrBlank()){
//                    files.add(line.toString())
//                }
//            }while(!line.isNullOrBlank())
//
//        }catch (_: IOException) {}

        return files
    }


}
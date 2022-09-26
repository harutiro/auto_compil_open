// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.pathString

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("") }

    val compile = Compile("/Users/k22120kk/Desktop/classCode/")

    MaterialTheme {
        Column {

            Button(onClick = {
                val files = compile.fileGet()
                files.forEach {
                    text += it.pathString + "\n"
                }
            }) {
                Text("いい感じにファイルを取得する")
            }

            Button(onClick = {
                val files = compile.fileGet()
                files.forEach {
                    if(!Files.isDirectory(it)){

                        val fileName:String = it.fileName.pathString
                        //拡張子の取得
                        val fileNameWithoutExtension = fileName.split(".").lastOrNull()
                        //ファイル名の取得（拡張子抜き）
                        val fileNameWithInExtension = fileName.split(".")[0]

                        if(fileNameWithoutExtension == "zip"){
                            println(files[0].resolve(fileNameWithInExtension))
                            compile.unzipFile(it , files[0].resolve(fileNameWithInExtension))
                        }
                    }
//                    println(it.fileName)
                }

            }) {
                Text("いい感じにファイルを解凍する")
            }

            Text(
                text
            )
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

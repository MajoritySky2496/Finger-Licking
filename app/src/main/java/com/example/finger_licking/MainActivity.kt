package com.example.finger_licking

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.finger_licking.ui.theme.FingerLickingTheme
import com.example.finger_licking.util.getJsonDataFromAsset
import com.example.finger_licking.viewModel.ProductViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File

class MainActivity : ComponentActivity() {
    lateinit var server: MockWebServer
    private val viewModel by viewModel<ProductViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getProduct()
        viewModel.getCategories()
        viewModel.getTags()
        setContent {
            FingerLickingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
     fun initMockWebSerever(){
         server = MockWebServer()
         GlobalScope.launch {

             val response = MockResponse()
                 .setResponseCode(200)
                 .setBody(getJsonDataFromAsset(applicationContext, "Product.json").toString())
             server.enqueue(response)
             server.start(8080)
         }
    }
    fun serverStart(){
        GlobalScope.launch {
            server.start()
        }
    }
    fun serverShutdown(){
        GlobalScope.launch{
            server.shutdown()
        }
    }


     fun getFileAsString(filePath: String): String {
        val file = File(filePath).readText(Charsets.UTF_8)
         Log.d("Product", file)
        return file
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FingerLickingTheme {
        Greeting("Android")
    }
}
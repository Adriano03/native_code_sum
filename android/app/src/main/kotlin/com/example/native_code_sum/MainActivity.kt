package com.example.native_code_sum

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {

    private val CHANNEL = "code.sum/native"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
            call, result ->

            if(call.method == "calcSum") {
                val a = call.argument<Int>("a")?.toInt() ?: 0
                val b = call.argument<Int>("b")?.toInt() ?: 0
                result.success(a + b)
            } else {
                result.notImplemented()
            }
        }
    }
}

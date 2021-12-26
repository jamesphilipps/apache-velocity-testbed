package com.nevermindsoftware.apache.velocity.testbed

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.apache.velocity.VelocityContext
import org.apache.velocity.app.Velocity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.io.StringReader
import java.io.StringWriter
import javax.annotation.PostConstruct


@Controller
class MainController {

    @PostConstruct
    fun postConstruct() {
        Velocity.init();
    }

    @GetMapping("/")
    fun showIndex(): String {
        return "index"
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("/run")
    fun evaluateTemplate(velocityTemplate: String, jsonContext: String): ResponseEntity<String> {
        return try {
            val json = ObjectMapper().readValue<MutableMap<String, Any>>(StringReader(jsonContext))
            val context = VelocityContext(json)

            val result = StringWriter()
            Velocity.evaluate(context, result, "Eval", velocityTemplate)

            ResponseEntity.ok(ObjectMapper().writeValueAsString(mapOf("result" to result.toString())))
        } catch (e: Exception) {
            ResponseEntity("ERROR: $e", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}
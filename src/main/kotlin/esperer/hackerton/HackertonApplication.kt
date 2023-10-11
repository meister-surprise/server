package esperer.hackerton

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HackertonApplication

fun main(args: Array<String>) {
    runApplication<HackertonApplication>(*args)
}

package esperer.hackerton.domain.image.controller

import esperer.hackerton.domain.image.service.ImageService
import esperer.hackerton.domain.image.vo.ImageResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/image")
class ImageController(
    private val imageService: ImageService
) {

    @PostMapping
    fun upload(@RequestPart image: MultipartFile): ResponseEntity<ImageResponse> {
        val result = imageService.upload(image)
        return ResponseEntity.ok(result)
    }
}
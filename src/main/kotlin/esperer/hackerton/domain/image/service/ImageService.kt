package esperer.hackerton.domain.image.service

import esperer.hackerton.domain.image.vo.ImageResponse
import esperer.hackerton.thirdparty.s3.S3Util
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class ImageService(
    private val s3Util: S3Util
) {

    fun upload(image: MultipartFile): ImageResponse {
        val list = listOf("jpg", "jpeg", "png", "gif")

        val splitFile = image.originalFilename.toString().split(".")

        if(splitFile.size < 2)
            throw RuntimeException()

        val extension = splitFile[1].lowercase()

        if(list.none { it == extension })
            throw RuntimeException()

        val imgURL = s3Util.upload(image)

        return ImageResponse(imgURL)
    }

}
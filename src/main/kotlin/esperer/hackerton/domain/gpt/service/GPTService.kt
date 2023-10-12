package esperer.hackerton.domain.gpt.service

import esperer.hackerton.domain.gpt.vo.ChatRequest
import esperer.hackerton.domain.gpt.vo.ChatResponse
import io.github.flashvayne.chatgpt.service.ChatgptService
import org.springframework.stereotype.Service

@Service
class GPTService(
    private val chatgptService: ChatgptService
) {

    companion object {
        const val prompt = """
            Type {StringAAA} as shown in the text below
            Text("{StringAAA}", 20, label)
            Text("{StringAAA}", 20, label)
            Spacer()
            buttons ({}, "Find out more", {color})
            At this time, the color is randomly selected among red, orange, yellow, green, blue, indigo, purple
            Only,
            If I type in {StringAAA}
            On the first line, text ("{StringAAA}", 20, label) outputs the value I entered in this
            In the second line, text ("{StringAAA}", 20, label) outputs the chatgpt's answer to the value I entered
            On the third line, you must print out a spacer()
            In the fourth line, a sentence of "buttons" ({}, "Find out more", {color}) is output,
            and in this case, one of red, orange, yellow, green, blue, indigo, and purple is randomly added to the {color} and output
            
            For example, when I type, "What's an apple?" you're like
            Text ("What's an apple?" 20, label)
            Text ("It's a red fruit," 20, label)
            Spacer()
            buttons ({}, "Find out more", blue)
            You have to answer like this
            At this time, I put the text I entered in the first line and printed out the text ("What's the apple?", 20, label)
            and put the answer to the input in the second line
            I'll print out the spacer() as it is
            In the sentences buttons ({}, "Find out more", blue)
            {color} red, orange, yellow, green, blue, indiI randomly put in one of go and purple and printed it out
            
            Also, you cannot give the same answer to the second linef
            For example, if you print Text ("It's a red fruit," 20, label) once, you can't print Text ("It's a red fruit," 20, label) again
            
            You must provide a variety of answers to the input and not repeat it
            
            What is the correct answer if the user type """
    }

    fun chat(request: ChatRequest): ChatResponse {
        val result = chatgptService.sendMessage(prompt + request.prompt)
        return ChatResponse(result)
    }
}
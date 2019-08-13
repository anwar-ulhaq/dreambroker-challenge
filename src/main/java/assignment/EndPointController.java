package assignment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import utilities.TextUtilitiy;

import org.springframework.http.MediaType;

@Controller
public class EndPointController {
	
	@PostMapping(path = "/analyze",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public EndPointResponse analyze(
			@RequestBody(required = true) EndPointRequest endPointRequest) {
		String text = endPointRequest.getText();
				
		EndPointResponse endPointResponse = new EndPointResponse();
		endPointResponse.setTextLength(TextUtilitiy.CountCharacters(text));
		endPointResponse.setWordCount(TextUtilitiy.CountWords(text));
		endPointResponse.setCharacterCount( TextUtilitiy.CountCharacterOccurance(text));
		
		return endPointResponse;
	}

}

package assignment;

import java.util.ArrayList;
import java.util.Map.Entry;

import lombok.Data;
import responseComponents.TextLength;

@Data
public class EndPointResponse {
	private TextLength textLength;
	private int wordCount;
	private ArrayList<Entry<Character, Integer>> characterCount; 
   
}


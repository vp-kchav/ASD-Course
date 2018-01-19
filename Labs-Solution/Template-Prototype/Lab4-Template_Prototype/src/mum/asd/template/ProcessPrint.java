package mum.asd.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class ProcessPrint extends TemplateClass {
	public static final Logger log = Logger.getGlobal();

	@Override
	public String[] readFile(String fileName) {
		// TODO Auto-generated method stub
		String line = "";
		String[] content = new String[20];
		try (BufferedReader buf = new BufferedReader(new FileReader(fileName))) {
			for (int i = 0; (line = buf.readLine()) != null; i++) {
				content[i] = line.trim();
			}
		} catch (IOException e) {
			log.warning("Main exception: " + e.getMessage());
			List<Throwable> suppressed = Arrays.asList(e.getSuppressed());
			suppressed.forEach(except -> log.warning("Suppressed message: "
					+ except.getMessage()));
		}
		return content;
	}

	@Override
	public void print(String[] reconstruct) {
		// TODO Auto-generated method stub
		for (int i = 5; i<reconstruct.length;i++) {
			System.out.println(reconstruct[i]);
		}
	}

	@Override
	public String[] reconstructLetter(String[] fileContent) {
		// TODO Auto-generated method stub
		switch (fileContent[0]) {
		case "VERTICAL":
			for(int i = 5; i < fileContent.length; i++) {
				if(fileContent[i] == null)
					fileContent[i] = "";
				String reverse = Utils.reverseString(fileContent[i]);
				fileContent[i] += reverse;
				//System.out.println(fileContent[i]);
			}
			break;
		case "NONE":

			break;
		case "HORIZONTAL":
			for(int i = 13; i< 12 + Integer.parseInt(fileContent[2]); i++) {
				fileContent[i] = fileContent[(13 - i) + 12];
			}
			break;
		default:
			break;
		}
		return fileContent;
	}

}

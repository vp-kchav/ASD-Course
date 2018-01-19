package mum.asd.factorymethod;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger extends AbstractTrace implements Trace {

	private static final String FILENAME = "D:\\Kimtey\\logger.log";

	@Override
	public void setDebug(boolean debug) {
		isDebug(debug);
	}

	private void writerTofile(String content) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME,true);
			bw = new BufferedWriter(fw);
			bw.append(content);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public void debug(String message) {
		if(isDebug()) {
			writerTofile("\nDEBUG - " + getCurrentDatetime() + " - " + message);
		}
	}

	@Override
	public void error(String message) {
		writerTofile("\nERROR - " + getCurrentDatetime() + " - " + message);
	}

	public void myLogger() {

	}
}

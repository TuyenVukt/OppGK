/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectOOP;

/**
 *
 * @author Admin
 */

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;

import java.io.IOException;



public class TestReadFile {

	public static void main(String ... args) throws IOException {
		String filePath = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\mavenproject1\\src\\main\\java\\com\\mycompany\\mavenproject1\\GSFile";
		Graph g = new DefaultGraph("g");
		FileSource fs = FileSourceFactory.sourceFor(filePath);
                System.setProperty("org.graphstream.ui", "swing");

		fs.addSink(g);

		try {
			fs.begin(filePath);

			while (fs.nextEvents()) {
				// Optionally some code here ...
			}
		} catch( IOException e) {
			e.printStackTrace();
		}

		try {
			fs.end();
                        g.display();
		} catch( IOException e) {
			e.printStackTrace();
		} finally {
			fs.removeSink(g);
		}



	}
}

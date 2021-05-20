/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.sun.javafx.geom.PickRay;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.stream.file.FileSinkImages;
import org.graphstream.stream.file.FileSinkImages.LayoutPolicy;
import org.graphstream.stream.file.FileSinkImages.OutputPolicy;
import org.graphstream.stream.file.FileSinkImages.OutputType;
import org.graphstream.stream.file.images.Resolution;
import org.graphstream.stream.file.images.Resolutions;
import org.graphstream.ui.view.camera.Camera;

/**
 *
 * @author Admin
 */
public class TestExportIMG {
    public static void main(String[] args) {
        OutputPolicy outputPolicy = OutputPolicy.BY_STEP;
 String prefix = "prefix\\_";
 OutputType type = OutputType.PNG;
 Resolution resolution = Resolutions.HD720;
 
 FileSinkImages fsi = new FileSinkImages( type, resolution );
 
 // Create the source
 
 FileSourceDGS dgs = new FileSourceDGS();
  
 // Optional configuration
 
 fsi.setStyleSheet(
 	"graph { padding: 50px; fill-color: black; }" +
 	"node { fill-color: #3d5689; }" +
 	"edge { fill-color: white; }");
 
 fsi.setOutputPolicy( outputPolicy );
 fsi.setLayoutPolicy( LayoutPolicy.COMPUTED_FULLY_AT_NEW_IMAGE );
 fsi.setHighQuality();
 fsi.addLogo( "path/to/logo", x, y );
  
 // Images production
 
 dgs.addSink( fsi );
  
 fsi.begin(prefix);
 dgs.begin( "path/to/dgs" );
 while( dgs.nextStep() );
 dgs.end();
 fsi.end();
    }
    
}

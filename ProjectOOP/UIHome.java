/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectOOP;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class UIHome {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout());//GridLayout??
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 1000, 1000);
        frame.setPreferredSize(new Dimension(1000, 1000));

        //Components
        JPanel panel2 = new JPanel();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());

        frame.add(panel2);
        frame.add(panel);
        panel2.setBackground(Color.blue);
        panel2.setBounds(0,0,500,1000);

        JButton button1 = new JButton();
        button1.setText("Add node");
        JTextField text_ = new JTextField(10);
        panel2.add(button1);
        panel2.add(text_);


        //create a simple graph
        Graph graph = new SingleGraph("tuto_zoom", false, true);
        graph.addNode("node_1");
        graph.addNode("node_2");
        graph.addEdge("edge_1_2", "node_1","node_2", true);
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }
        graph.setAttribute("ui.stylesheet",
                "url(file:D:\\demoGS\\src\\main\\java\\styling.css)");


        //show the graph in the panel
        Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();
        ViewPanel view_panel =(ViewPanel) viewer.addDefaultView(false);

        Rectangle rec = panel.getBounds();
        view_panel.setBounds(500, 0, 500, 1000);
        view_panel.setPreferredSize(new Dimension(rec.width, rec.height));
        panel.add(view_panel);


        //add a mouse wheel listener to the ViewPanel for zooming the graph
        view_panel.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent mwe) {
                zoomGraph.zoomGraphMouseWheelMoved(mwe, view_panel);
            }
        });


        frame.setVisible(true);

        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = text_.getText();
                if(!text.equals("")){
                    graph.addNode("text");
                    text_.setText("");
                } else System.out.println("Ten khong hop le!!!");
            }
        });
        
       
    }

}


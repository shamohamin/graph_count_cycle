package lotr;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * visual solution for the problem.
 * @author Mohammad Amin Shafiee
 * @author Fatemeh Mahvari
 */

public class GraphView extends Application {

    private Graph graph;
    private int graphCircleRadius = 200;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        createGraph();
        StackPane root = new StackPane();
        Group nodesGroup = new Group();
        root.getChildren().add(nodesGroup);
        Scene scene = new Scene(root,800, 600);
        paintGraph(nodesGroup);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Graph Visualization");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    private void createGraph(){
        graph = new Graph(6);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);
    }

    private void paintGraph(Group group){

        //paint nodes

        for(int i=0; i<graph.getVertices(); i++){
            drawNode(group, i, graph.getVertices());
            drawEdges(i, group);
        }

    }

    private void drawNode(Group group, int vertexNo, int vertices){
        double y =  getY(vertexNo, graphCircleRadius);
        double x =  getX(vertexNo, graphCircleRadius);

        int vertexNoLbl = vertexNo+1;
        Circle vertex = new Circle(x, y, 10);
        Text text = new Text( x, y-20, vertexNoLbl + "");
        text.setStroke(Color.BLACK);
        group.getChildren().addAll(vertex, text);
    }

    private void drawEdges(int vertex, Group group){

        for(int i=0; i<graph.getNeighbors()[vertex].size();i++){
            int neighbor = graph.getNeighbors()[vertex].get(i);

            double startY =  getY(neighbor, graphCircleRadius);
            double startX =  getX(neighbor, graphCircleRadius);
            double endY =  getY(vertex, graphCircleRadius);
            double endX =  getX(vertex, graphCircleRadius);

            Line edge = new Line(startX, startY, endX, endY);

            group.getChildren().add(edge);

        }
    }

    private double getX(int vertexNo, int radius){
        return radius*Math.cos((2*Math.PI/graph.getVertices())*vertexNo);
    }

    private double getY(int vertexNo, int radius){
        return radius*Math.sin((2*Math.PI/graph.getVertices())*vertexNo);
    }




}

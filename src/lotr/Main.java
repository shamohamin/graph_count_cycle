package lotr;

import lotr.utility.ScannerWrapper;

public class Main {

    public static void main(String[] args) {

        int vertices = ScannerWrapper.getInstance().nextInt();
        int edges = ScannerWrapper.getInstance().nextInt();

        Graph graph = new Graph(vertices);

        for(int i=0; i<edges; i++){
            int u = ScannerWrapper.getInstance().nextInt();
            int v = ScannerWrapper.getInstance().nextInt();
            graph.addEdge(u-1, v-1);

        }

        System.out.println(graph.countCycle());

    }
}

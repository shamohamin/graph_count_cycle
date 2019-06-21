package lotr;

public class Main {

    public static void main(String[] args) {

        Graph g1 = new Graph(4);

        g1.addEdge(0,1);
        g1.addEdge(0,2);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(0,3);

        Graph g2 = new Graph(6);

        g2.addEdge(0, 1);
        g2.addEdge(2, 3);
        g2.addEdge(2, 4);
        g2.addEdge(3, 4);


        Graph g3 = new Graph(11);

        g3.addEdge(0, 1);
        g3.addEdge(0, 3);
        g3.addEdge(1, 2);
        g3.addEdge(3, 2);
        g3.addEdge(3, 1);
        g3.addEdge(2, 0);

        g3.addEdge(5, 6);
        g3.addEdge(4, 6);
        g3.addEdge(4, 5);

        g3.addEdge(7, 8);
        g3.addEdge(10, 8);



        System.out.println(g1.countCycle());
        System.out.println(g2.countCycle());
        System.out.println(g3.countCycle());
    }
}

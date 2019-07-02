package lotr;

import lotr.utility.ScannerWrapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mohammad Amin Shafiee
 * @author Fatemeh Mahvari
 */

public class Graph {


    private int vertices;
    private LinkedList<Integer>[]  neighbors;


    public static void main(String[] args) {

        Scanner scannerWrapper = new Scanner(System.in);

        int vertices = scannerWrapper.nextInt();
        int edges = scannerWrapper.nextInt();

        Graph graph = new Graph(vertices);

        for(int i=0; i<edges; i++){
            int u = scannerWrapper.nextInt();
            int v = scannerWrapper.nextInt();
            graph.addEdge(u-1, v-1);

        }

        System.out.println(graph.countCycle());

    }




    public Graph(int vertices){
        this.vertices = vertices;
        neighbors = new LinkedList[vertices];

        for(int i=0; i<neighbors.length; i++){
            neighbors[i] = new LinkedList<>();
        }

    }

    public int getVertices() {
        return vertices;
    }

    //must use a safe approach
    public LinkedList<Integer>[] getNeighbors(){
        return neighbors;
    }

    public void addEdge(int u, int v){
        neighbors[u].add(v);
        neighbors[v].add(u);
    }



    public int countCycle(){
        boolean[] isVisited = new boolean[vertices];
        Arrays.fill(isVisited, false);
        int counter =0;
        for(int i=0; i<vertices; i++){
            if(!isVisited[i]){
                if(isRing(i, i, isVisited)){
                    counter++;
                }
            }
        }
        return  counter;
    }

    private boolean isRing(int start, int vertex, boolean[] isVisited){

        isVisited[vertex]=true;

        if(neighbors[vertex].size()!=2){
            return false;
        }

        int neighbor1 = neighbors[vertex].get(0);
        int neighbor2 = neighbors[vertex].get(1);

        if(isVisited[neighbor1] && isVisited[neighbor2]){
            if(neighbor1==start || neighbor2==start){
                return true;
            }
        }

        if(!isVisited[neighbor1]){
            //return true && isRing(start, neighbor1, isVisited);
            return isRing(start, neighbor1, isVisited);
        }else if(!isVisited[neighbor2]){
            //return true && isRing(start, neighbor2, isVisited);
            return isRing(start, neighbor2, isVisited);
        }

        return false;
    }
}
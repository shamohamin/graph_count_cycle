package lotr;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private int vertices;
    private LinkedList<Integer>[]  neighbors;

    public Graph(int vertices){
        this.vertices = vertices;
        neighbors = new LinkedList[vertices];

        for(int i=0; i<neighbors.length; i++){
            neighbors[i] = new LinkedList<>();
        }

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
        }else if(isVisited[neighbor2]){
            //return true && isRing(start, neighbor2, isVisited);
            return isRing(start, neighbor2, isVisited);
        }

        return false;
    }
}
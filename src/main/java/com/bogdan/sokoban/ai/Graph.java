package com.bogdan.sokoban.ai;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Bogdan
 */
public class Graph {

    private Set<Node> vertices;
    private Node start, finish;
    private HashMap<Node, List<Node>> edges;

    public Graph(File inputFile) {
        vertices = new HashSet<Node>();
        readFromFile(inputFile);
    }

    private void readFromFile(File inputFile) {
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(inputFile));
            String line = bufferedReader.readLine();
            int count = Integer.parseInt(line);
            int index = 0;
            Node[][] nodeMatrix = new Node[count][count];
            while((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (int i=0; i<tokens.length; i++) {
                    int nodeType = Integer.parseInt(tokens[i]);
                    Node node = new Node(nodeType);
                    nodeMatrix[index][i] = node;
                    vertices.add(node);
                    if (nodeType == 1) {
                        start = node;
                    } else if (nodeType == 2) {
                        finish = node;
                    }
                }
            }

        } catch (FileNotFoundException fnfe) {
            System.err.println("Input file not found!");
        } catch (IOException ioe) {
            System.err.println("Error reading input file!");
        }
    }

    public Set<Node> getVertices() {
        return vertices;
    }

    public Node getStart() {
        return start;
    }

    public Node getFinish() {
        return finish;
    }
}

class Node {

    NodeType type;

    public Node(NodeType type) {
        this.type = type;
    }
}

enum NodeType {

    EMPTY (0),
    START (1),
    FINISH (2),
    WALL (3);

    private int code;

    NodeType(int code) {
        this.code = code;
    }

}

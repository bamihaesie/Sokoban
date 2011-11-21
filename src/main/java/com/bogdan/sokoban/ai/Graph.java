package com.bogdan.sokoban.ai;

import java.io.*;
import java.util.*;

/**
 * @author Bogdan
 */
public class Graph {

    private Set<Node> vertices;
    private Node start, finish;
    private HashMap<Node, List<Node>> edges;

    public Graph(File inputFile) {
        vertices = new HashSet<Node>();
        edges = new HashMap<Node, List<Node>>();
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
                    NodeType nodeType =
                            NodeType.getNodeTypeByCode(Integer.parseInt(tokens[i]));
                    Node node = new Node(nodeType, index, i);
                    nodeMatrix[index][i] = node;
                    vertices.add(node);
                    if (nodeType == NodeType.START) {
                        start = node;
                    } else if (nodeType == NodeType.FINISH) {
                        finish = node;
                    }
                }
                index++;
            }
            buildEdgesFromMatrix(nodeMatrix);

        } catch (FileNotFoundException fnfe) {
            System.err.println("Input file not found!");
        } catch (IOException ioe) {
            System.err.println("Error reading input file!");
        }
    }

    private void buildEdgesFromMatrix(Node[][] nodeMatrix) {
        for (int i=0; i<nodeMatrix.length; i++) {
            for (int j=0; j<nodeMatrix.length; j++) {
                List<Node> neighborsList = new ArrayList<Node>();
                if (i > 0) {
                    neighborsList.add(nodeMatrix[i-1][j]);
                }
                if (j > 0) {
                    neighborsList.add(nodeMatrix[i][j-1]);
                }
                if (i < nodeMatrix.length -1) {
                    neighborsList.add(nodeMatrix[i+1][j]);
                }
                if (j < nodeMatrix.length -1) {
                    neighborsList.add(nodeMatrix[i][j+1]);
                }
                edges.put(nodeMatrix[i][j], neighborsList);
            }
        }
    }

    public Set<Node> getVertices() {
        return vertices;
    }

    public List<Node> getNeighbors(Node node) {
        return edges.get(node);
    }

    public Node getStart() {
        return start;
    }

    public Node getFinish() {
        return finish;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph:\n");
        sb.append("Start : " + start + "\n");
        sb.append("Finish : " + finish + "\n");
        sb.append("Vertices:" + "\n");
        for (Node vertex : vertices) {
            sb.append("\t" + vertex + "\n");
        }
        sb.append("Neighbors:\n");
        for (Node vertex : edges.keySet()) {
            sb.append("\t" + vertex + " -> ");
            List<Node> neighbors = edges.get(vertex);
            for (Node neighbor : neighbors) {
                sb.append(neighbor + ", ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

class Node {

    NodeType type;
    Position position;

    public Node(NodeType type) {
        this.type = type;
    }

    public Node(NodeType type, int x, int y) {
        this(type);
        this.position = new Position(x, y);
    }

    public NodeType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Node (" + position.x + "," + position.y + "," + type + ")";
    }
}

class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

enum NodeType {

    EMPTY   (0),
    START   (1),
    FINISH  (2),
    WALL    (3);

    private int code;

    NodeType(int code) {
        this.code = code;
    }

    public static NodeType getNodeTypeByCode(int code) {
        for (NodeType nodeType : values()) {
            if (nodeType.code == code) {
                return nodeType;
            }
        }
        return null;
    }

}

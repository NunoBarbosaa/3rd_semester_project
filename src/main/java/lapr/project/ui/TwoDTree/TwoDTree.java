package lapr.project.ui.TwoDTree;

import lapr.project.model.Ports.Port;

import java.awt.geom.Point2D;
import java.util.Comparator;

public class TwoDTree<T> {

    public TwoDTree(){
       root = null;
    }

        private final Comparator<Port> cmpLat = new Comparator<Port>() {

            @Override
            public int compare(Port p1, Port p2) {
                return Double.compare(p1.getLat(), p2.getLat());
            }
        };

        private final Comparator<Port> cmpLon = new Comparator<Port>() {

            @Override
            public int compare(Port p1, Port p2) {
                return Double.compare(p1.getLon(), p2.getLon());
            }
        };

    /**
     * Verifies if the tree is empty
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

        private Node root;

    public void insert(Port element) {
        root = insert(root,element,true);
    }

        private Node insert(Node currentNode,Port element,boolean divX) {

            if (currentNode == null) {
                return new Node(element);
            }

            if (element.getLat().equals(currentNode.getInfo().getLat()) && element.getLon().equals(currentNode.getInfo().getLon()) ) {
                return currentNode;
            }

            int cmpResult = (divX ? cmpLat : cmpLon).compare(element, currentNode.getInfo());
            if (cmpResult == -1) {
                currentNode.setLeft( insert(currentNode.left, element, !divX) );
            } else {
                currentNode.setRight( insert(currentNode.right, element, !divX) );
            }
            return currentNode;
        }

    public Node findNearestNeighbour(double x, double y) {
        return findNearestNeighbour(root, x, y,root, true);
    }

    private Node findNearestNeighbour(Node fromNode, final double x, final double y,Node closestNode, boolean divX) {
        if (fromNode == null) {
            return null;
        }
        double d = Point2D.distanceSq(fromNode.getInfo().getLat(), fromNode.getInfo().getLon(), x, y);
        double closestDist =  Point2D.distanceSq(closestNode.getInfo().getLat(), closestNode.getInfo().getLon(), x, y);
        if (closestDist > d) {
            closestNode.setObject(fromNode);
        }
                double delta = divX ? x - fromNode.getInfo().getLat() : y - fromNode.getInfo().getLon();
                double delta2 = delta * delta;
                Node node1 = delta < 0 ? fromNode.left : fromNode.right;
                Node node2 = delta < 0 ? fromNode.right : fromNode.left;
                findNearestNeighbour(node1,x,y,closestNode,!divX);
                if (delta2 < closestDist) {
                    findNearestNeighbour(node2,x,y,closestNode, !divX);
                }
                return closestNode;
            }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        int size = 1;
        if (node.left != null) {
            size += size(node.left);
        }
        if (node.right != null) {
            size += size(node.right);
        }
        return size;
    }






    /**
     * Returns a string representation of the tree. Draw the tree horizontally
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRec(root, 0, sb);
        return sb.toString();
    }

    private void toStringRec(Node root, int level, StringBuilder sb) {
        if (root == null) {
            return;
        }
        toStringRec(root.left, level + 1, sb);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                sb.append("|\t");
            }
            sb.append("|-------" + root.getInfo() + "\n");
        } else {
            sb.append(root.getInfo() + "\n");
        }
        toStringRec(root.right, level + 1, sb);
    }



}

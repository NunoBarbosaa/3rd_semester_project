package lapr.project.ui.TwoDTree;

import lapr.project.model.Ports.Port;


public class Node {

        protected Node left;

        protected Node right;

        protected Port info;

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node() {

        }

        public Node(Port info) {
            this.info = info;
            this.right = null;
            this.left = null;
        }

        public Port getInfo() {
            return info;
        }

        public void setObject(Node node){
            this.setRight(node.right);
            this.setLeft(node.left);
            this.setInfo(node.info);
        }

        public void setInfo(Port info) {
            this.info = info;
        }

        @Override
        public String toString() {
            return "Node{" +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

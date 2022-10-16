package lapr.project.ui.TwoDTree;

import lapr.project.model.Ports.Port;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NodeTest {




    @Test
    void TestToString() {
        Node node = new Node();
        node.getInfo();
        node.toString();
    }

    @Test
    void setObjectTest(){
        Port port = new Port("Europe","Cyprus",10136,"Larnaca",34.91666667,33.65);
        Port port1 = new Port ("Europe","Malta",10138,"Marsaxlokk",35.84194,14.54306);
        Node node = new Node(port);
        Node nodeTest = new Node(port1);
        Node nodeLeft = nodeTest.left;
        node.setObject(nodeTest);
        assertEquals(node.left,nodeLeft);
    }

    @Test
    void setObjectTestRight(){
        Port port = new Port("Europe","Cyprus",10136,"Larnaca",34.91666667,33.65);
        Port port1 = new Port ("Europe","Malta",10138,"Marsaxlokk",35.84194,14.54306);
        Node node = new Node(port);
        Node nodeTest = new Node(port1);
        Node nodeRight = nodeTest.right;
        node.setObject(nodeTest);
        assertEquals(node.right,nodeRight);
    }


    @Test
    void setObjectTestInfo(){
        Port port = new Port("Europe","Cyprus",10136,"Larnaca",34.91666667,33.65);
        Port port1 = new Port ("Europe","Malta",10138,"Marsaxlokk",35.84194,14.54306);
        Node node = new Node(port);
        Node nodeTest = new Node(port1);
        Port portInfo = nodeTest.info;
        node.setObject(nodeTest);
        assertEquals(node.info,portInfo);
    }




}

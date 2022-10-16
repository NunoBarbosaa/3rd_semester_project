package lapr.project.ui;

import lapr.project.controller.LoaderController;
import lapr.project.model.Ports.Port;
import lapr.project.ui.TwoDTree.TwoDTree;

import java.io.FileNotFoundException;

public class ImportPortUI {
    public ImportPortUI(){};
    public TwoDTree<Port> loadPortsTwoDTree() throws FileNotFoundException {
        LoaderController ld = new LoaderController();
        TwoDTree<Port> tree = ld.loadPortsTwoDTree("bports.csv");
        return tree;
    }
}

package lapr.project.ui;

import lapr.project.data.AuditTrailController;

import java.io.IOException;

public class AuditTrailUI {


    public void getAuditTrail() throws IOException {
        System.out.println("USER || OPERATION DATE || OPERATION TYPE || CONTAINER NUMBER || CARGOMANIFESTID");
        String result = AuditTrailController.getAuditTrail();
        System.out.println(result);
    }
}

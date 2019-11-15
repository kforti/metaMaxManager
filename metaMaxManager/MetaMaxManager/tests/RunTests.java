package tests;


import mmcorej.CMMCore;
import org.micromanager.metamaxmanager.managers.ManualCalibrationManager;
import org.micromanager.metamaxmanager.model.Model;

public class RunTests {
    public static void main(String[] args) {
        CMMCore core = new CMMCore();
        Model model = new Model(16);

        try {
            core.loadSystemConfiguration("/usr/local/ImageJ/MMConfig_demo.cfg");
            ManualCalibrationManager calibrationManager = new ManualCalibrationManager(model, core);
            calibrationManager.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

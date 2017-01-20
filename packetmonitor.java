
package bandwidthcalculator;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;

public class packetmonitor extends Thread {

    private JpcapCaptor jpcap = null;

    @Override
    public void run() {

        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        for (int i = 0; i < devices.length; i++) {
            System.out.println(i + ": " + devices[i].name + "(" + devices[i].description + ")");
        }

        try {
            jpcap = JpcapCaptor.openDevice(devices[2], 65535, false, 20);
        } catch (Exception e) {
            System.out.println(e);
        }
        jpcap.loopPacket(-1, new TcpPacketCapturer());
    }

    public void stopCapturing() {
        jpcap.breakLoop();
    }
}

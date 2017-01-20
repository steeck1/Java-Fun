
package bandwidthcalculator;

import jpcap.PacketReceiver;
import jpcap.packet.Packet;

public class TcpPacket implements PacketReceiver {

    public static float totalSize = 0;
    public static float totalSizeToBeReturned = 0;
    public static float totalSizeToBeReturned1 = 0;

    @Override
    public void receivePacket(Packet packet) {
        totalSize += packet.len;
    }

    public static float getPacketSizeTillNowAndResetSize() {
        totalSizeToBeReturned = totalSize;
        System.out.println("Total size and reset: " + totalSizeToBeReturned / 1024);
        totalSize = 0;
        return totalSizeToBeReturned / 1024;
    }
}

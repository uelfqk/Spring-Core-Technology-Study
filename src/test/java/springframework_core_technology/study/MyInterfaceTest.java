package springframework_core_technology.study;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MyInterfaceTest {

    @Test
    void test() throws Exception {
        Map<String, ClientPacketStrategy> strategyMap = new HashMap<>();

        strategyMap.put("real", new ClientPacket());
        strategyMap.put("proxy", new ClientPacketProxy());

        MyPacketFactory factory = new MyPacketFactory(strategyMap);

        ClientPacketStrategy strategy = factory.getStrategy("real");
//        ClientPacketStrategy strategy = new ClientPacketProxy();

        PaymentCashService service = new PaymentCashService(strategy);
        service.CallbackProc(0);
        service.setClientPacket(factory.getStrategy("proxy"));
        service.CallbackProc(1);
        service.setClientPacket(factory.getStrategy("real"));
        service.CallbackProc(2);
    }
}

class MyPacketFactory {
    private Map<String, ClientPacketStrategy> strategyMap;

    public MyPacketFactory(Map<String, ClientPacketStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public ClientPacketStrategy getStrategy(String name) {
        return strategyMap.get(name);
    }
}

class MyProtocol {
    @JsonProperty(value = "Code")
    private String code;
    @JsonProperty(value = "Index")
    private String index;
    @JsonProperty(value = "Data")
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

enum MyFunction {
    UC,
    KD,
    DD
}

class MyPacket {
    public static class UC {}
    public static class KD extends MyPacket{
        public Integer id;
        public String name;

        private KD(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public static KD createPacket(Integer id, String name) {
            return new KD(id, name);
        }
    }
    public static class DD extends MyPacket {
        public Integer doorSensorStatus;
        public Integer humanSensorStatus;

        public Integer getDoorSensorStatus() {
            return doorSensorStatus;
        }

        public Integer getHumanSensorStatus() {
            return humanSensorStatus;
        }

        private DD(Integer doorSensorStatus, Integer humanSensorStatus) {
            this.doorSensorStatus = doorSensorStatus;
            this.humanSensorStatus = humanSensorStatus;
        }

        public static MyPacket createPacket(Integer doorSensorStatus, Integer humanSensorStatus) {
            return new DD(doorSensorStatus, humanSensorStatus);
        }
    }
}

interface ClientPacketStrategy extends ClientPacketStrategyV2 {
    void sendPacket(MyFunction function, MyPacket packet) throws Exception;
}

interface ClientPacketStrategyV2 {

}

class ClientPacket implements ClientPacketStrategy {
    private ObjectMapper objectMapper = new ObjectMapper();

    private MyProtocol makeProtocol(MyFunction function, MyPacket packet) throws Exception {
        MyProtocol protocol = new MyProtocol();
        protocol.setCode(function.toString());
        protocol.setIndex("1");
        protocol.setData((packet != null) ? objectMapper.writeValueAsString(packet) : "");
        System.out.println(objectMapper.writeValueAsString(protocol));
        return protocol;
    }

    @Override
    public void sendPacket(MyFunction function, MyPacket packet) throws Exception {
        makeProtocol(function, packet);
        System.out.println("ClientPacket Send!!!");
    }
}

class ClientPacketProxy implements ClientPacketStrategy {
    private ClientPacket clientPacket = new ClientPacket();

    @Override
    public void sendPacket(MyFunction function, MyPacket packet) throws Exception {
        System.out.println("ClientPacket Proxy!!!");
        clientPacket.sendPacket(function, packet);
        System.out.println("Other Library Send Packet!!!");
    }
}

class PaymentCashService {

    private ClientPacketStrategy clientPacket;

    public PaymentCashService(ClientPacketStrategy clientPacket) {
        this.clientPacket = clientPacket;
    }

    public void setClientPacket(ClientPacketStrategy clientPacket) {
        this.clientPacket = clientPacket;
    }

    public void CallbackProc(int kind) throws Exception {
        switch (kind) {
            case 0:
                clientPacket.sendPacket(MyFunction.KD, MyPacket.KD.createPacket(0, "member"));
                break;
            case 1:
                clientPacket.sendPacket(MyFunction.DD, MyPacket.DD.createPacket(0, 1));
                break;
            case 2:
                clientPacket.sendPacket(MyFunction.UC, null);
        }
    }
}


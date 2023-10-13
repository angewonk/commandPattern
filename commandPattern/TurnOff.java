package commandPattern;

public class TurnOff implements Command{
    private Device device;

    public TurnOff(Device device){
        this.device = device;
    }

    public String execute(){
        return device.switchOff();
    }
}
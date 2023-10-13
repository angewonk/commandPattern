package commandPattern;

public class TurnOn implements Command {
    private Device device;

    public TurnOn(Device device){
        this.device = device;
    }

    public String execute(){
        return device.switchOn();
    }
}
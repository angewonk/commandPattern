package commandPattern;

public class IncreaseVolume implements Command {
    private Device device;

    public IncreaseVolume(Device device){
        this.device = device;
    }

    public String execute(){
        return device.increaseVol();
    }
}
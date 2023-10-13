package commandPattern;

public class Device {
    private double temperature = 21.0;
    private String device;

    public Device(String device) {
        this.device = device;
    }

    public String increaseVol(){
        return "\n"+device + "'s volume has been increased";
    }

    public String decreaseVol(){
        return "\n"+device + "'s volume has been decreased";
    }

    public String increaseTemp() {
        if (device.equals("Thermostat")) {
            temperature++;
            return "Temperature for " + device + " has been increased to " + temperature + " °C.";
        }
        return "\n"+device + " temperature has increased";
    }

    public String decreaseTemp() {
        if (device.equals("Thermostat")) {
            temperature--;
            return "Temperature for " + device + " has been decreased to " + temperature + " °C.";
        }
        return "\n"+device + " temperature has decreased";
    }

    public String switchOff(){
        return "\n"+device + " has been turned off";
    }

    public String switchOn(){
        return "\n"+device + " has been turned on";
    }
}

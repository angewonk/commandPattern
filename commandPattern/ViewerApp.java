package commandPattern;

import java.util.*;

public class ViewerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> device = new ArrayList<String>();
        ArrayList<String> addedDevices = new ArrayList<String>();

        System.out.println("\nDevices connected to Central Hub");
        device.add("Light");
        device.add("Thermostat");
        device.add("Music Player");

        boolean addDevicePrompt = false;

        while (true) {
            String devSel;
            String choice = "";
            boolean decision = false;

            if (!addedDevices.isEmpty()) {
                System.out.println("\nDevices you've added:");
                for (String added : addedDevices) {
                    System.out.println(added);
                }
            }

            if (addDevicePrompt) {
                System.out.print("\nDo you want to add another device? (yes/no): ");
                String devChoice = sc.nextLine();

                if (devChoice.equalsIgnoreCase("yes")) {
                    System.out.print("\nEnter the device you want to add: ");
                    String newDev = sc.nextLine();
                    device.add(newDev);
                    addedDevices.add(newDev);
                }
                addDevicePrompt = false;
            }

            if (!decision) {
                System.out.println("\nAvailable devices:");
                for (String dev : device) {
                    System.out.println(dev);
                }

                while (!decision) {
                    System.out.print("\nSelect the device you want to use: ");
                    devSel = sc.nextLine().toLowerCase();
                    

                    boolean isValidDevice = false;

                    for (String dev : device) {
                        if (dev.equalsIgnoreCase(devSel)) {
                            isValidDevice = true;
                            choice = dev;
                            break;
                        }
                    }

                    if (isValidDevice) {
                        decision = true;
                        addDevicePrompt = true;
                    } else {
                        System.out.println("Invalid selection, please choose again");
                    }
                }
            }

            availComms.printAvailableCommands(choice);
            String commandChoice = availComms.getUserCommand(sc);

            System.out.println("\nDevice selected is " + choice + " and command selected is " + commandChoice);

            Device myDevice = new Device(choice);
            CentralHub centralHub = new CentralHub();

                switch (commandChoice) {
                    case "1":
                        TurnOn turnOn = new TurnOn(myDevice);
                        System.out.println(turnOn.execute());
                        if (choice.equals("Light")) {
                            System.out.println("\nBrightness has been turned up");
                        }
                        break;
                    case "2":
                        TurnOff turnOff = new TurnOff(myDevice);
                        System.out.println(turnOff.execute());
                        if (choice.equals("Light")) {
                            System.out.println("\nBrightness has been turned down");
                        }
                        break;
                    case "3":
                        IncreaseTemperature increaseTemperature = new IncreaseTemperature(myDevice);
                        System.out.println(increaseTemperature.execute());
                        break;
                    case "4":
                        DecreaseTemperature decreaseTemperature = new DecreaseTemperature(myDevice);
                        System.out.println(decreaseTemperature.execute());
                        break;
                    case "5":
                        IncreaseVolume increaseVolume = new IncreaseVolume(myDevice);
                        System.out.println(increaseVolume.execute());
                        if (choice.equals("Music Player")) {
                            System.out.println("\nMusic volume has turned up");
                            System.out.println("\nNow playing a new song. Playlist:");
                            System.out.println("1. ikaw lang - kiyo");
                            System.out.println("2. saan? - maki");
                            System.out.println("3. sinta - Rob Deniel");

                        }
                        break;
                    case "6":
                        DecreaseVolume decreaseVolume = new DecreaseVolume(myDevice);
                        System.out.println(decreaseVolume.execute());
                        if (choice.equals("Music Player")) {
                            System.out.println("\nMusic volume has turned down");
                        }
                        break;
                    default: System.out.println("Invalid selection, please choose again");

        }
        System.out.print("\nDo you want to perform another action? (yes/no): ");
            String continueChoice = sc.nextLine();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                break;
            }
    }
            
        }


    }


class availComms {
    public static void printAvailableCommands(String device) {
        System.out.println("\nAvailable commands for " + device + ": ");
        System.out.println("1 - Turn On\n2 - Turn Off\n3 - Increase Temperature\n4 - Decrease Temperature\n5 - Increase Volume\n6 - Decrease Volume");
    }

    public static String getUserCommand(Scanner userInput) {
        String commandChoice;

        while (true) {
            System.out.print("\nWhat command do you want to do: ");
            commandChoice = userInput.nextLine();
            int validCommand = getValidCommand(commandChoice);

            if (validCommand != 0) {
                break;
            } else {
                System.out.println("Invalid choice. Please select from 1-6.");
            }
        }

        return commandChoice;
    }

    public static int getValidCommand(String choice) {
        int validCommand;

        switch (choice) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
                validCommand = Integer.parseInt(choice);
                break;
            default:
                validCommand = 0;
        }

        return validCommand;
    }
}

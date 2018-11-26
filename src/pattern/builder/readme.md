# The Builder Pattern

The builder pattern is used to separate the construction of a complex object from its representation so that the same construction process can create different representations of the object. 

For this example, let's look at how we would represent a Computer in java. Say I have a class with these fields,
```java
public class Computer {

    //required fields
    private int ram;
    private String processor;
    private String hdd;
    private int hddCapacity;
    
    //Optional Fields
    private String graphicscard;
    private String secondGraphicsCard;
    private int processorSpeed;
    private int numUSBports;
    private int optional2ndHDD;
    private boolean hasTouchScreen;
    private boolean hasGraphicsCard;
    private boolean hasBluetooth;
    private boolean hasDiscDrive;
}
```
That's a lot of fields, and to mix things up even more, a lot of them are optional! The user may or may not specify that information, but either way, they need to be able to construct a computer with the required fields, and any number and selection of the optional fields. There are hundreds of possible combinations of parameters that the user could pass in, and lot of the constructors would have identical signatures, which is problematic. The solution to this problem is the builder pattern.

Typically, a builder is found as a nested public static class inside of the class that it is building. This allows it to access private constructors/methods/fields of the class that it is building that would not be visible externally. For the sake of a shorter example, I am shortening the above Computer definition to the following fields,

```java
public class Computer{
        //required parameters
        private String HDD;
        private String RAM;
    
        //optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;
}
```

Now, let's add in the Builder. Every method in the Builder will return the Builder object so that we can chain calls together, with the exception of the Build() method, which returns an instance of Computer.


```java
public class Computer{
    
    //required parameters
    private String HDD;
    private String RAM;
    
    //optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;
    
    //Private constructor
    private Computer(String HDD, String RAM, boolean isGraphicsCardEnabled, boolean isBluetoothEnabled){
        this.HDD=HDD;
        this.RAM=RAM;
        this.isGraphicsCardEnabled=isGraphicsCardEnabled;
        this.isBluetoothEnabled=isBluetoothEnabled;
    }

    //Builder Class
    public static class ComputerBuilder{
    
        // required parameters
        private String HDD;
        private String RAM;
    
        // optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;
    
        public ComputerBuilder(String hdd, String ram){ 
            this.HDD=hdd;
            this.RAM=ram;
        }
    
        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }
    
        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }
    
        public Computer build(){
            return new Computer(HDD, RAM, isGraphicsCardEnabled, isBluetoothEnabled);
        }
    
    }
}
```

Now, to use the Builder, we can do something like this:
```java
public class Demo{
    public static void main(String[] args){
        Computer.ComputerBuilder b=new Computer.ComputerBuilder("1tb SSD", "16gb");
        b.setGraphicsCardEnabled(true).setBluettoothEnabled(true);
        Computer myComputer=b.build();
        
    }
}
```

### Additional Reading
1. https://www.journaldev.com/1425/builder-design-pattern-in-java
2. https://sourcemaking.com/design_patterns/builder
3. https://www.geeksforgeeks.org/builder-design-pattern/
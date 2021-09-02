# JavaToArduino

## What is it?
It's a simple java application that turns on a LED using a serial port. You can use this as an example for your super project for your super robots.
The Java code can be seen in the src folder, while the Arduino one in the Arduino.ino file.

## How does it work?
It's quite simple: the java application opens a connection to the serial port (Thanks to [PureJavaComm](https://github.com/nyholku/purejavacomm)) and sends a string, converted to bytes, to it. The arduino reads it and check if it is !on or !off and does the respective action.

## How do I set it up?
You will need:
* An Arduino UNO
* A breadboard
* 3 wires
* A 220 ohm resistor

Follow this:

![test](https://i.ibb.co/LzSZxTP/resized-image-Promo.jpg)

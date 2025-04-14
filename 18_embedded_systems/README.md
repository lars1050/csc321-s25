## 18: Embedded Systems and Finite State Machines

Due: Monday, April 21 end-of-day.
Submit via MOODLE!!

Microprocessors are small computers that fit on tiny circuit boards. They have a CPU, memory, digital I/O, analog I/O, and other useful ports for connecting to different peripherals (i.e. hardware components that are not inside the microprocessor). These processors are typically part of an _embedded system_ built on a custom circuit board with various components, such as LEDs, buttons, serial ports, etc. One of the most widely-used hobby system is the family of Arduino boards (https://www.arduino.cc/) that have been designed around the Atmel microprocessors. You can buy one for around $20-$30 (see AdaFruit, https://www.adafruit.com/category/171, or DigiKey or go to Microcenter in St. Louis Park, https://www.microcenter.com/brand/4294809523/arduino).

_Embedded System_ refers to a system that uses a computer to control it or some aspect of it. What makes it different from a computer system is that you cannot access it directly with a keyboard and monitor. Everything from coffee pots to airplanes have microprocessors that are typically interacting with a physical system of sensors (e.g. touch, force, light, etc.) and actuators (i.e. things that move like gears driven by motors). Approximately 98% of all processors manufactured are placed in an embedded system! There is a need for programmers who specialize in this area who can help design medical devices, toys, industrial robots, autonomous cars, and the list goes on and on and on.

Programming embedded systems is hard for many reasons. They are often interacting with _peripherals_ (i.e. other hardware systems) through interrupts, which are hard to setup and even harder to debug. There is no OS, thus the scheduling of tasks must be done by the programmer. The hardware is custom made, so the programmer has to have knowledge about the layout and operations of that specific board and the corresponding custom function calls of that board. Embedded systems are highly constrained with respect to memory and processing power, thus it is essential to make efficient programs. Once an embedded system is programmed, it cannot be patched or updated, so it has to be robust. And, programs are written and compiled on a PC, then downloaded (flashed) to the board, making the whole process cumbersome on top of being complicated. 

Embedded systems are often programmed using C or assembly because these languages create lightweight programs. Although, as memory has gotten cheaper, it is more common to see C++. Over the next few weeks, you will be using a web simulation of an Arduino system, and then the Arduino IDE to program real hardware. The programs will involve pushing buttons and lighting up LEDs. The use of a finite state machine to design these systems can be very useful. 

<hr>

### Embedded Systems

Here is some common vocabulary you will encounter when working with embedded systems:

- digital I/O: communication with a peripheral through a "high" signal (i.e. 5V) or a "low" signal (i.e. 0v)

- port: 8-bit memory location on the microprocessor that can be used to communicate signals to and from peripherals

- pin: 1 of the 8 bits on a port. It can be configured as input or output.

- pinout or schematic: picture of how the microprocessor is connected to the various components on the board.

- power: power supply for a peripheral device. There are always PWR pins on a board (digital I/O typically does not need power).

- ground: shared signals need to be tied to the same ground to work. There are always GND pins on a board.

- LED: light emitting diode. If you send a HIGH signal to the pin that the LED is connected to, it lights up. CAUTION: you do need a resistor in between because 5V is too much for the LED -- it will fry.

- Button: physical device that either closes or opens a circuit. If the button is part of a circuit and connected to an INPUT pin, then when the signal changes from HIGH to LOW (or LOW to HIGH), the button is being pressed. Some buttons close the circuit when pressed and some open the circuit when pressed.

- Flash: upload the program on your PC to the board. 

- Resistor: electronics component that dampens the voltage.

- Control Loop: infinite loop inside of which the program runs forever.

Here are some common Arduino commands that you will be using.

- pinMode(8, OUTPUT): Set pin 8 as an output. This means you can connect an LED to that pin, set the pin HIGH, and the LED will light up.

- digitalWrite(8,HIGH): Set pin 8 to HIGH. This sends a 5V signal to pin 8.

- digitalWrite(8,LOW): Set pin 8 to LOW. This sends a 0v signal (thus turns the LED off).

- pinMode(10, INPUT): Set pin 10 as an input. This means you can connect a button to that pin and read the value to determine if it is pressed.

- digitalRead(10): Read the signal on pin 10. It might be HIGH or LOW. 

Arduino schematic: https://www.arduino.cc/en/uploads/Main/arduino-uno-schematic.pdf


### Simulator 

The Wokwi simulator (https://docs.wokwi.com/parts/wokwi-arduino-uno) is a free, easy-to-use simulator for a variety of Arduino boards (thanks to Dr. Atukorala for finding this!). We are using the Arduino Uno simulator, since that is what the Adafruit Metro is based on (the actual hardware that you will eventually be using). Anything programs you write on the simulator can be ported to the Metro.

There are 2 primary aspects to creating the simulator. The first is the JSON file that describes the components of the system and how they are connected. The second is the program to control the components. As we have been doing in our FSM's, each program has a setup and an infinite loop. There is a lot of code behind these elements that the Arduino IDE is managing. 

As I said, there are 2 key elements to define with the JSON: parts and connections.

- Parts: These are the components you will be interacting with. Primarily we need the board, LEDs, resistors, and buttons. Each part needs an id so that you can configure how it is wired up. Below is an example of an Uno board with an led and resistor.

- Connections: These specify how the system is physically wired together. Each line corresponds to a wire and what the 2 things are that it is connecting.

```
{
  "version": 1,
  "author": "Amy Larson",
  "editor": "wokwi",
  "connections": [],
  "dependencies": {},

  "parts": [
    { 	"type": "wokwi-arduino-uno", 
    	"id": "uno", 
    	"top": 120, "left": 20, 
    	"attrs": {} },
    {
      "type": "wokwi-resistor",
      "id": "r1",
      "top": 67, "left": 115, "rotate": 90,
      "attrs": { "value": "220" }
    },
    { 	"type": "wokwi-led", 
    	"id": "led1", 
    	"top": 0, "left": 120, 
    	"attrs": { "color": "red" } 
    }
  ],
  "connections": [
    [ "uno:GND.1", "led1:C", "black", [] ],
    [ "r1:1", "led1:A", "red", [] ],
    [ "uno:13", "r1:2", "red", [] ]
  ],
  "dependencies": {}
}
```

Explanation of Parts:

-  "type": "wokwi-resistor","id": "r1","top": 67, "left": 115, "rotate": 90,"attrs": { "value": "220" }. The resistor r1 is drawn at location 67,115 and rotated 90 degrees. It is a 220ohm resistor.

- "type": "wokwi-led", "id": "led1", "top": 0, "left": 120, "attrs": { "color": "red" }. The LED called led1 is drawn at location 0,120. It is a red led.

Explanation of Connections: 

- "uno:GND.1", "led1:C", "black", [] : GND 1 pin on uno is connected to the one side of the led1 using a black wire. The layout is default (determined by the simulation) Ground must always be connected to the "C" side.

- "r1:1", "led1:A", "red" : The one side of resistor r1 is connected to the A side of the LED using a red wire.

- "uno:13", "r1:2", "red" : The uno pin 13 is connected to the other side of the resistor r1 using a red wire.

Using the parts and connections above, below is an Arduino program to blink the led at 1 Hz. Hertz is a unit meaning (do something X times every second). The led is turning on and off, 1 time every second, hence it is blinking at 1 Hz.

```
const int RED = 13;

void setup() {
  pinMode(RED,OUTPUT);
}

void loop() {
  // blink the led at 1 Hz (that means on/off 1 time per second)
  digitalWrite(RED,HIGH);
  delay(500);
  digitalWrite(RED,LOW);
  delay(500);
}
```

<hr>

Let's look at a button now. Parts and connections for a button (in addition to the board and LEDs) are below.

```
"parts": [
    {
      "type": "wokwi-pushbutton",
      "id": "button",
      "top": 25,
      "left": 230,
      "attrs": { "color": "blue" }
    },
    {
      "type": "wokwi-resistor",
      "id": "rB",
      "top": 90,
      "left": 278,
      "attrs": { "value": "220" }
    }
```

To connect a button, you need to create a circuit with power and ground, as well as connect it to an Arduino pin. And as with leds, there needs to be a resistor in the circuit as well. Here are the connections.

```
  "connections": [
    [ "uno:GND.1", "led:C", "black", [] ],
    [ "rL:1", "led:A", "red", [] ],
    [ "uno:13", "rL:2", "red", [] ],

    [ "uno:GND.2", "rB:2", "black", [ ] ],
    [ "uno:5V", "button:1.r", "red", [ ] ],
    [ "uno:8", "button:2.l", "blue", [ ] ],
    [ "uno:8", "rB:1", "black", [ ] ]
```

In the code below, the red led will turn on while the button is being pushed.

```
const int RED = 13;
const int BUTTON = 8;

void setup() {
  pinMode(RED,OUTPUT);
  pinMode(BUTTON,INPUT);
}

void loop() {
  if (HIGH == digitalRead(BUTTON)) {
    digitalWrite(RED,HIGH);
  } else {
    digitalWrite(RED,LOW);
  }
}
```

<hr>

### Deliverables

** NOTE: The completed work will be submitted via Moodle this time for a variety of reasons.** 

You may work on your own or with 1 other person on this assignment.

DOWNLOAD the simulator when you are done. I think it all gets saved in your profile for the next time you login, but I recommend always downloading after you have made progress. 

1. Complete the tkinter (Python) implementation of the simplified Watch. 

	- pressing the time button will transition from setting hours, to setting minutes, back to waiting for a button press.
	
	- pressing the + or - button when in a state of setting hours or minutes will change HH or MM, as appropriate.
	
2. Create a new Arduino simulator that has 1 button and 1 red led. 

	- Go to https://docs.wokwi.com/parts/wokwi-arduino-uno. 
	- Choose Simulator in the upper right. 
	- Choose Arduino. 
	- Scroll to the bottom and select "Arduino Uno".

	Save it as **toggle**.

	- pressing the button will transition from the led being off, to the led being on, to the led blinking at 1 Hz.
	- connect the led to pin 13 and the button to pin 8.
	
	- IMPORTANT: the button must be immediately responsive. For this reason, you cannot use a delay to control the blinking (when in a blinking state). 
	
3. Create another Arduino simulator that has 2 buttons (1 red and 1 green) and 2 leds (1 red and 1 green). 

	Save it as **toggle2**.

	- copy the functionality from _toggle_ above in which the red button controls the state of the red led. 
	
	- pressing the green button will decrease the frequency of the blinking of the green led (by increasing the time between toggling on and off). Start the green led blinking at a frequency of 10 Hz (i.e. 50ms on, 50ms off). Every time the green button is pressed, increase that my 50 (i.e. 100ms on, 100ms off).

 	- connect the red led to pin 13 and the red button to pin 8.
	- connect the green led to pin 12 and the green button to pin 7.
	
	- IMPORTANT: the buttons must be immediately responsive. For this reason, you cannot use a delay to control the blinking.


What to submit:

	- The drawing of the FSM for the complex watch example.
	- The completed tkinter implementation of the simplified watch.
	- The simulator for toggle (1 led and 1 button).
	- The simulator for toggle2 (2 leds and 2 buttons).
	

Please structure your submission like this (then zip and submit):

18\_embedded
- collaborators.txt (even if you are the only one)
- fsm.pdf
- tkinter\_time.py
- toggle (unzipped folder)
	- diagram.json
	- sketch.ino
	- wokwi-project.txt
- toggle2 (unzipped folder)
	- diagram.json
	- sketch.ino
	- wokwi-project.txt

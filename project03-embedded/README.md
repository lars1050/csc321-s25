## Project: Scheduling with Embedded Systems

Due: any time before May 7, Wednesday, 12:00 (Finals Week)

Submit via MOODLE.

In this project, you and a partner (or you may work alone), will set up 2 different designs for blinking an led on an embedded system. The first way will be using delays inside a control loop. The other is using a timer interrupt. These offer 2 different design approaches to scheduling tasks. The delay in the control loop is akin to polling for events and the other is using interrupts to manage events. Each has their advantages.

You will again be using the Wokwi simulator (https://docs.wokwi.com/parts/wokwi-arduino-uno). Hardware (the Adafruit Metro 328) will be available for you to try out your code. If you want to work directly on the boards instead of the simulator, please ask. I have a limited supply, so first-come first-serve.

In the previous assignment, you used Arduino functions digitalWrite, digitalRead, and pinMode. In this project, you will be writing your own versions of these functions. You will create a separate file and include them in the main source file.

All class periods next week (after presentations) will be devoted to this assignment.

### BACKGROUND

Microprocessors are small computers that fit on tiny circuit boards. They have a CPU, memory, digital I/O, analog I/O, and other useful ports for connecting to different peripherals (i.e. hardware components that are not inside the microprocessor). These processors are typically part of an _embedded system_ built on a custom circuit board with various components, such as LEDs, buttons, serial ports, etc. One of the most widely-used hobby system is the family of Arduino boards (https://www.arduino.cc/) that have been designed around the Atmel microprocessors. You can buy one for around $20-$30 (see AdaFruit, https://www.adafruit.com/category/171, or DigiKey or go to Microcenter in St. Louis Park, https://www.microcenter.com/brand/4294809523/arduino).

_Embedded System_ refers to a system that uses a computer to control it or some aspect of it. What makes it different from a computer system is that you cannot access it directly with a keyboard and monitor. Everything from coffee pots to airplanes have microprocessors that are typically interacting with a physical system of sensors (e.g. touch, force, light, etc.) and actuators (i.e. things that move like gears driven by motors). Approximately 98% of all processors manufactured are placed in an embedded system! There is a need for programmers who specialize in this area who can help design medical devices, toys, industrial robots, autonomous cars, and the list goes on and on and on.

Programming embedded systems is hard for many reasons. They are often interacting with _peripherals_ (i.e. other hardware systems) through interrupts, which are hard to setup and even harder to debug. There is no OS, thus the scheduling of tasks must be done by the programmer. The hardware is custom made, so the programmer has to have knowledge about the layout and operations of that specific board and the corresponding custom function calls of that board. Embedded systems are highly constrained with respect to memory and processing power, thus it is essential to make efficient programs. Once an embedded system is programmed, it cannot be patched or updated, so it has to be robust. And, programs are written and compiled on a PC, then downloaded (flashed) to the board, making the whole process cumbersome on top of being complicated. 

Embedded systems are often programmed using C or assembly because these languages create lightweight programs. Although, as memory has gotten cheaper, it is more common to see C++. Over the next few weeks, you will be using a web simulation of an Arduino system, and then the Arduino IDE to program real hardware. The programs will involve pushing buttons and lighting up LEDs. The use of a finite state machine to design these systems can be very useful. 

<hr>

### OVERVIEW 

1. Add 2 external leds to the system on pin 12 (yellow led) and <del>pin 8</del> pin 11 (blue led). 

1. Create your own "library" for led operations and #include in main.

1. Flash the built-in red led (on pin 13) at 500ms ON - 500ms OFF - 500ms ON ... Using the main loop and the delay function.

1. Set up a timer interrupt to control the flashing of the external yellow led on pin 12.

1. Create a Pin Change Interrupt to introduce a peripheral device interrupt. Flash the external blue led (on <del>pin 8</del>) to visualize the delay. The delay in the interrupt is based on for loops, not the delay function.

_I have provided essentially all the code needed for this last requirement, but it is a lot to get it set up. If it is not working correctly, I suggest commenting out the other functionality while debuggging._

<hr>

#### Some things to know:

- To add a file to your simulator project, choose to "create new file" from the pull-down menu in the upper left. You should name your file with the extension ".h".

- The language C and C++ have a completely different model for combining files into a project. It does not matter that they are in the same directory -- you have to explicitly include them, similar to what is done in Python. Source code that refers to code in other files typically include that code with _#include "filename.h"_. ".h" files ("h" for header) include mostly declarations. The .c or .cpp files (for c++) have the definitions. During compilation, you have to tell the compiler which .c or .cpp files to compile into the project. It is a complex process and lengthy to explain (ask if you want to know more). For our purposes, we will use the .h extension for included files, and those files will contain both declarations and definitions.

- An interrupt is something that throws a signal to the system indicating that it needs to handle the interrupt. There is a specific ISR (Interrupt Service Routine) that is called when that interrupt happens. Arduino sets this up as a callback function, just as you did in Java graphics when an event happened.

- The Adafruit Metro has a couple of built-in timer interrupts. We will use the some open source Arduino functions to set up the timer. You can specify the frequency of the interrupt.

- The Metro has a built-in LED on pin 13. This is PORTB, pin 5 (see <a href="https://cdn-shop.adafruit.com/product-files/2488/Adafruit+Metrol_v2_0.pdf">Metro pinout</a>).

- The external LED is on pin 12 of the Adafruit Metro. This is PORTB pin 4 on the Atmega processor.

- To set up a pin for output (which is what you need for your led), use the Data Direction Register for port B (DDRB). For example, to send a signal out to the external led on PORTB pin 4, set pin 4 of the DDRB.

- Use the appropriate bitwise operators on the corresponding port (e.g. PORTB) with an appropriate pin mask in the led functions. Call the functions in setup, the control loop, and the interrupts.

- It is a good idea on embedded systems to specify how many bits to use for a variable, and use the absolute minimum possible. If you are storing an unsigned value that is less than 255, then you should declare it as `uint8\_t` (unsigned integer of 8 bits).

<hr>

### Creating Your Own Library for LED Operations

Create a my\_led.h file. At the top of main, add `#include "my_led.h"`

In my\_led.h, please include the following definitions and functions:

- define constants BUILT\_IN and EXTERNAL. The arguments passed to the following functions will be BUILT\_IN or EXTERNAL. Use a const uint8\_t. By setting these to the corresponding pin values, the code is very versatile.

- You may assume that the leds will always be on PORTB.

- initialize\_led(LED). Set up the specified LED for output using DDRB. **Follow this with a flash of that led** (by calling flash) to confirm it is working.

- led\_on(LED): SET the specified led pin.

- led\_off(LED): CLEAR the specified led pin.

- led\_toggle(LED): TOGGLE the specified led pin.

- led\_flash(LED): Blink the specified led 3 times (with a relatively high frequency). You can use delay.

For example,

```
const uint8_t BUILT_IN = 5;		// pin 13 on metro is PORTB pin 5 on Atmega
const uint8_t EXTERNAL = 4; 	// pin 12 on metro is PORTB pin 4 on Atmega

void led_on(uint8_t led_t) {
	// led_t: led type is either BUILT_IN or EXTERNAL 
	PORTB |= (1 << led_t);
}
```

<hr>

### Blink Built In LED Using Control Loop 

In main, initialize the built-in led (pin 13) for output, toggle its state in the main loop at a frequency that matches the timer interrupt (500 ms). Use a 50ms delay and count the number of times through the loop. After 10 times, toggle the led. The general framework is this:

```
uint8_t count = 0;

loop() {
	count++;
	if (count >= 10) {
		// toggle
		count = 0;
	}
	delay(50);
}
```

By using smaller ms delay in the main loop, it gives more time to other tasks that might need to be executed in the main loop.

<hr>

### Blink External LED Using Timer Interrupts

In the main file, define the call back function and initialize the timer to blink the external led. The callback function just needs to toggle the led. 

**Set the timer to delay at the exact frequency of the external led that is controlled via the main loop.**

Here is how you can set up the timer:

```
unsigned long ms_delay = 500;

void set_up(void) {
	...
  unsigned long us_delay = ms_delay * 1000;
  pinMode(led, OUTPUT);
  Timer1.initialize(us_delay);
  Timer1.attachInterrupt(<CALL BACK FN>);
}
```

That is it! You do not need any code in the loop to do anything. It is all handled through the hardware.

You have to include the library: #include <TimerOne.h> at the top of the file (without a semi-colon at the end). You will need to install that library. You can install a library by going to the Library Manager tab at the top and choosing the + button. Search for TimerOne.

Note the difference between `#include "filenam.h"` and `#include <TimerOne.h>`. If the library is installed, you use less-than greater-than around the header file. If the file is an individual file that you created, use quotes.

This is what it looks like if you don't use the Arduino library to set-up the timer interrupt. There are other (even more complicated) ways to set up timer interrupts.

```
void setup() {  
  TCCR1A = 0;
  TCCR1B = 0;
  bitSet(TCCR1B, CS12);  // 256 prescaler
  bitSet(TIMSK1, TOIE1); // timer overflow interrupt
  pinMode(LED_BUILTIN, OUTPUT);
}

ISR(TIMER1_OVF_vect) {
  digitalWrite(LED_PIN, !digitalRead(LED_PIN));
}

void loop() {}
```

Happy to walk you through this if you are interested.

<hr>

### Pin Change Interrupt

**Add what is called a PIN CHANGE INTERRUPT** to your setup and loop, and define the corresponding ISR (Interrupt Service Routine). A pin change interrupt is one that gets fired (i.e. signals the system) whenever the value of the pin changes. It can change from LOW to HIGH (i.e. RISING) or from HIGH to LOW (i.e. FALLING). Typically, you would attach the pin to a peripheral device (like a button or a sensor) that will signal the system that something has happened and needs attention. We are going to simulate that by changing the pin value internally at random times to trigger the interrupt.

This is the setup for a PCI (Pin Change Interrupt) ...

```
uint8_t INT_PIN = 0;	// on PORTB (see Adafruit Metro Pinout).

void setup(void) {
	
	...
	
	// Pin Change Interrupt Control Register. Enable interrupts on any pin 0-7
	PCICR |= 0x01;
		
	// Pin Change Mask for pins 0-7: Enable specific interrupt PCINT0 (pin 0)
	PCMSK0 |= (1 << INT_PIN);

	// Set interrupt pin as input (meaning the signal will be read)
	DDRB &= ~(1 << INT_PIN);
	
	// 
	pinState = 0;
}

void loop() {
	
  // this is a way to simulate a peripheral device activating the interrupt
  // increase the active count at each loop by some random amount
  // once we get to the threshold, signal a pin change
  activeCount += random(10);
  
  // is it time for a pin change?
  if (pollCount > 500) {
  	// change the state on that pin to trigger the PCINT
    if (pinState==0) {
      PORTB |= (1 << INT_PIN);
      pinState = 1;
    } else {
      PORTB &= ~(1 << INT_PIN);
      pinState = 0;
    }
    activeCount = 0; 
  }
  
  // code to control the toggle of the external led on pin 12 using delay(50)

}

/*
This is the callback function for a PCINT0 interrupt as required by
the Atmega processor. If there is a pin change on PORTB pin 0,
this function will be called.
*/
ISR(PCINT0_vect) {
  // delay() will not work inside of an interrupt.
  // a trick is to run a for-loop many,many times instead.

  // the counter must be long so it can count very high
  unsigned long i=0;

  // volatile is a key word telling the compiler not to ignore this
  // without it the for loop will not run
  volatile int k=0;
  
  // number of flashes
  int j=0;
  for (j=0; j<4; j++) {
    digitalWrite(11,HIGH);
    for (i=0; i<500000; i++) {
      k++;	// filler to not have an empty for loop
   }
    digitalWrite(11,LOW);
    for (i=0; i<500000; i++) {
      k--;
    }
  }
}

```

_Note how the ISR disrupts the timing of the other leds. This demonstrates one of the disadvantages of using interrupts. You do not have control over when the peripheral device will need attention, nor how long it will need the processor._


<hr>

### Summary and Deliverables

1. The file `my_led.h` is included and contains the following functions: `initialize_led(), led_on(), led_off(), led_toggle(), led_flash()`.

1. The external led (yellow) tied to pin 12 is controlled using the timer interrupt. In the interrupt, call the toggle function in my\_led.h.

1. The internal led (the red led on the board) is tied to pin 13 and is controlled using the control loop. 

1. The leds are set to toggle at the same rate. They will get out of sync!

1. A pin change interrupt and its corresponding ISR has been set up that simulates a peripheral device needing attention on occasion.

1. The ISR for the PCINT toggles the external blue led to show that it has been called.



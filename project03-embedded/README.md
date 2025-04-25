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

Some things to know:

- To add a file to your simulator project, choose to "create new file" from the pull-down menu in the upper left. You should name your file with the extension ".h".

- The language C and C++ have a completely different model for combining files into a project. It does not matter that they are in the same directory -- you have to explicitly include them, similar to what is done in Python. Source code that refers to code in other files typically include that code with _#include "filename.h"_. ".h" files ("h" for header) include mostly declarations. The .c or .cpp files (for c++) have the definitions. During compilation, you have to tell the compiler which .c or .cpp files to compile into the project. It is a complex process and lengthy to explain (ask if you want to know more). For our purposes, we will use the .h extension for included files, and those files will contain both declarations and definitions.

- An interrupt is something that throws a signal to the system indicating that it needs to handle the interrupt. There is a specific ISR (Interrupt Service Routine) that is called when that interrupt happens. Arduino sets this up as a callback function, just as you did in Java graphics when an event happened.

- The Adafruit Metro has a couple of built-in timer interrupts. We will use the some open source Arduino functions to set up the timer. You can specify the frequency of the interrupt.

- The Metro has a built-in LED on pin 13. This is PORTB, pin 5 (see <a href="https://cdn-shop.adafruit.com/product-files/2488/Adafruit+Metrol_v2_0.pdf">Metro pinout</a>).

- Add an external LED on pin 12: this is PORTB pin 4.

- To set up a pin for output (which is what you need for your led), use the Data Direction Register for port B (DDRB).

- To set, clear, or toggle the bit for an led, use the appropriate bitwise operators on the corresponding port (e.g. PORTB) with an appropriate pin mask. 

- It is a good idea on embedded systems to specify how many bits to use for a variable, and use the absolute minimum possible. If you are storing an unsigned value that is less than 255, then you should declare it as `uint8\_t`. 

<hr>

Create a my\_led.h file. At the top of main, add `#include "my_led.h"`

In my\_led.h, please include the following functions:

- define constants BUILT\_IN and EXTERNAL. The arguments passed to the following functions will be BUILT\_IN or EXTERNAL. You can do this with #defines or with const uint8\_t.

- define constants for the pin values of the built-in and external leds. It makes it super easy to change the code if you move the led to another pin.

- You may assume that the leds will always be on PORTB.

- initialize\_led(LED). Set up the specified LED for output using DDRX. Follow this with a flash of that led to confirm it is working.

- led\_on(LED): SET the specified led.

- led\_off(LED): CLEAR the specified led.

- led\_toggle(LED): TOGGLE the specified led.

- led\_flash(LED): Blink the specified led 3 times (with a relatively high frequency).

In the main file, set up the timer, define the call back function, initialize the leds, and write the control loop to blink the external led. For now, the callback function just needs to toggle the led. There will be some further modification to this function that will disrupt the timing.


**Set the timer to delay at the exact frequency of the external led.**

Here is how you can set up the timer:

```
unsigned long ms_delay = 1000;

  unsigned long us_delay = ms_delay * 1000;
  pinMode(led, OUTPUT);
  Timer1.initialize(us_delay);
  Timer1.attachInterrupt(<CALL BACK FN>);
```

You have to include the library: #include <TimerOne.h> at the top of the file. You will need to install that library.

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
  digitalWrite(LED_BUILTIN, !digitalRead(LED_BUILTIN));
}

void loop() {}
```

Happy to walk you through this if you are interested.

<hr>

There will be some small modifications to the above instructions that will be discussed in the last week of classes.

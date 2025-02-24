## JUnit Testing: An Introduction

junit: https://junit.org/junit5/

As a programmer, it is essential that you test your code. It is your responsibility as a team member to make sure that what you contribute to a project is correct. For production quality code, it is insufficient for you to "try" a couple of values, print the results to the screen, and check that they are right. You have to be just as thoughtful about how you test your code as you do about writing your code. Luckily, there are tools that help you formalize this process.

JUnit is a formal testing framework for Java. The tests are written in Java, but enhanced with `@`attributes that control most aspects of the tests. At the heart of a test is an `assert` statement that checks a condition based on the passed arguements. The behavior varies, but in general in most languages, if an assert finds that something is false, the program is abandoned. Throughout this exercise, you will create tests using various assert statements.

In this assignment, you will work with a partner to develop _Unit_ tests for the Circle. One of you will test Circle.overlaps and the other Circle.angles. Once you have complete the tests and shown that they compile, you will test a completed Circle class to find errors in the code.

Typically, a unit test of a class will test all methods of the class, including the constructors, getters, and setters. For this assignment, you will focus on testing the overlaps and angle methods.

You will first learn the various options for writing tests. Then, you will plan a series of tests, which you will implement in the JUnit framework.

<hr>

### Getting Started

Get your repo set up. Include a .gitignore and the collaborators.txt file. Copy the folder 10\_junit into your new repo.

Each of you try running the tests using the command-line junit commands, described below. 

The JUnit tests have been started for you. To run what is there, enter these commands in the terminal (_crediting Dr. Steinmetz for tracking this down_):

MAC

```
javac -cp .:./junit-platform-console-standalone-1.12.0.jar *.java

java -jar ./junit-platform-console-standalone-1.12.0.jar execute -cp . --scan-classpath .

java -jar ./junit-platform-console-standalone-1.12.0.jar execute -cp . --select-class CircleTest
```

WINDOWS 

```
javac -cp ".;./junit-platform-console-standalone-1.12.0.jar" *.java

java -jar ./junit-platform-console-standalone-1.12.0.jar -cp "." --scan-classpath "."

java -jar ./junit-platform-console-standalone-1.12.0.jar -cp "." --select-class CircleTest
```

The first line compiles the classes. The second and third line run the tests. The flag --scan-classpath looks for all possible tests, whereas --select-class will only run those in the provided file.


<hr>

### THE BASIC ASSERT

Take a moment to scroll through the output from the tests. You primarily want to look at the "tree" of tests, which is the first thing printed to the terminal. Relate the output to the test to the code in CircleTest. Notice the use of `@DisplayName` and where that appears. 

**Change one of the expected values of x or y so that the first test fails and compile-run again.**

**Now change the expected radius value so that also fails.**

There are a couple of things to notice. 1) The assert error message is the only information available that explains the failure, and 2) Once a test fails, execution returns from that method. Let us first attend to the first problem. Use `assertEquals` instead. The signature is `assertEquals(value,value,[optional message])`.

**Replace `assertTrue` with `assertEquals` creating 3 assert statements for x, y, and radius.**

For example,

```
assertEquals(defaultCircle.getX(),0,"default x value");
```

There are a lot of useful assert statements: 

https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html

Here are the ones you will probably use the most:

```
assertEquals    // same values, as in equals()
assertArrayEquals
assertSame      // same object, as in ==
assertFalse
assertTrue
assertNull
assertNotNull
assertAll
```

**Create another test and collection of assert statements to test the other constructor.**

```
@Test
@DisplayName("Not Default Constructor Tests")
void testConstructorNotDefault() 
```

Use any value that you want for instantiation and testing of a new circle.

<hr>

### BUNDLING TESTS WITH AssertAll

Any failed assert statement will break you out of the method and stop execution of any of the other tests. But often you want the tests to keep going regardless. You can bundle the tests with AssertAll. It has this general form:

```
assertAll("A bundle of asserts",
    () -> assertEquals("Jane", "Doe","jane as doe"),
    () -> assertEquals("Doe", "Jane","doe as jane"),
    () -> assertTrue(true,"true true")
);
```

The syntax `()->` is a lambda function. You will see this in a lot of test examples. Lambda functions have _lazy evaluation_ meaning they are essentially constructed and evaluated at runtime, unlike regular functions whose expressions are evaluated at compile time. _You do not need to understand lambda functions to make this work_.

And not only can you wrap all of the Constructor assert statements with `assertAll`, you can separate them into 2 bundles of assertAlls, like this:

```
	@Test
	@DisplayName("trying a bundle")
	void testBundle() {

		assertAll(
			"Bundles of asserts",
			()-> {
				assertAll(
					"A subset of tests in its own block",
					() -> assertEquals("Jane", "Jane", "jane is jane"),
					() -> assertEquals("Jane", "Doe","jane as doe"),
					() -> assertEquals("Doe", "Jane","doe as jane"),
					() -> assertTrue(true,"true true")
				); // closes the assertAll(subset)
			}, // closes first assertAll
	
			()-> {
				assertAll(
					"Another collection of asserts",
					() -> assertEquals(1+1,2,"good math"),
					() -> assertEquals(1+1,3,"bad math"),
					() -> assertFalse(true,"true but false")
				); // closes assertAll(another)
			} // closes 2nd assertAll
		); // closes outermost assertAll
	} // end testBundle
```

**Bundle the default constructor asserts and the non-default constructor asserts into different bundles.**

<hr>

### CREATING MULTIPLE TEST METHODS

As with any class, you can create as many test methods as you like. It is convention to have at least 1 test method for each class method. But if the class method is sufficiently complex, you probably want multiple test methods per class method.

**Create another method for the Circle.circumference method.**

```
@Test 
@DisplayName("Circumference Tests")
void testCircumference() {

}
```

When you test the circumference of a circle, you will want to create multiple circles with different values to ensure it works for both border and _nominal_ or typical values. For that you can use a `@ParameterizedTest`. The general form looks like this:

```Java
@ParameterizedTest(name = "Test with Parameter {0}")
@ValueSource(ints = {0,1,2,3})
void testWithValues(int param) {
    Circle circle = new Circle(0,0,param);
    assertEquals(2*Math.PI*param,circle.circumference());
}
```

Note that the `@Test` has been changed to `@ParameterizedTest`.

Also notice ints = {...}. The `ints` is a keyword for the type of elements in the list. You can use doubles and strings.

If you want to have more than 1 parameter, you can use `@CsvSource` instead of `@ValueSource`. You can even use a csv file! It has this general form:

```Java
@ParameterizedTest(name = "{0} relates to {1} and {2}")
@CsvSource({
            "0, 1, 2",
            "3, 4, 5"
    })
void testWithMoreValues(int param0, int param1, int param2) {
    System.out.println("Perhaps a message here or constructors");
    assertEquals(param1, instance.myfun(param2,param3),
        () -> param1 + " and " + param2 + " = " + param0
    );
}
```

**Incorporate a paramaterized test in _CircleTest_ and make sure you understand the syntax.**


> At any point, if you want to ignore a test, place the `@Disabled("Ignoring for now")` above the test method.

<hr>

### SUPPORT CODE AROUND TESTS

The last thing to mention is elements of tests that you want to create or manage before all, before each, after each, and/or after all. You can write those methods with the following tags:

```Java
@BeforeAll
static void setUpTests() {}
    
@AfterAll
static void tearDownTests() {}
    
@BeforeEach
void setUp() {}
    
@AfterEach
void tearDown() {}
```

@BeforeAll and #AfterAll are executed 1 time before and after, respectively, all the tests are run.

@BeforeEach and @AfterEach are execute prior to and after each test.

Here is a site with some examples: https://howtodoinjava.com/junit5/before-each-annotation-example/

<hr>

### Make a Plan

Each of you decide who will be writing tests for overlaps and angleBetween. Work with 2 other groups, splitting up by test method. In other words, if you are testing overlaps, find 2 other people from 2 other groups also testing overlaps. Together, develop a test plan for the method.

The test plan should include at least 6 distinct testing situations. For example, in overlap, you should test 2 circles that are not overlapping; in angleBetween, you should test 2 circles whose centers are both lying on the x-axis. As part of the plan:

- Generally describe the situation (e.g. "Testing non-overlapping circles").
- Identify the input for each test, which means the location and radius of each circle.
- Identify the expected output of each test.

For overlaps, the expected output will be either true or false. For the angleBetween, it might be anything from 0 to 359 degrees. Choose easy values to calculate (e.g. 0, 45, 90 degrees, etc.).

### Implement the Plan 

Join your partner again. Each of you create a branch on which to develop your tests. If you are testing overlaps(), create a file CircleOverlapTest.java. If you are testing angleBetween(), create a file CircleAngleTest.java. 

When complete, merge your branch with Main.

When you have a chance, each of you document your test plan in TESTS.md. Place this file inside the 10\_junit folder.

#### Requirements

In your tests, use:
- `assertAll` at some point
- `@DisplayName` for all tests
- Error messages in the asserts.

Somewhere in your tests, use each of the following JUnit constructs:
- `@ParameterizedTests`
- `@ValueSource`
- `@CsvSource`
- `@BeforeAll`, `@AfterAll`, `@BeforeEach`, or `@AfterEach` (just one)


On Wednesday, you will continue to work on this and eventually incorporate a complete Circle class.


 

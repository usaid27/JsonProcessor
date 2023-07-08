# JSON Processor

The JSON Processor is a Java program that reads a JSON input file, processes each JSON object based on its type, and writes the output to a JSON file.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Usage](#usage)
- [Solution Summary](#solution-summary)

## Prerequisites

- Java Development Kit (JDK) 8 or later
- Download JSON input file in this repo and give that file path in the code.

## Setup

1. Clone the repository or download the project files to your local machine.

2. Ensure you have Java Development Kit (JDK) 8 or later installed on your system. You can check the installed version by running the following command in your terminal:

   ```shell
   java -version


## Usage
Place the JSON input file in a directory accessible by the program.

Open the JSONProcessorClass.java file in a text editor.

Update the inputFilePath variable in the JSONProcessorClass class to specify the correct path for your input file:
String inputFilePath = "path/to/input.json";
Save the changes to the JSONProcessorClass.java file.

Open your terminal or command prompt and navigate to the directory containing the project files.

Compile the Java program by running the following command:
javac JSONProcessorClass.java

Run the program using the following command:
java JSONProcessorClass



The program will read the input JSON file, process each JSON object according to its type, and generate the output. The output will be written to the file named output.json in the same directory as the input file.

After the program finishes executing, you will see a message indicating the location of the output file.

## Solution Summary
The JSON Processor program uses a simple and efficient approach to process JSON objects based on their type. The program reads a JSON input file and processes each JSON object individually. For each JSON object, it extracts the "type" and "input" values, and then applies the appropriate processing logic based on the type.

The solution uses a Map<Character, Integer> data structure to track the count of characters in the input string. This allows for efficient identification of the first non-repeating and first repeating characters in the input. By maintaining a count of character occurrences, the program can identify the desired characters in a single pass through the input string.

The program makes use of the JSON-Java library to handle the JSON parsing and manipulation. The library provides convenient methods for reading and writing JSON data.

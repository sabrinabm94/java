# Project Title
Non-Deterministic Finite Automaton Simulator - AFN


## Getting Started

Download the repository and run the project on Intellij IDEA.

* The source root directory is src/main/java.
* The main class is Main.java.
* The AFN execution results file will be generated in the directory src/main/java, named "results.txt".

### Prerequisites

* You must have a file named "config.txt" in the directory src/main/java.
* The symbols for the execution of the AFN will be informed in the console during the execution of the program, stay tuned to the texts of the console.


## How to create the "config.txt" file
The config.txt file is required in order to use the program correctly.
This file is the basis for creating AFN, different AFN structure information is being displayed in each line of the file.

### File structure
* Line 1: list of all possible states in the AFN (each state separated by space).
* Line 2: list of all accepted symbols (the alphabet) of the AFN (each symbol separated by space).
* Second last line: Initial state of AFN.
* Last line: Final state of AFN.
* Other lines: The states resulting from the interaction of the existing states of the AFN x the existing symbols in the AFN (each symbol separated by space).


In the example file of "config.txt", the result of the AFN will be:

![matrix](https://i.imgur.com/qOno9lO.png)


## How to use the program

### AFN Menu
Here you have 2 options to choose:
 * 1 to proceed the program
 * 2 stop the program

If you chose option 1, you will go to the second menu.

### Symbol input menu
* Here you must enter all the symbols that you want to execute in the AFN.

* With each new symbol typed you must press enter, for each symbol to stay in one line.
* Each line can only have one symbol.

* The supported symbols are only the ones existed in the AFN alphabet (The AFN alphabet is the values entered in the second line of the "config.txt" file).


```
Example of use

SYMBOLS INPUT:
1
0
1
1
end

SYMBOLS EXECUTED
1 1 0 1 1

RESULT FILE
Initial state: q1

Read symbol: 1
Current states: q1

Read symbol: 1
Current states: q2

Read symbol: 0
Current states: q3

Read symbol: 1
Current states: q4

Read symbol: 1
Current states: q4

is accepted ? true

```

![example](https://i.imgur.com/BHU87hQ.png)

* Try on [Repl.it](https://repl.it/@saenyravalyria/afn)


## Versioning

For the versions available, see the [tags on this repository](https://github.com/saenyravalyria/java/tree/master/afnd/tags).


## Authors

* **Sabrina Saenyra Valyria B.** - *Full work* - [Github](https://github.com/saenyravalyria)


## License

This project is licensed under the MIT License.




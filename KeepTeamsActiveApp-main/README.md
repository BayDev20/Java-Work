# Keep Teams Active - Mouse Jiggler - Read Me

## Overview

THIS IS HIGHLY DETECTABLE AND NOT DESIGNED TO AVOID WORK.

This tool was designed to keep microsoft teams from closing. 

Mouse Jiggler is a simple Java program designed to keep your computer awake by intermittently moving the mouse pointer. This prevents the screen from entering sleep or screensaver mode. The program provides a user interface with "Start" and "Stop" buttons to control the mouse jiggling. Mouse functionality is maintained during use. 

## Table of Contents

1. [Features](#features)
2. [Prerequisites](#prerequisites)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Customization](#customization)
6. [Contributing](#contributing)
7. [License](#license)

## Features

- Start and stop mouse jiggling with the click of a button.
- Barely perceptible mouse movement to keep the screen awake.
- User-friendly graphical interface using Java Swing.

## Prerequisites

- Java Development Kit (JDK) installed on your system.
- A Java-compatible operating system (Windows, Linux, or macOS).

## Installation

1. **Download the Source Code:**
   - Clone this repository or download the source code ZIP file.

2. **Compile the Java Code:**
   - Open a terminal or command prompt.
   - Navigate to the directory containing the `jiggleJiggle.java` file.
   - Compile the Java code using the following command:
     ```sh
     javac jiggleJiggle.java
     ```

## Usage

1. **Run the Program:**
   - After compilation, run the program with the following command:
     ```sh
     java jiggleJiggle
     ```

2. **User Interface:**
   - The program will launch a graphical user interface (GUI) with "Start" and "Stop" buttons.

3. **Start Mouse Jiggling:**
   - Click the "Start" button to initiate the mouse jiggling.

4. **Stop Mouse Jiggling:**
   - Click the "Stop" button to halt the mouse jiggling.

## Customization

- **Adjusting Jiggle Frequency:**
  - Open the `jiggleJiggle.java` file in a text editor.
  - Locate the `timer = new Timer(500, ...)` line and adjust the value (in milliseconds) to change the jiggle frequency.


## Contributing

- Contributions are welcome! Feel free to fork the repository, make improvements, and submit pull requests.

## License

This project is licensed under the [GNU General Public License v3.0](LICENSE).

# SubDictionary Creator Program

## Overview

This Java program allows users to create a **sub-dictionary** from an existing text file. The program processes a given text file, extracts words, and generates a sub-dictionary containing all unique words sorted alphabetically. The sub-dictionary is written to a new file named `SubDictionary.txt`. 

### Features:
- Reads text from a user-specified input file.
- Processes the text by removing punctuation, spaces, and redundant words.
- Capitalizes every word and sorts them alphabetically.
- Outputs a clean, alphabetized sub-dictionary with the total count of words.
- Ignores words with digits or unwanted characters.

---

## How to Use

1. **Compile the Program**  
   To compile the program, run the following command:
   ```bash
   javac SubDictionary.java
   
2. **Run the Program**  
   To execute the program, use the following command:
   ```bash
   java SubDictionary

3. **Enter the File Name**  
   When prompted, enter the name fo the text file that you want to process. The file should be in the same directory as the program.
   Example input:
   ```bash
   Please enter the name of the file:
   example.txt

5. **Output**  
   After processing, the program will generate a new file named `SubDictionary.txt` containing the sub-dictionary. This file will include the list of unique words, sorted alphabetically, one word per line, organized by the starting letter.

---
## Program Workflow
1. **Reading the File**
   The program reads the input text file using a `Scanner` object.

2. **Text Processing**
   It removes punctuation (e.g., commas, periods, question marks), spaces, and numbers from the words. It also converts every word to uppercase.

3. **Removing Redundancy**
   Redundant words are removed, and only unique words remain.

4. **Sorting**
   The words are then sorted alphabetically.

5. **Writing to Output File**
   The cleaned and sorted list of words is written to `SubDictionary.txt` in an alphabetical order. Each word is preceded by the letter it starts with, and the total number of unique words is displayed at the top of the file.

---
## Example Output ('SubDictionary.txt')
```bash
The document produced this sub-dictionary, which includes 123 words.

A
===
A
ABILITY
ABLE
ABOUT
ACT
...

B
===
BAG
BALANCE
BALL
...

...
```

---
## Code Details
### Key Methods:  
- `dictionaryCreator(Scanner scanner, PrintWriter writer)`:  
Main function to process the text, remove redundancies, capitalize words, and sort them before writing to the output file.

- `sort(ArrayList<String> a)`:  
Sorts the list of words alphabetically.

- `capitalize(ArrayList<String> a)`:  
Capitalizes every word in the list.

- `removeRedundancy(ArrayList<String> a)`:  
Removes words with unwanted characters, numbers, or duplicates.

---
## Error Handling
- **FileNotFoundException**:  
If the specified input file cannot be found, the program will display an error message and exit.

- **IOException**:  
If the output file cannot be created or written to, an error message will be shown.

---
## Author
This program was developed by **Nicolas Buu**.


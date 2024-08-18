# BookTreeManager

## Project Overview

BookTreeManager is a Java-based application designed to manage a collection of books using a binary search tree (BST) and a custom implementation of a TreeMap. This project provides functionalities to load book data from a file, search for books by ISBN or author, and manage the collection using a BST and TreeMap. The project is part of the coursework for the Computer Programming 2 class (CSC 143).

## Features

- **Book Management:** Represents books with attributes like ISBN, authors, publication year, title, and average rating.
- **Data Loading:** Loads book data from a text file into a custom TreeMap structure for efficient management and retrieval.
- **Search Functionality:** 
  - Search for a book by its ISBN.
  - Search for books by a specific author.
- **Custom TreeMap Implementation:**
  - Adds key-value pairs in a sorted order based on keys.
  - Provides methods to get, put, check the existence of keys, clear the map, and convert keys to an array.
- **Binary Search Tree (BST):**
  - Implements a generic BST for storing comparable elements.
  - Supports operations like adding elements and checking if an element exists.

## Classes

### 1. `Book`

Represents a book with various attributes like ISBN, authors, publication year, original title, title, and average rating.

#### Key Methods:
- `getIsbn()`: Returns the ISBN of the book.
- `getAuthors()`: Returns the authors of the book.
- `getPublicationYear()`: Returns the publication year of the book.
- `getTitle()`: Returns the title of the book.
- `setIsbn(String isbn)`: Sets the ISBN of the book.
- `setAuthors(String authors)`: Sets the authors of the book.
- `setTitle(String title)`: Sets the title of the book.
- `toString()`: Returns a string representation of the book.

### 2. `Main`

The main class for the book management system. Demonstrates loading book data from a file and searching for books by ISBN and author.

#### Key Methods:
- `loadBooks(String filePath, TreeMap<String, Book> booksMap, List<String> isbns)`: Loads book data from a specified file into a TreeMap and a list of ISBNs.
- `searchBookByISBN(String isbn, TreeMap<String, Book> booksMap)`: Searches for a book by its ISBN and prints its details.
- `searchBooksByAuthor(String author, TreeMap<String, Book> booksMap, List<String> isbns)`: Searches for books by an author and prints the details of all matching books.
- `printBookDetails(Book book)`: Prints the details of a given book.

### 3. `SearchTree<E extends Comparable<E>>`

Implements a generic binary search tree (BST) for storing elements of type `E`.

#### Key Methods:
- `add(E value)`: Adds a value to the tree while maintaining the binary search tree property.
- `contains(E value)`: Checks if a specific value is contained within the tree.
- `clear()`: Removes all elements from the tree.

### 4. `TreeMap<K extends Comparable<K>, V>`

Custom implementation of a TreeMap using a binary search tree (BST).

#### Key Methods:
- `size()`: Returns the number of key-value pairs in the tree.
- `clear()`: Clears all key-value pairs from the tree.
- `get(K key)`: Retrieves the value associated with a given key.
- `put(K key, V value)`: Inserts a key-value pair into the TreeMap.
- `containsKey(K key)`: Checks if the TreeMap contains a specified key.
- `toKeyArray(K[] array)`: Converts the keys of the TreeMap into an array in sorted order.

### 5. `TreeMapInterface<K, V>`

An interface defining the required methods for the `TreeMap` class.

### 6. `TreeMapTest`

JUnit test class for `TreeMap`. Tests various functionalities, including insertion, size calculation, key existence check, and key array extraction.

## Usage

1. **Loading Books:**
   - The `Main` class reads book data from `BooksDataFile.txt` and loads it into a TreeMap.
   - It also stores the ISBNs in a list for quick access.

2. **Searching for Books:**
   - Use `searchBookByISBN()` to find a book by its ISBN.
   - Use `searchBooksByAuthor()` to find books by a specific author.

3. **Managing the Book Collection:**
   - The `TreeMap` class allows you to add, remove, and search for books efficiently.
   - The `SearchTree` class provides the underlying structure for the TreeMap.

## Example

To search for a book by its ISBN:

```java
String searchIsbn = "0451524934";
main.searchBookByISBN(searchIsbn, booksMap);

## Installation
    Clone the repository.
    Ensure you have Java installed on your machine.
    Compile the .java files using a Java compiler.
    Run the Main class to start the application.

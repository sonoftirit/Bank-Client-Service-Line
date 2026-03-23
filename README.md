# Bank Client Service Line

A Java project that simulates a bank waiting-line system using the **Java Collections Framework**, specifically a `PriorityQueue` with a custom `Comparator`.

## Overview

This project models a bank service line where clients are served by priority:

- **VIP** → highest priority
- **BUSINESS**
- **REGULAR** → lowest priority

If two clients have the same type, the one who arrived earlier is served first using `arrivalOrder`.

## Features

- Custom `Client` class with validation
- Custom `Comparator` for queue priority
- `PriorityQueue<Client>` for efficient service ordering
- Demo program showing service order
- Interactive menu-based queue system
- Input validation for menu, name, and type
- Safe sorted waiting-list display using a copy of the queue

## Files

### `Client.java`
Represents a bank client with:
- `name`
- `type`
- `arrivalOrder`

Includes:
- constructor
- getters
- validation
- `toString()`

### `ClientComparator.java`
Defines the service priority rules:
1. VIP first
2. BUSINESS second
3. REGULAR third
4. Earlier `arrivalOrder` first when types are equal

### `BankQueueDemo.java`
Creates a sample priority queue, adds clients, and prints the service order using repeated `poll()`.

### `BankQueueSystem.java`
Interactive program with the following menu:

```text
1) Add client
2) Serve next client
3) View next client
4) Remove client by name
5) Show waiting list
6) Exit

Validation Rules
Client name cannot be empty or blank
Client type must be VIP, BUSINESS, or REGULAR
Menu choice must be an integer from 1 to 6
Important Concept

A PriorityQueue does not display elements in sorted order when iterated directly.
To show the waiting list correctly, this program creates a copy of the queue and polls from the copy.

Time Complexity
offer() → O(log n)
poll() → O(log n)
peek() → O(1)
How to Run

Run either of these files:

BankQueueDemo.java → simple priority queue demo
BankQueueSystem.java → full interactive bank queue system
Author

Mustafa Tiritoglu
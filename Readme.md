# JAVA Console Kiosk

## Project Overview
This project is a Kiosk system implemented in Java, structured in different levels (Lv).

#### Lv1: Displaying the menu in the console
#### Lv2: Managing food items in the `MenuItem.java` class
#### Lv3: Handling UI and payment logic in the `Kiosk.java` class
#### Lv4: Managing menu categories in the `Menu.java` class
#### Lv5: Implementing cart and purchase functions, using Lambda & Stream for cart management, applying discounts via Enum, and automatically registering users while handling point accumulation & usage

### Summary
At Lv5, customers can select menu items, add them to the cart, and place orders while choosing a discount option.
For new users, their name, balance, and points are automatically saved. Additionally, when money and points are used or accumulated, they are permanently stored in a separate file.

### Future Improvements
1. Store point usage & accumulation history
2. Store purchase history
3. Implement credit card installment payment
4. Separate payment logic for debit card, cash, and credit card
5. Improve UI

--------

## Tech Stack
- **Language**: Java 17+
- **Build System**: Maven or Gradle
- **IDE**: IntelliJ IDEA
- **Version Control**: Git

-------------

## Project Structure
```
kioskProject/
│── src/                    # Source code directory
│   ├── Main.java           # Main execution file
│   │
│   ├── Lv1/                # Project Lv1 package
│   │   ├── Main.java       # Lv1 execution
│   │
│   ├── Lv2/                # Project Lv2 package
│   │   ├── Main.java       # Lv2 execution
│   │   ├── MenuItem.java   # Food item management
│   │
│   ├── Lv3/                # Project Lv3 package
│   │   ├── Main.java       # Lv3 execution
│   │   ├── MenuItem.java   # Food item management
│   │   ├── Kiosk.java      # UI/logic management
│   │
│   ├── Lv4/                # Project Lv4 package
│   │   ├── Main.java       # Lv4 execution
│   │   ├── MenuItem.java   # Food item management
│   │   ├── Kiosk.java      # UI/logic management
│   │   ├── Menu.java       # Food category management
│   │
│   ├── Lv5/                # Project Lv5 package
│   │   ├── Main.java       # Lv5 execution
│   │   ├── MenuItem.java   # Food item management
│   │   ├── Kiosk.java      # UI/logic management
│   │   ├── Menu.java       # Food category management
│   │   ├── UserData.java   # User data management
│   │   ├── PayType.java    # Payment method management
│   │   ├── Discount.java   # Discount management
│   │
│   ├── utils/              # Utility package
│   │   ├── Main.java       # Utility management
│   │
├── UserData/               # User data storage
```

-----------

## Key Features
### Customer Features
- Browse and select menu items
- Add items to the cart and place orders
- Automatic user registration
- Point accumulation and usage

### Admin Features
- Add, update, and delete menu items
- Apply discount policies

---------------

## How to Run
Execute `Main.java` in each package or run `src/Main.java`.

-----------

## License
This project follows the MIT License. Feel free to use it, but please provide credit.

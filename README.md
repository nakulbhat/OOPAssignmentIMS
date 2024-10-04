# Inventory Management System

## Classes

#### 1. Product (Abstract Class)
- [ ] **Attributes:**
  - [ ] `String id`
  - [ ] `String name`
  - [ ] `double price`
  - [ ] `int quantityInStock`
  
- [ ] **Methods:**
  - [ ] `abstract String getProductType()`
  - [ ] `void updateStock(int amount)`
  - [ ] `boolean isAvailable(int quantity)`

---

#### 2. Good (Extends Product)
- [ ] **Attributes:**
  - [ ] `double weight`
  
- [ ] **Methods:**
  - [ ] `String getProductType()`

---

#### 3. Cargo (Extends Product)
- [ ] **Attributes:**
  - [ ] `double volume`
  
- [ ] **Methods:**
  - [ ] `String getProductType()`

---

#### 4. Inventory
- [ ] **Attributes:**
  - [ ] `List<Product> products`
  - [ ] `int reorderThreshold`
  
- [ ] **Methods:**
  - [ ] `void addProduct(Product product)`
  - [ ] `Product getProductById(String id)`
  - [ ] `void procureProduct(String id, int quantity)`
  - [ ] `List<Product> getAvailableProducts()`
  - [ ] `void checkLowStock()`
  - [ ] `Statistics generateStatistics()`

---

#### 5. Statistics
- [ ] **Attributes:**
  - [ ] `int maxItemsOrdered`
  - [ ] `int totalRemainingGoods`
  - [ ] `int totalRemainingCargo`
  - [ ] `int totalOrdersOverPeriod`
  
- [ ] **Methods:**
  - [ ] `void updateStatistics(Order order)`
  - [ ] `String displayStatistics()`

---

#### 6. Order
- [ ] **Attributes:**
  - [ ] `String orderId`
  - [ ] `List<Product> products`
  - [ ] `double totalAmount`
  - [ ] `String shipmentMode`
  - [ ] `Date expectedDeliveryDate`
  
- [ ] **Methods:**
  - [ ] `void confirmOrder()`
  - [ ] `String getOrderDetails()`

---

#### 7. User (Abstract Class)
- [ ] **Attributes:**
  - [ ] `String username`
  - [ ] `String password`
  
- [ ] **Methods:**
  - [ ] `abstract void displayMenu()`

---

#### 8. Manager (Extends User)
- [ ] **Methods:**
  - [ ] `void addProduct(Product product)`
  - [ ] `void viewStatistics()`
  - [ ] `void receiveNotifications()`

---

#### 9. Customer (Extends User)
- [ ] **Methods:**
  - [ ] `List<Product> viewProductList()`
  - [ ] `Order placeOrder(List<Product> products)`


## Notes on Design
- **Concurrency Handling:** Consider synchronization mechanisms in the `Inventory` class to ensure thread safety when updating stock quantities.

## Team Member Assignments

#### **Vishal: Product Management**
- **Responsibilities:**
  - Implement the `Product` abstract class.
  - Develop the `Good` and `Cargo` subclasses.
- **Tasks:**
  - Define attributes and methods for each class.
  - Implement the `getProductType()` method for both `Good` and `Cargo`.

#### **Pratyush Bhagat: Inventory Management**
- **Responsibilities:**
  - Implement the `Inventory` class.
- **Tasks:**
  - Manage the collection of `Product` objects.
  - Implement methods to add products, procure products, check stock, and generate statistics.
  - Ensure thread safety for concurrent access (consider using synchronization).

#### **Prakhar: Order and Statistics Management**
- **Responsibilities:**
  - Implement the `Order` class and the `Statistics` class.
- **Tasks:**
  - Define attributes and methods for both classes.
  - Implement order confirmation and details methods in the `Order` class.
  - Create methods to update and display statistics in the `Statistics` class.

#### **Prajwal: User Management**
- **Responsibilities:**
  - Implement the `User` abstract class and the `Manager` and `Customer` subclasses.
- **Tasks:**
  - Define attributes and methods for user management.
  - Implement methods for adding products, viewing statistics, and placing orders for each user type.

#### **Nakul: User Interface and Integration**
- **Responsibilities:**
  - Develop a simple console-based or GUI interface for user interaction.
- **Tasks:**
  - Create menus for managers and customers.
  - Integrate all components (Product, Inventory, Order, Statistics, User) to allow seamless operation.
  - Handle user input and display appropriate messages (e.g., order confirmations, low stock notifications).

### Collaborative Tasks
- **Code Reviews:** Regularly review each other's code to ensure consistency and adherence to design principles.
- **Integration Testing:** Work together to test the integration of components and ensure that the system works as expected.
- **Documentation:** Collaborate on writing clear documentation for the overall system and individual components.

# Package Structure for Inventory Management System

- **com.inventorymanagement**
  - **model**
    - `Product.java`
    - `Good.java`
    - `Cargo.java`
    - `Order.java`
    - `Statistics.java`
  - **service**
    - `InventoryService.java`
    - `UserService.java`
    - `NotificationService.java`
  - **user**
    - `User.java`
    - `Manager.java`
    - `Customer.java`
  - **ui**
    - `ConsoleUI.java`
  - **exception**
    - `ProductNotFoundException.java`
    - `InsufficientStockException.java`

## Explanation of the Package Structure

- **com.inventorymanagement**: The root package for the Inventory Management System.

- **model**: Contains the data model classes representing the core entities of the system.
  - `Product.java`: Abstract class for common product attributes and methods.
  - `Good.java`: Subclass representing goods.
  - `Cargo.java`: Subclass representing cargo.
  - `Order.java`: Class representing customer orders.
  - `Statistics.java`: Class for generating and storing inventory statistics.

- **service**: Contains service classes that handle business logic and operations.
  - `InventoryService.java`: Manages product inventory, including adding and procuring products.
  - `UserService.java`: Handles user operations like authentication and user management.
  - `NotificationService.java`: Responsible for sending notifications about low stock or other alerts.

- **user**: Contains user-related classes.
  - `User.java`: Abstract class defining common user attributes and methods.
  - `Manager.java`: Class for manager-specific operations.
  - `Customer.java`: Class for customer-specific operations.

- **ui**: Contains classes for the user interface.
  - `ConsoleUI.java`: Implements a console-based user interface for interaction.

- **exception**: Contains custom exception classes for handling specific errors.
  - `ProductNotFoundException.java`: Exception thrown when a requested product is not found.
  - `InsufficientStockException.java`: Exception thrown when stock is insufficient for a procurement request.


## Original Question
Develop an Inventory Management System with following requirements:
1. The inventory keeps track of different products. A product is identified by a unique id, quantity in stock among other details. Any product can be categorised into a good or cargo depending on the mode of shipment (land vs sea).
2. The system must be capable of handling concurrent requests to procure a product. If the product requested is out of stock, then the system must prompt a suitable message and continue to procure products as specified by the system or abort the purchase altogether. Also, once a product count falls below a certain limit, a notification shall be generated.
3. The system can generate statistics such as maximum items ordered from a given location, total number of remaining products in the inventory (good vs cargo), number of products ordered over a period etc.
4. The system currently caters to two different types of users- the manager who can add products, receive notifications, view statistics; a customer who can receive the product list with its type, price and other details. The customer must be able to add one or more products and receive an order confirmation with total amount the mode of shipment and expected date of delivery.

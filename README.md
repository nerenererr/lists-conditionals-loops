# 🎵 Concert Management System

A Java application for managing concerts, tickets, and users with comprehensive statistics and validation.

## 📋 Project Overview

This system allows users to purchase concert tickets, rate concerts they've attended, and provides detailed analytics about ticket sales and revenue across multiple concerts.

## 🏗️ Class Structure

### Concert
Manages concert information and ticket sales.

**Attributes:**
- `artist` - Artist name
- `city` - Concert location
- `basePrice` - Base ticket price
- `maxAforum` - Maximum venue capacity
- `ticketsSold` - List of sold tickets
- `active` - Concert status (active/inactive)

**Key Methods:**
- `calculateRevenue()` - Returns total revenue from all ticket sales
- `calculateAveragePrice()` - Returns average price per ticket
- `availableTickets()` - Checks if tickets are still available

### Ticket
Represents individual concert tickets with different pricing tiers.

**Attributes:**
- `concert` - Associated concert
- `type` - Ticket type (SEATS, FLOOR, VIP)

**Pricing:**
- **SEATS**: Base price
- **FLOOR**: Base price + 10%
- **VIP**: Base price + 20%

### User
Manages user information, ticket purchases, and concert reviews.

**Attributes:**
- `name` - User name
- `age` - User age
- `ticketsBought` - List of purchased tickets
- `concertsAttended` - Set of attended concerts (prevents duplicates)
- `reviews` - Concert ratings (0-10 scale)

**Key Methods:**
- `buyTicket(concert, type)` - Purchase validation and ticket creation
- `toReview(concert, rating)` - Submit concert review (requires attendance)

## 🚀 Features

### Ticket Purchase Validation
- ✅ Concert must be active
- ✅ User cannot attend same concert twice
- ✅ Checks venue capacity
- ✅ Automatic ticket creation and assignment

### Review System
- ✅ Users can only review attended concerts
- ✅ Rating scale: 0-10
- ✅ Reviews can be updated

### Statistics & Analytics
- 📊 Total tickets sold across all concerts
- 📊 Breakdown by ticket type (SEATS, FLOOR, VIP)
- 📊 Total revenue calculation
- 📊 Average ticket price
- 📊 Most/least popular concerts

## 💻 Usage Example
```java
// Create concerts
Concert theodora = new Concert("Theodora", "Paris", 35.5, 2500, new ArrayList<>(), true);
Concert kaliUchis = new Concert("Kali Uchis", "Los Angeles", 55.0, 8000, new ArrayList<>(), true);

// Create user
User user = new User("Terry", 19, new ArrayList<>(), new HashSet<>(), new HashMap<>());

// Purchase tickets
user.buyTicket(kaliUchis, Ticket.Type.SEATS);
user.buyTicket(theodora, Ticket.Type.VIP);

// Submit review
user.toReview(kaliUchis, 8);

// Calculate statistics
double totalRevenue = theodora.calculateRevenue() + kaliUchis.calculateRevenue();
int totalTickets = theodora.getTicketsSold().size() + kaliUchis.getTicketsSold().size();
```

## 📈 Statistics Output

The main class provides comprehensive analytics:
```
Total tickets sold: 3
FLOOR tickets: 2
SEATS tickets: 1
VIP tickets: 0
Total revenue: 157.15€
Average price: 52.38€
Most popular: Kali Uchis's concert in Los Angeles (2 tickets)
Least popular: Theodora's concert in Paris (1 ticket)
```

## 🛡️ Error Handling

The system validates all operations and provides user-friendly error messages:

- `"Error: the concert is no longer active"` - Inactive concert
- `"Error: you already attended this concert"` - Duplicate attendance
- `"No more tickets available"` - Sold out
- `"You did not attend this concert"` - Invalid review attempt
- `"Not a valid number"` - Review out of range (0-10)

## 🔧 Technical Details

**Design Patterns:**
- Encapsulation with private attributes and public getters/setters
- Enum for ticket types (type-safe)
- Collections framework (ArrayList, HashSet, HashMap)
- Proper `equals()` and `hashCode()` implementation (avoiding circular references)

**Data Structures:**
- `ArrayList<Ticket>` - Maintains ticket order
- `HashSet<Concert>` - Prevents duplicate concert attendance
- `HashMap<Concert, Integer>` - Maps concerts to ratings

## 📝 Requirements

- Java 8 or higher
- No external dependencies

## 👥 Author
Nerea Ros
Created as part of a concert management system assignment.

## 📄 License

Educational project - free to use and modify.

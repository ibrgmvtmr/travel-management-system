# Travel Management System

## Project Overview
Tour and Travel Management System developed using Java, Java-Swing, and PostgreSQL.

## Project Requirements List
1. **Sign In:**
   - Allows users to create an account.

2. **Log In:**
   - Enables registered users to log in.

3. **Forgot Password:**
   - Provides a mechanism for users to recover their password.

4. **Add Personal Details:**
   - Allows users to input and save their personal information.

5. **Delete Personal Details:**
   - Enables users to remove their stored personal information.

6. **Add Booking:**
   - Allows users to make a travel booking.

7. **View Booking:**
   - Displays the user's current and past bookings.

8. **Delete Booking:**
   - Enables users to cancel a booking.

9. **Payment:**
   - Handles the payment process for bookings.

10. **About:**
    - Provides information about the Travel Management System.

11. **Exit:**
    - Allows users to exit the application.

## Team Members
- Kemelov Abai
- Nazarkulov Aman
- Ibragimov Timur

## Roles and Responsibilities
- **Kemelov Abai:**
  - Role: Front End
  - Responsibilities: Java Swing development.

- **Nazarkulov Aman:**
  - Role: Database
  - Responsibilities: PostgreSQL database management.

- **Ibragimov Timur:**
  - Role: Logic
  - Responsibilities: Java logic implementation.
 
## Download JAR File
[Download TMS JAR](https://github.com/ibrgmvtmr/travel-management-system/releases/download/v1.0.0/TMS.jar)

## Graphical User Interface
![photo_1_2023-12-16_22-56-13](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/a3d5e3d4-5d51-4a01-8317-b64cb3ea5aab)

![photo_8_2023-12-16_22-56-13](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/2dd9324e-7a01-4f3d-b2ea-5454b45187cb)

![photo_2_2023-12-16_22-56-13](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/03c778d7-c9f3-458e-8cfb-7c76ed0a1176)

![photo_7_2023-12-16_22-56-13](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/120fdaa3-60ea-48f6-b88a-e172abe5e815)

![photo_9_2023-12-16_22-56-13](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/65c30b26-6ff2-460e-9be1-abb71be9b801)

![photo_4_2023-12-16_22-56-13](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/3a463666-85df-4149-8555-6973bf97e09e)

![photo_3_2023-12-16_22-56-13](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/d6c1f362-63ac-42b7-b640-b11930ea48be)

![photo_4_2023-12-16_22-56-13](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/0ff45194-1ba3-4199-8d99-32159eb2e580)

![photo_10_2023-12-16_22-56-13](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/f6d2eb9e-cedd-4fd6-a916-4bd6344d9386)

## Database
Account and Customer:
Relationship: One-to-One
Foreign Key: customer_id in the Customer table references account_id in the Account table.
Explanation: Each customer is associated with exactly one account, and each account can be associated with at most one customer.

Customer and Hotel_books:
Relationship: One-to-Many
Foreign Key: customer_id in the Hotel_books table references customer_id in the Customer table.
Explanation: Each customer can have multiple hotel bookings, but each hotel booking is associated with exactly one customer.

Hotels and Hotel_books:
Relationship: One-to-Many
Foreign Key: hotel_id in the Hotel_books table references hotel_id in the Hotels table.

Explanation: Each hotel can have multiple bookings, but each booking is associated with exactly one hotel.
![photo_5_2023-12-16_22-56-13](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/b1979cb9-354b-428d-a513-32fd5397c1a0)

![photo_6_2023-12-16_22-56-13](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/8f235918-3040-4d0c-a296-724b10ed887e)

## Model- View- Controller representation
- **Model:**
![photo_1_2023-12-16_23-32-30](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/54d36199-3e97-4e30-b358-fdc3ee172d98)
![photo_2_2023-12-16_23-32-30](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/2b1450f0-97b1-4136-8bf6-665680fca599)
![photo_3_2023-12-16_23-32-30](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/a7910ae2-f6f0-49eb-9f93-a0b89f2ab61a)
![photo_4_2023-12-16_23-32-30](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/ca9a1bd2-534d-4903-87a9-8a7f80fb2be6)
![photo_5_2023-12-16_23-32-30](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/a12d9fff-bce1-4789-96fb-0a7402502dfd)
![photo_6_2023-12-16_23-32-30](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/7a2c2bee-bcc8-400c-adff-87844b55c318)
![photo_7_2023-12-16_23-32-30](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/9f1bddc4-24ef-4a68-83ca-7afae79a645d)
- 
- **View:**
![photo_1_2023-12-16_23-37-56](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/128e9709-a1e7-42b2-90b0-f7dc6e714e2a)
![photo_2_2023-12-16_23-37-56](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/0f28ba1b-c227-4b68-ade7-f153c9ff0fd7)
![photo_3_2023-12-16_23-37-56](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/9b7efde1-d792-464a-903b-669d55e2ba3f)
![photo_4_2023-12-16_23-37-56](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/621fdbf6-698b-4799-9ac5-4dc53a1b094d)
![photo_5_2023-12-16_23-37-56](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/2c8bff7b-4d38-4676-b5dc-79d464d045ee)
![photo_6_2023-12-16_23-37-56](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/e62ea076-43ac-4725-8992-6d27688d4511)
![photo_7_2023-12-16_23-37-56](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/dbc817a0-9e3e-49c6-b2d2-2c1625299124)
![photo_8_2023-12-16_23-37-56](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/7d90e871-487b-4f78-8bfb-d2f0c974caf5)

- **Controller:**
 ![photo_2023-12-16_23-40-58](https://github.com/ibrgmvtmr/travel-management-system/assets/122607659/c626e776-a1ed-4c9a-afea-3604bbf97cee)


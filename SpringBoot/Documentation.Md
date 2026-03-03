# Early Bird Discount – Documentation

## Design Choice

The `EarlyBirdDiscountService` is responsible only for business logic.  
It calculates the number of days between the booking date and the event date:

- Booking made 30 days or more in advance → 15% discount
- Booking made less than 30 days in advance → No discount

The Controller handles HTTP requests and responses, while the Service handles the business logic (separation of concerns principle).

---

## Why Constructor-Based DI?

Constructor-based Dependency Injection was chosen because:

- It enforces required dependencies
- It improves testability
- It is considered a Spring best practice
- It supports immutability and cleaner design

---

## Postman Scripts Advantages

**Pre-request Script**
- Logs information before sending the request
- Helps with debugging and tracking request data

**Post-response Script**
- Automatically validates the HTTP status code
- Verifies that the response follows business rules
- Reduces manual testing effort

---

## Behavior When Feature is Disabled

When:

feature.earlybird.enabled=false

- The `EarlyBirdDiscountService` bean is not created
- The application starts normally
- The API returns:

EarlyBird discount is not available.

---

## Challenges Faced

- Handling dependency injection when the conditional bean is disabled
- Ensuring the application does not crash when the feature is turned off
- Aligning feature toggling with API testing logic  
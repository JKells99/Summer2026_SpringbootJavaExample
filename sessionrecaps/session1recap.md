# SD 15 – Support Session Recap
**Date:** May 13, 2026 | **Duration:** ~58 min

## Project
Building a **Campus Food Review System** — starting with plain Java classes, then refactoring into Spring Boot.

---
## What We Did
### 1. Project Setup
- Chose campus food reviews as the project theme (over concert venue staff)
- Planned 3 core classes: `Campus`, `Restaurant`, `Review`
- Set up GitHub project board with backlog cards, user stories, and acceptance criteria

### 2. `Restaurant` Class
- Package: `com.keyin.campusfoodreview.restaurant`
- Fields: `long id`, `String restaurantName`, `String address`, `String phoneNumber`
- Generated constructors (with ID, without ID, empty), getters/setters, `toString()`
- Entry point (`RestaurantSystem`) placed in the **base package** — mirrors Spring Boot structure to avoid component-scan issues later
- Feature branch → PR → merged ✅

### 3. Unit Tests for `Restaurant`
- Mirrored package structure under `test/`
- Used `@BeforeEach` to initialize a fresh `Restaurant` before each test
- `testRestaurantCreation()` — asserts name and address match expected values
- `testRestaurantSetters()` — calls setters, asserts values are updated
- Feature branch → PR → merged ✅

### 4. `Review` Class *(in progress)*
- Package: `com.keyin.campusfoodreview.review`
- Fields: `long reviewId`, `String reviewText`, `LocalDateTime reviewDate`
- `reviewDate` auto-set in constructor via `LocalDateTime.now()`
- Relationship lives on `Restaurant`: `List<Review> reviews` + `addReview(Review r)` method
- **Known bug:** `restaurantId` field still exists in `Review` — to be removed next session
- PR opened, unit tests pending

---

## Key Reminders
- Branch per feature, keep PR descriptions tied to your card/issue
- Structure packages like a Spring Boot app from day one — saves refactoring later
- Use `@BeforeEach` to keep tests clean and isolated
- If your `test/` directory disappears: right-click `src` → New Directory → pick from Maven source directories

---

## Next Session
- [ ] Fix `restaurantId` bug in `Review`
- [ ] Write unit tests for `Review` and `addReview()`
- [ ] Add `Campus` class and wire up the full relationship
- [ ] Workshop: writing user stories & breaking down a client brief (Need to cook up a session for this and have a combined session with SD15 and SD16)

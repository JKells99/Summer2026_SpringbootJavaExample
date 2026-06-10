# SD 15 – Support Session Summary
**June 8, 2026 | ~57 minutes**
---
## Setup

### POM.xml / Dependencies
- Copy from a known-working POM to avoid version mismatch headaches
- Core dependencies: `starter-web`, `starter-test`, `starter-data-jpa`, `mysql-connector`
- Nice-to-haves: `springdoc-openapi` (Swagger UI), `H2` (in-memory DB)

### application.properties
- The `.env` equivalent for Spring Boot — configure DB connection, port, DDL auto, show-sql
- Add to `.gitignore` in team projects; share dummy values once and let each member fill in their own credentials

---

## Package Structure

- Organize **by entity**, not by file type (controller/service/repository folders get messy fast)
- Main application class must live in the **base package** to scan all sub-packages
- Don't rename or move the `main` source directory — Maven depends on it

---

## Entity Classes

Every entity needs:
- `@Entity`, `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)`
- A no-arg constructor (Spring requires it)
- A constructor without the ID, getters/setters
- Lists initialized as `new ArrayList<>()` in the constructor

Relationships used: `@OneToMany` (one-to-many). Keep them **unidirectional** — mapping both sides causes circular reference issues.

---

## The Four Layers

| Layer | Type | Role |
|---|---|---|
| Entity | Class | Represents a DB table |
| Repository | Interface extending `JpaRepository` | Built-in CRUD, data access |
| Service | Class | Business logic |
| Controller | Class | Exposes HTTP routes |

- Repository gives you `save`, `findAll`, `findById`, `deleteById`, etc. out of the box
- Service uses `@Autowired` to inject the repository *(note: field injection is not recommended — worth researching why)*
- Controller uses `@RestController`, `@RequestMapping`, `@PostMapping`, and `@RequestBody`

---

## Testing & Git Workflow

- Swagger UI available out of the box with the springdoc dependency — good for quick route testing; Postman also works
- Branch → commit → PR → CI check → merge to main → pull

---

## Follow-ups for Students

- [ ] Read through each POM dependency to understand its purpose
- [ ] Research: *Why is `@Autowired` field injection not recommended?*
- [ ] Practice the 4-layer structure on a personal project
- [ ] Add more routes: GET all, GET by ID, DELETE

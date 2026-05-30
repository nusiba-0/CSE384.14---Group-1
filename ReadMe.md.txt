# 🐾 MeowWoof — Stray Animal Management System

A full-stack web application for managing stray animals, built as a database lab project. MeowWoof helps volunteers and veterinarians coordinate animal care, food distribution, medical treatments, and adoptions — all in one place.

---

## 👥 Team

| Name | Student ID | Responsibility |
|---|---|---|
| Nazmul Hassan | 2022000000173 | Medicine, Vets, Admin — Project Lead & Integration |
| Nusiba Benta Alam | 2023100000334 | Medicine, Vets, Admin — Co-Lead & Integration |
| Md. Vubon Hossain | 2023000000105 | Volunteers & Reviews |
| Md. Humayon Kabir Suruj Prince | 2023200000009 | Areas & Food Distribution |
| Sabekunnahar Rupa | 2023200000019 | Users & Animals |

---

## ✨ Features

- 🔐 **Login & Sign Up** — separate auth flow for Volunteers and Vets
- 🐕 **Animal Management** — add, track and manage stray dogs and cats with health status, age, weight and vaccination info
- 📍 **Area Management** — define care zones with location and capacity
- 🍖 **Food Distribution** — log feeding sessions per area with volunteer tracking and notes
- 💊 **Medicine Records** — record treatments given by vets to specific animals
- ⭐ **Reviews** — volunteers can rate and review their experience in each area
- 🏠 **Adoption Requests** — submit, approve and reject adoption requests
- 📊 **Dashboard** — live stats showing total animals, areas, care needs, vaccinations, adoptions and reviews

---

## 🛠️ Tech Stack

**Backend**
- Java 17
- Spring Boot 4.0.6
- Spring Data JPA + Hibernate 7
- Maven

**Frontend**
- Vanilla HTML, CSS, JavaScript
- Google Fonts (Fredoka One, Nunito)
- Served as static files via Spring Boot

**Database**
- MySQL / MariaDB (via XAMPP)
- 8 relational tables with foreign keys, indexes and constraints

---

## 🗄️ Database Schema

```
areas               — care zones with capacity
animals             — stray animals with health & weight tracking
volunteers          — registered volunteer users
vets                — registered veterinarian users
food_distribution   — feeding session logs per area
medicines           — treatment records per animal and vet
adoption_requests   — animal adoption applications
reviews             — volunteer feedback on areas
```

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- XAMPP (for MySQL/MariaDB)
- IntelliJ IDEA (recommended)

### 1. Set up the database

1. Start XAMPP and make sure MySQL is running
2. Open `http://localhost/phpmyadmin`
3. Create a new database called `meowwoof_simple`
4. Go to the **SQL** tab, paste the contents of `database.sql` and click **Go**

### 2. Configure the database connection

Open `src/main/resources/application.properties` and update if needed:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/meowwoof_simple?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=
```

If your MySQL has a password, add it to the `password` field.

### 3. Run the app

Open the project in IntelliJ and run `MeowWoofApplication.java`, or from the terminal:

```bash
./mvnw spring-boot:run
```

### 4. Open in browser

```
http://localhost:8080
```

You'll be greeted by the login page. Use the sample credentials from `database.sql` or sign up as a new Volunteer or Vet.

**Sample login (Volunteer):** `rupa@test.com` / `pass123`
**Sample login (Vet):** `nazmul@vet.com` / `vet123`

---

## 📁 Project Structure

```
MeowWoof/
├── src/
│   ├── main/
│   │   ├── java/org/example/meowwoof/
│   │   │   ├── controller/       # REST API endpoints
│   │   │   ├── model/            # JPA entity classes
│   │   │   ├── repository/       # Spring Data JPA repositories
│   │   │   ├── service/          # Business logic
│   │   │   └── MeowWoofApplication.java
│   │   └── resources/
│   │       ├── static/           # Frontend (HTML, CSS, JS)
│   │       │   ├── index.html
│   │       │   ├── auth.html
│   │       │   ├── style.css
│   │       │   ├── auth.css
│   │       │   ├── script.js
│   │       │   ├── auth.js
│   │       │   └── auth-guard.js
│   │       └── application.properties
├── database.sql                  # Full DB schema + sample data
├── pom.xml
└── README.md
```

---

## 🔌 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET/POST | `/api/animals` | List or add animals |
| DELETE | `/api/animals/{id}` | Remove an animal |
| GET/POST | `/api/areas` | List or add areas |
| DELETE | `/api/areas/{id}` | Remove an area |
| GET/POST | `/api/food` | List or log food distribution |
| DELETE | `/api/food/{id}` | Remove a food record |
| GET/POST | `/api/medicines` | List or add medicine records |
| DELETE | `/api/medicines/{id}` | Remove a medicine record |
| POST | `/api/volunteers/register` | Register a new volunteer |
| POST | `/api/volunteers/login` | Volunteer login |
| POST | `/api/vets/register` | Register a new vet |
| POST | `/api/vets/login` | Vet login |
| GET/POST | `/api/reviews` | List or add reviews |
| DELETE | `/api/reviews/{id}` | Remove a review |
| GET/POST | `/api/adoptions` | List or submit adoption requests |
| PUT | `/api/adoptions/{id}/status` | Approve or reject a request |
| DELETE | `/api/adoptions/{id}` | Remove a request |

---

## 🐾 Notes

- Passwords are stored in plain text — this is a database lab project and not intended for production use
- The app uses `spring.jpa.hibernate.ddl-auto=update` so Hibernate will automatically sync the schema on startup
- XAMPP bundles MariaDB rather than MySQL — the app is fully compatible with both
- Session management is handled client-side via `localStorage`

---

*Made with ❤️ for strays everywhere.*
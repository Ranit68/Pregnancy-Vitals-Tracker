# 🤰 Pregnancy Vitals Tracker App

A modern Android application designed to help expectant mothers log, monitor, and manage pregnancy-related health vitals in a simple and intuitive way.

Built with **Jetpack Compose** and **MVVM architecture**, the app ensures clean UI, real-time updates, and reliable background reminders for consistent health tracking.

---

## 📱 App Overview

The Pregnancy Vitals Tracker allows users to:

* Log daily pregnancy vitals
* View historical records instantly
* Receive periodic reminders to update vitals
* Maintain health awareness through a clean, user-friendly interface

---

## ✨ Key Features

* 🩺 Track Blood Pressure (Systolic / Diastolic)
* ❤️ Monitor Heart Rate
* ⚖️ Record Weight
* 👶 Log Baby Kicks Count
* 📅 Automatic timestamp for each entry
* 🔄 Live data updates using StateFlow
* ⏰ Reminder notifications every 5 hours
* 📱 Modern Material UI design
* 🚀 Smooth and responsive user experience

---

## 🧠 Architecture

The application follows **MVVM (Model–View–ViewModel)** architecture:

```
UI (Jetpack Compose)
        ↓
ViewModel (StateFlow)
        ↓
Repository
        ↓
Room Database
```

This ensures:

* Separation of concerns
* Better testability
* Scalable and maintainable codebase

---

## 🛠 Tech Stack

| Technology      | Description                      |
| --------------- | -------------------------------- |
| Kotlin          | Primary programming language     |
| Jetpack Compose | Modern declarative UI            |
| Material 3      | UI components and design system  |
| Room Database   | Local data persistence           |
| StateFlow       | Reactive state management        |
| WorkManager     | Background reminders             |
| MVVM            | Clean architecture pattern       |
| Android 13+     | Notification permission handling |

---

## 📸 Screenshots

<img width="200" alt="Screenshot 2026-01-21 223615" src="https://github.com/user-attachments/assets/24f32501-fe6d-4d62-96d7-572c7ed6b025" />
<img width="200" alt="Screenshot 2026-01-21 224153" src="https://github.com/user-attachments/assets/d587e9e9-a490-4f14-b548-9176b60f55b2" />


* Home Screen
* Add Vitals Dialog

---

## 🚀 How to Run the Project

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/Pregnancy-Vitals-Tracker.git
   ```

2. Open the project in **Android Studio (latest version)**

3. Sync Gradle

4. Run on emulator or physical device

---

## 🔔 Permissions Used

* `POST_NOTIFICATIONS`
  Used for scheduled reminders to log vitals (Android 13+)

---

## 📚 What This Project Demonstrates

This project showcases:

* Modern Android UI using Jetpack Compose
* Proper use of Room with Flow/StateFlow
* Background task scheduling with WorkManager
* Clean architecture implementation
* Handling Android 13 notification permissions
* Real-world app structure and coding practices

---

## 👨‍💻 Developed By

**Sayon Das**
Android Developer | Jetpack Compose | Kotlin

📌 *Passionate about building clean, scalable, and user-friendly mobile applications.*

---

## ⭐ If you like this project

Don’t forget to **star ⭐ the repository** — it motivates continuous improvement!

---

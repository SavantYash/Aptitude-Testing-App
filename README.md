# 🧠 Aptitude Testing App  

An Android application built with **Kotlin + Jetpack Compose** that lets users practice and test their aptitude skills.  
The app provides a **30-question test (30 marks, 30 minutes)**, where users must complete within the time limit.  
If the user exits the app before submission, the test is marked as **failed**. When the timer expires, the test is **submitted automatically**.  

---

## ✨ Features  
- 📝 **Take Aptitude Test** – 30 questions, 30 marks, 30 minutes.  
- ⏳ **Timer Based Test** – Auto submission when time runs out.  
- 🚫 **Strict Test Rules** – Closing the app before submission marks the test as failed.  
- 📊 **Score Calculation** – Get total marks instantly.  
- 🔄 **Fetch Questions** – Data comes from a custom **Node.js + Express** backend.    
- 📶 **Online + Offline Support** – Fetch questions online, but maintain local history.  

---

## 🛠 Tech Stack  

### 🔹 Frontend (Android App)  
- **Language:** Kotlin  
- **UI:** Jetpack Compose  
- **Architecture:** MVVM  
- **Networking:** Retrofit + Coroutines  
- **State Management:** ViewModel + StateFlow  

### 🔹 Backend (Server)  
- **Runtime:** Node.js  
- **Framework:** Express.js  
- **Data storage:** XL sheet is used ( for quick access )
- **API:** Provides aptitude questions and test data

---

## Future Enhancements
- 📊 Detailed Analytics (Accuracy per topic, weak/strong areas)
- 👤 User Accounts (Login, Save progress online)
- 📱 Multiple Test Sets (Different categories of aptitude questions)
- 🌐 Sync with Cloud for test history

---
##Important Note
- Currently, the backend is offline. Updates will be provided once it goes live.

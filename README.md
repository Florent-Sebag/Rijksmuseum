# Rijksmuseum

## 📌 Overview
Rijksmuseum is an Android application that displays a list of artworks and their details.  
It is developed in **Kotlin** using **Jetpack Compose** for the UI.

## 🏛 Architecture
The app follows **Clean Architecture** principles and the **MVVM (Model-View-ViewModel)** pattern.  
It is structured into three layers:  

- **Presentation**: Contains `ViewModel`, `State`, and UI components built with Jetpack Compose.  
- **Domain**: Defines use cases for business logic.  
- **Data**: Manages data access via a repository that uses Retrofit.

## 🔧 Tech Stack
- **Jetpack Compose**: Declarative and reactive UI framework.  
- **Koin**: Dependency injection.  
- **Coroutines & Flow**: Asynchronous programming.  
- **Retrofit**: API requests to fetch artwork data.  
- **Navigation Component**: Handles navigation between screens.  

## 🚀 Build & Run
### Prerequisites:
- **Android Studio Flamingo or newer**
- **JDK 11+**
- **Internet connection (to fetch artwork data from the Rijksmuseum API)**

### Steps:
1. **Clone the repository**  
   ```bash
   git clone <repo_url>
   cd Rijksmuseum

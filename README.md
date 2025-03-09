# Messy Life - Mess Management App

## Overview
Messy Life is an Android application designed to simplify mess (shared accommodation) management. The app helps users track meals, expenses, and deposits for members in a mess or shared living arrangement. It provides a centralized platform for mess managers and members to monitor financial transactions and meal counts.

## Features
- **User Authentication**: Secure sign-up and login functionality using Firebase Authentication.
- **Member Management**: Add, view, and delete mess members with detailed profiles.
- **Meal Tracking**: Record and track individual meal counts.
- **Expense Management**: Add and monitor expenses for the mess.
- **Deposit Tracking**: Track deposits made by each member.
- **Financial Statistics**: View total deposits, expenses, mess balance, and meal rates.
- **Member Details**: Access detailed information about each member including personal information and financial status.

## Technology Stack
- **Frontend**: XML layouts for Android UI
- **Backend**: Java for Android application logic
- **Database**: Firebase Realtime Database
- **Authentication**: Firebase Authentication

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/Messy-Life.git
   ```
2. Open the project in Android Studio.
3. Connect your Firebase project by adding your `google-services.json` file to the `app` directory.
4. Build and run the application on an emulator or physical device.

## Getting Started
1. Sign up for a new account or log in with existing credentials.
2. Add mess members with their details.
3. Start recording meals, expenses, and deposits.
4. Use the main dashboard to monitor mess finances and meal statistics.

## Project Structure
```
Messy-Life/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/messylife/
│   │   │   ├── activities/          # Activity classes
│   │   │   │   ├── LoginActivity.java
│   │   │   │   ├── SignupActivity.java
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── AddMemberActivity.java
│   │   │   │   └── ...
│   │   │   ├── adapters/            # RecyclerView adapters
│   │   │   │   └── MemberAdapter.java
│   │   │   ├── models/              # Data models
│   │   │   │   └── Member.java
│   │   │   └── utils/               # Utility classes
│   │   │       └── FirebaseHelper.java
│   │   └── res/
│   │       ├── layout/              # XML layouts
│   │       │   ├── activity_login.xml
│   │       │   ├── activity_signup.xml
│   │       │   ├── activity_main.xml
│   │       │   └── ...
│   │       ├── values/              # Resource values
│   │       │   ├── colors.xml
│   │       │   ├── strings.xml
│   │       │   └── styles.xml
│   │       └── drawable/            # Images and drawable resources
│   └── google-services.json         # Firebase configuration file
├── gradle/                          # Gradle configuration
├── build.gradle                     # Project build configuration
└── app/build.gradle                 # App module build configuration
```

## Dependencies
- Firebase Authentication
- Firebase Realtime Database
- AndroidX AppCompat
- Material Design Components
- ConstraintLayout

## Future Improvements
- Implement individual meal tracking with date and time.
- Add shared cost calculation feature.
- Include notification system for payment reminders.
- Add monthly report generation.
- Implement user roles (admin, member).
- Add multiple mess support for users in different accommodations.

## Building and Running
The project uses Gradle as its build system. To build the app:
```sh
./gradlew assembleDebug
```
To install the app on a connected device:
```sh
./gradlew installDebug
```

## Contributing
Contributions are welcome! Please feel free to submit a Pull Request.
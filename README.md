# Service_Android_App
Build android app with Android studio and java

This project is an Android application that handles user interactions, displays data, and sends SMS messages. It uses SQLite for local data storage.


MainActivity.java:

    Purpose: The main entry point of the app. It displays a welcome screen with rotating animation and provides buttons for navigation to the login and signup activities.
    Key Components:
        AirplaneModeReceiver: Registers and unregisters a broadcast receiver to listen for airplane mode changes.
        startAnimation(): Applies a rotating animation to an ImageView.

Loginactivity.java:

    Purpose: Handles user login. When the login button is clicked, it navigates to the mainpage activity.
    Key Components:
        b1: Button for login.

signupactivity.java:

    Purpose: Manages user signup. Allows new users to enter their details and register.
    Key Components:
        Button to initiate the signup process.
        EditText fields for user input.

Dbhelper.java:

    Purpose: Manages database operations, including creating and upgrading the database, and inserting and reading data from the SQLite database.
    Key Components:
        addContact(String name, String location, String phone): Adds a new contact to the database.
        readAllData(): Retrieves all data from the database.

productlist.java:

    Purpose: Displays a list of products using a RecyclerView. Allows users to view product details and send SMS messages.
    Key Components:
        CustomAdapter: Binds data to the RecyclerView.
        sendMessage(String phoneNumber, String message): Sends SMS if permission is granted.

CustomAdapter.java:

    Purpose: Adapter for the RecyclerView in productlist.java. Binds product data to each item view in the list.
    Key Components:
        MessageSender: Interface for sending SMS messages.

Detail_tv.java:

    Purpose: Provides a form to enter and save product details. After saving, it navigates to the home fragment.
    Key Components:
        EditText fields for product details.
        Button to save the product details.

mech_productlist.java:

    Purpose: Displays a list of mechanical products with clickable images that navigate to the Detail_tv fragment.
    Key Components:
        ImageView elements for each product.
        OnClickListener to handle image clicks and navigate to the Detail_tv fragment.

SMSService.java:

    Purpose: A service for sending SMS messages in the background. Receives phone number and message from the productlist fragment and sends an SMS.
    Key Components:
        sendSMS(String phoneNumber, String message): Sends the SMS message using SmsManager.

profile.java:

    Purpose: Displays user profile information in a fragment. It shows the username, mobile number, email, and location.
    Key Components:
        TextView elements to display user details.
        Retrieves data from the Bundle arguments.

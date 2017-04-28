# Chat-System-JAVA
**keyword**: Java, GUI, UDP, AWT/Swing

**Description**: Java Chat System including UDP message and file transfer, fresh GUI interface, etc.

**Utils**
- `Java Version`: Java SE 8 [1.8.0_31]
- `How to compilate and execute`: 
  - `Compilate yourself` You can compilate the programe using javac 
  - `Using IDE like Eclipse` Include the .jar files included in "lib" folder and launch Window.java
- `List of implemented functionnalities`:
  - `Communication by sending and receiving text messages` Users can communicate by sending and receiving text messages or files (using UDP). Messages are sent to selected users (one or more) on the graphical interface. 
  - `Login with a single username` Every user uses an username to connect to the chat system, the system respond adequately wether the username is already used or not
  - `Notifications on the activity` When any user connect or disconnect, all the other users are informed about it and the graphical interface is update. Users are also notified when a received file is saved in their directory.
  - `Real time connected userlist` The list of connected users is presented allowing the user to chat or show a specific discussion.
  - `Connected userlist refreshment` If an user is disconnected (for any reason other than pressing the "Disconnect" button), the system is able to detect the disconnection and update the graphical interface. 
  - `Enhanced graphical visuals` The system is provided with a complete GUI interface that is updated wether the user is connected, connecting, disconnected, sending a message, selection a private conversation, etc. 

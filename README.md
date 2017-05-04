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
  
**List of tests driven on our project**
JUnit tests on the Model and the list of connected users
- `Test 1 : InitModelContainsNoRemoteUserTest`
  - `Description`: Init the components and verify that at the beginning, no user are in the list of connected users
  - `Autors`: R. DESPLATS & Y. MAO
  - `Result`: Success!
- `Test 2 : DisconnectRemoveElements`
  - `Description`: If we disconnect from the system, it removes all the connected users from the list
  - `Autors`: R. DESPLATS & Y. MAO
  - `Result`: Success!
- `Test 3 : CheckHasNoAnswerTest`
  - `Description`: If an user is in our connected list and his timer expires, he is then removed from the model
  - `Autors`: R. DESPLATS & Y. MAO
  - `Result`: Success!
- `Test 4 : ReceivedHelloTest`
  - `Description`: If we receive a Hello message, we add the User in the list of connected users
  - `Autors`: R. DESPLATS & Y. MAO
  - `Result`: Success!
- `Test 5 : ReceivedHelloOkTest`
  - `Description`: During the connection phase, if we receive a Hello_OK message, we add the User in the list of connected users
  - `Autors`: R. DESPLATS & Y. MAO
  - `Result`: Success!
- `Test 6 : ReceivedHelloNotOkTest`
  - `Description`: During the connection phase, if we receive a Hello_Not_OK message, we will be disconnected from the Chat System
  - `Autors`: R. DESPLATS & Y. MAO
  - `Result`: Success!
- `Test 7 : ReceivedGoodbyeDuringConnectingTest`
  - `Description`: Receiving a Goodbye message during the connecting phase removes the given user off the connected List
  - `Autors`: R. DESPLATS & Y. MAO
  - `Result`: Success!
- `Test 8 : ReceivedGoodbyeDuringConnectedTest`
  - `Description`: Receiving a Goodbye message after being connected removes the given user off the connected List
  - `Autors`: R. DESPLATS & Y. MAO
  - `Result`: Success!
- `Test 9 : ReceivedGoodbyeFromSomeoneNotInListTest`
  - `Description`: Receiving a Goodbye from an user who have the same username (as an user from our connected users list)and a different ip, should not remove the user that already exist. This could happen when someone try to connect with a username that is already used
  - `Autors`: R. DESPLATS & Y. MAO
  - `Result`: Success!
- `Test 10 : CheckHasAnsweredTest`
  - `Description`: If someone is in the list and his timer get restarted (by receiving a CheckOK), he isn't removed
  - `Autors`: R. DESPLATS & Y. MAO
  - `Result`: Not implemented

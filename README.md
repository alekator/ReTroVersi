# reversi-deeplay
## Reversi/Othello Game

### Description
This project involves the development of a multiplayer interpretation of the game Reversi (Othello). It features a wide range of algorithms that implement various opponents in the game, providing an engaging and challenging experience for players. Players can compete against each other or against AI-controlled bots, making for a versatile gaming experience.

![image](https://github.com/user-attachments/assets/bf587d36-bf04-407b-be7e-07418b983085)

![image](https://github.com/user-attachments/assets/93b9c63d-ea53-4d74-9175-ea78ff7e1939)

![image](https://github.com/user-attachments/assets/afe79af2-61e4-4896-86cd-a3766ca77f45)

![image](https://github.com/user-attachments/assets/f3d0723d-8795-4c6d-9355-5fbf0a2eb8d6)



### Getting Started
To run the application, follow these steps:

1. In the `file.properties` file in the `server` module, specify the desired port (default is 6070).
2. In the `file.properties` file in the `client` and `UI` modules, specify the necessary:
   - IP address in the `host` field (default is `localhost`)
   - `serverPort` (default is 6070)
   - `player` (set to `bot` if you want to play against a bot; set to `human` if you want to play yourself).
3. In the `file.properties` file in the `botfarm` module, specify the desired port (default is 6071).
4. Run `Server.java` in the `server` module.

### Playing with a Bot
To launch the bot, ensure that in step 2 you set the `player` field to `bot` and follow these steps:

1. In the `GetResponsesMethodsBot` class, replace the bot's name in the `commandWhereICanGoGameBot` method with the desired name (for both black and white).
2. Run the `client` class and enter the bot player's name (it doesn't have to be the same as the bot's name; it can be any combination of Latin characters).
3. The bot will automatically connect to the server and create a room.
4. If you want to connect to another room, enter the command `CONNECCTTOROOM *roomId*`, where `roomId` is the room you want to connect to (with you or another bot).
5. Once two players are in the room, the game will start automatically.

### Playing Solo (Console Mode)
To play on your own (console mode), ensure that in step 2 you set the `player` field to `human` and follow these steps:

1. Run the `client`.
2. Enter the command `REGISTRATION *nickname*`.
3. Enter the command `AUTHORIZATION *nickname*`.
4.1. If you want to connect to another room, enter the command `CONNECCTTOROOM *roomId*`, where `roomId` is the room you want to connect to (with you or another bot).
4.2. If you want to create a room, enter the command `CREATEROOM`.
5. Once two players are in the room, the game will start automatically.

### Playing Solo (Graphical Mode)
To play on your own (graphical mode), ensure that in step 2 you set the `player` field to `human` and follow these steps:

1. Run `clientGui` in the `UI` module (package `guiClient`).
2. Follow the intuitive and user-friendly graphical interface to start playing.

### Multiplayer Mode
The game includes a multiplayer mode that utilizes a graphical interface. Players can connect to each other via sockets using TCP, allowing for real-time gameplay. This feature enhances the gaming experience by providing a smooth and interactive environment where players can easily join or create rooms to compete against one another.

### Technologies Used
- Java for backend development.
- Socket programming for client-server communication.
- Algorithms for AI opponents.
- User-friendly interface in both console and graphical modes.

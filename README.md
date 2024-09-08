# Quiz-app
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz App - README</title>
</head>
<body>

    <h1>Quiz App</h1>

    <p>
        A simple, interactive Android quiz application that allows users to answer random programming-related questions and view their results. It is designed to enhance programming knowledge through fun quizzes, with a leaderboard to track scores.
    </p>

    <h2>Features</h2>
    <ul>
        <li>Enter player name and start the quiz.</li>
        <li>Displays random programming questions.</li>
        <li>Multiple-choice answers for each question.</li>
        <li>Tracks the user's score throughout the quiz.</li>
        <li>Shows final score at the end of the quiz.</li>
        <li>Displays leaderboard of scores for multiple players.</li>
    </ul>

    <h2>Classes and Functionality</h2>

    <h3>MainActivity</h3>
    <p>
        Handles the main screen where the player inputs their name and launches the quiz (QuestionsActivity) after validating the player name.
    </p>

    <h3>QuestionsActivity</h3>
    <p>
        Manages the display of questions and options, keeps track of the current question index and the player's score, navigates between questions, and shows the results at the end.
    </p>

    <h3>QuestionFragment</h3>
    <p>
        Displays individual questions and their answer options in a fragment. Collects the player's selected answer and passes it back to the activity.
    </p>

    <h3>Score</h3>
    <p>
        A model class that holds information about the player name and score.
    </p>

    <h3>ScoreAdapter</h3>
    <p>
        Custom adapter to populate the score list (leaderboard). Binds player names and scores to the corresponding views in the list.
    </p>

    <h3>ResultActivity</h3>
    <p>
        Displays the final score after completing the quiz. Allows users to return to the main screen or view the leaderboard.
    </p>

    <h2>Installation</h2>
    <ol>
        <li>Clone the repository:</li>
        <pre><code>git clone https://github.com/aqib/quiz-app.git</code></pre>
        <li>Open the project in Android Studio.</li>
        <li>Build and run the app on an Android device or emulator.</li>
    </ol>

    <h2>Screenshots</h2>
    <p>(![WhatsApp Ima![WhatsApp Image 2024-09-08 at 9 02 39 PM](https://github.com/user-attachments/assets/ed6f3450-8db2-4e59-b325-7816505abac8)
ge 2024-09-08 at 9 02 37 PM](https://github.com/user-attachments/assets/d7da9b8e-0701-4d7c-897b-105bb75da7fa)
)</p>



</body>
</html>
 

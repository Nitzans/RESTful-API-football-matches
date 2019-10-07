## Football Games Assignment
#### Description:
- This project contains the main controller (MatchController) which provides 4 APIs:
    1. Get list of matches by team.
    2. Get list of matches by team filtered by status.
    3. Get list of matches by tournament.
    4. Get list of matches by tournament filtered by status.

    Examples for running these APIs can be found at the "Running instructions" section below.
     
- If the user types invalid status or team/tournament that don't exist in the data it will display appropriate message.
- The input data is read in 'DataStore' class and stored in hash maps for an easy access.

#### Running instructions:
- Run 'Application.java'.
- In your browser (or Postman application) type GET requests in the following format:

    * For all the matches which TEAMNAME participates in: http://localhost:8080/team?name=TEAM-NAME
    * For upcoming matches which TEAMNAME participates in: http://localhost:8080/team/upcoming?name=TEAM-NAME
    * For finished matches which TEAMNAME participated in: http://localhost:8080/team/played?name=TEAM-NAME
    * For all the matches of TOURNAMENT-NAME: http://localhost:8080/tournament?name=TOURNAMENT-NAME
    * For upcoming matches of TOURNAMENT-NAME: http://localhost:8080/tournament/upcoming?name=TOURNAMENT-NAME
    * For finished matches of TOURNAMENT-NAME: http://localhost:8080/tournament/played?name=TOURNAMENT-NAME

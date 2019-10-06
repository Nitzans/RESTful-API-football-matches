## Football Games Assignment

This project contains controller which provided 4 APIs:
1. Get list of matches by team.
2. Get list of matches by team filtered by status.
3. Get list of matches by tournament.
4. Get list of matches by tournament filtered by status.

#### Running instructions:
- Run 'Application.java'.
- In your browser (or Postman application) type GET requests in the following format:

    * For all the matches which TEAMNAME is participate in: http://localhost:8080/team?name=TEAM-NAME
    * For upcoming matches which TEAMNAME is participate in: http://localhost:8080/team/upcoming?name=TEAM-NAME
    * For finished matches which TEAMNAME is participate in: http://localhost:8080/team/played?name=TEAM-NAME
    * For all the matches of TOURNAMENT-NAME: http://localhost:8080/tournament?name=TOURNAMENT-NAME
    * For upcoming matches of TOURNAMENT-NAME: http://localhost:8080/tournament/upcoming?name=TOURNAMENT-NAME
    * For finished matches of TOURNAMENT-NAME: http://localhost:8080/tournament/played?name=TOURNAMENT-NAME

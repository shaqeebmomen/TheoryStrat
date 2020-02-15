class Match {
    //Fields/Variables

    private String matchNum;
    private String [] teams; //r1,r2,r3,b1,b2,b3

    //Constructor
    public Match(String matchN){
        this.matchNum = matchN;

        // DataHelper dataH = new DataHelper(); This is the normal way but for this project specifically, see below
        DataHelper dataH = DataHelper.getInstance();

        teams = dataH.getTeams(matchNum);

    }


    //Methods

    //-----------------------------  Getters ----------------------------//
    
    public String getMatchNum() {
        return matchNum;
    }

    // Return Teams for set match
    public String getTeamsR1(){
        return teams[0];
    }
    public String getTeamsR2(){
        return teams[1];
    }
    public String getTeamsR3(){
        return teams[2];
    }
    public String getTeamsB1(){
        return teams[3];
    }
    public String getTeamsB2(){
        return teams[4];
    }
    public String getTeamsB3(){
        return teams[5];
    }
    
    //------------------------------  Setters -----------------------------//
    public void setMatchNum(String matchNum){
        this.matchNum = matchNum;
    }

    public void setTeams(String teamR1, String teamR2, String teamR3, String teamB1, String teamB2, String teamB3){
        this.teams[0] = teamR1;
        this.teams[1] = teamR2;
        this.teams[2] = teamR3;
        this.teams[3] = teamB1;
        this.teams[4] = teamB2;
        this.teams[5] = teamB3;

    }
    
    public void setTeamR1(String teamR1){
        teams[0] = teamR1;
    }
    public void setTeamR2(String teamR2){
        teams[1] = teamR2;
    }
    public void setTeamR3(String teamR3){
        teams[2] = teamR3;
    }
    public void setTeamB1(String teamB1){
        teams[3] = teamB1;
    }
    public void setTeamB2(String teamB2){
        teams[4] = teamB2;
    }
    public void setTeamB3(String teamB3){
        teams[5] = teamB3;
    }

}
package JogoSudoku.model;

public enum GameStatus {

    NON_STARTED,
    INCOMPLETE,
    COMPLETE;

    private String label;

     void GameStatusEnum(final String label){
        this.label = label;
    }

    public String getLabel(){
         return label;
    }




}

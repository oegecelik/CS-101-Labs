package lab7;

public class Track{
    //Static Data Members
    private static int count = 0;
    private static int allCount = 0;

    //Instance Data Members
    private long playCount = 0;
    private int ID = 0;
    private String title = "";
    private int album = 0;
    private int artist = 0;
    private String releaseDate = "";
    private short duration = 0;
    private String genre = "UN";
    private String genreToPrint = "Unspecified";
    private boolean isActive = true;
    private String length = "";
    private int seconds = 0;
    private int minutes = 0;

    //Constructor Method
    public Track(String title, int album, int artist, String releaseDate, short duration){
  
 
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.minutes = this.duration / 60;
        this.seconds = this.duration % 60;
        this.length = this.minutes + " min and " + this.seconds + " sec";
        this.register();
    }

    //Accessor Methods
    public int getID() {
        return this.ID;        
    }
    public String getTitle() {
        return this.title;        
    }
    public int getAlbum() {
        return this.album;        
    }
    public int getArtist(){
        return this.artist;
    }
    public String getReleaseDate() {
        return this.releaseDate;        
    }
    public short getDuration() {
        return this.duration;        
    }
    public int getCount(){
        return Track.count;
    }
    public int getAllCount(){
        return Track.allCount;
    }
    public boolean getIsActive(){
        return this.isActive;
    }
    public String getGenre(){
        return this.genre;
    }

    //Setter Methods
    public void setGenre(String genre){
        if(genre.equals("PO")){
            this.genreToPrint = "Popular";
        }
        else if(genre.equals("RO")){
            this.genreToPrint = "Rock";
        }
        else if (genre.equals("JA")){
            this.genreToPrint = "Jazz";
        }
        else if(genre.equals("OT")){
            this.genreToPrint = "Other";
        }
    }

    public void register(){
        Track.count++;
        Track.allCount++;

        this.ID = allCount;
    }

    public void unregister(){
        Track.count--;
        this.isActive = false;
    }

    //Service Methods
    public boolean isBefore(Track compared){
        String firstDateReversed = "";
        String secondDateReversed = "";
        boolean toReturn;

        int length = 10;

        for(int i= length-4; i<=length-1; i++){
            firstDateReversed += compared.getReleaseDate().charAt(i);
        }
        firstDateReversed += "/";
        for(int i = length-7; i<= length-6; i++){
            firstDateReversed += compared.getReleaseDate().charAt(i);
        }
        firstDateReversed += "/";
        for(int i = 0; i<= 1; i++){
            firstDateReversed += compared.getReleaseDate().charAt(i);
        }

        for(int i= length-4; i<=length-1; i++){
            secondDateReversed += this.releaseDate.charAt(i);
        }
        secondDateReversed += "/";
        for(int i = length-7; i<= length-6; i++){
            secondDateReversed += this.releaseDate.charAt(i);
        }
        secondDateReversed += "/";
        for(int i = 0; i<= 1; i++){
            secondDateReversed += this.releaseDate.charAt(i);
        }
       int comparison = firstDateReversed.compareTo(secondDateReversed);
       if(comparison>0){
        toReturn = true;
       }
       else if(comparison==0){
        toReturn = true;
       }
       else{
        toReturn = false;
       }
       return toReturn;
    }
    public void play(){
        if(this.isActive){
            this.playCount++;
        }
        else{
            System.out.println("play() called on inactive track!");
        }
    }
    public void playBatch(int countToIncrement){
        this.playCount += countToIncrement;
    }
    public String toString(){

        String toReturn = "*************************************\n";
        if(this.isActive){
            toReturn += "Active ";
        }
        else{
            toReturn += "Inactive ";
        }
        toReturn += "track " + this.ID + " among ";
        if(this.isActive == false){
            toReturn += Track.allCount + " tracks\n";
        }
        else{
            toReturn += Track.count + " active tracks\n";
        }        

        toReturn += "Title:   " + this.title + "\n" 
        + "Album:   " + this.album + "\n" 
        + "Artist:  " + this.artist + "\n"
        + "Release: " + this.releaseDate + "\n"
        + "Length:  " + this.length + "\n"
        + "Genre:   " + this.genreToPrint + "\n"
        + "Played:  " + this.playCount + "\n"
        + "*************************************\n";

        return toReturn;
    }
    public static void main(String[] args) {
        Track t1 = new Track("Love over gold", 123, 234, "12/08/1982", (short)2473);
t1.setGenre("RO");
Track t2 = new Track("Gozleri aska gulen", 0, 98, "18/04/2018", (short)257);
t2.setGenre("PO");
Track t3 = new Track("Down to the waterline", 123, 234, "09/06/1978", (short)235);
System.out.println("Is t1 before t2? " + t1.isBefore(t2));
System.out.println("Is t2 before t3? " + t2.isBefore(t3));

t1.play();
t3.play();
t3.play();
t1.playBatch(100);
t3.playBatch(10);
t1.play();
t2.playBatch(50);
t1.unregister();
t1.play();
System.out.println(t1.toString());
System.out.println(t2.toString());
System.out.println(t3.toString());
    }
}
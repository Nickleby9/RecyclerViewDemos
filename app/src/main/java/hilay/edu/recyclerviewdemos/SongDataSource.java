package hilay.edu.recyclerviewdemos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android2017 on 5/9/2017.
 */

public class SongDataSource {
    public static List<SongItem> getSongs(){
        ArrayList<SongItem> songs = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            songs.add(new SongItem("Dont look back in anger", "Oasis", R.drawable.oasis, "", "4:23"));
            songs.add(new SongItem("Forced fecal Ingestion", "Vulvodynia", R.drawable.vulvodynia, "", "2:34"));
            songs.add(new SongItem("The Chain", "Fleetwood", R.drawable.fleetwood, "", "2:31"));
            songs.add(new SongItem("Call Me", "Blondie", R.drawable.blondie, "", "3:12"));
        }
        return songs;
    }
}

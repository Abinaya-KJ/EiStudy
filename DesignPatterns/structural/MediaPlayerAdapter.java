// Java Example: Adapter Pattern (Structural)
// Use Case: Media Player Compatibility System

// Legacy interface (incompatible)
interface OldMediaPlayer {
    void playOld(String audioType, String fileName);
}

// Modern interface (what we want to use)
interface ModernMediaPlayer {
    void play(String fileName);
}

// Legacy implementation
class LegacyPlayer implements OldMediaPlayer {
    public void playOld(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else {
            System.out.println("Legacy player cannot play " + audioType + " files");
        }
    }
}

// Modern implementations
class MP4Player implements ModernMediaPlayer {
    public void play(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}

class VLCPlayer implements ModernMediaPlayer {
    public void play(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}

// Adapter - makes old player compatible with modern interface
class MediaAdapter implements ModernMediaPlayer {
    private OldMediaPlayer legacyPlayer;
    
    MediaAdapter(OldMediaPlayer legacyPlayer) {
        this.legacyPlayer = legacyPlayer;
    }
    
    public void play(String fileName) {
        // Extract file type from filename
        String audioType = fileName.substring(fileName.lastIndexOf(".") + 1);
        legacyPlayer.playOld(audioType, fileName);
    }
}

// Client that uses modern interface
class MediaClient {
    private ModernMediaPlayer player;
    
    void setPlayer(ModernMediaPlayer player) {
        this.player = player;
    }
    
    void playFile(String fileName) {
        player.play(fileName);
    }
}

public class MediaPlayerAdapter {
    public static void main(String[] args) {
        MediaClient client = new MediaClient();
        
        // Using modern players directly
        client.setPlayer(new MP4Player());
        client.playFile("movie.mp4");
        
        client.setPlayer(new VLCPlayer());
        client.playFile("video.vlc");
        
        // Using legacy player through adapter
        LegacyPlayer oldPlayer = new LegacyPlayer();
        MediaAdapter adapter = new MediaAdapter(oldPlayer);
        client.setPlayer(adapter);
        
        client.playFile("song.mp3");  // This works through adapter
        client.playFile("music.wav"); // This won't work - legacy limitation
    }
}

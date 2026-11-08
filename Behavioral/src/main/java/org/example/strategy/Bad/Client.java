package org.example.strategy.Bad;

public class Client {
}

enum Compressor{
    MOV, MP4, WEBM
}

enum Overlay{
    NONE,
    BLACK_AND_WHITE,
    BLUR
}

/**
 * very simple way is to create a VideoStorage that will deploy
 * different compression algorithm based on the video type
 */
class VideoStorage{
    private Compressor compressor;
    private Overlay overlay;
    VideoStorage(Compressor c, Overlay o){
        this.compressor = c;
        this.overlay = o;
    }

    public void setCompressor(Compressor c){
        this.compressor = c;
    }

    public void setOverlay(Overlay o){
        this.overlay = o;
    }

    public void Store(String filename){
        if (this.compressor == Compressor.WEBM){
            System.out.println("Compress using WEBM");
        }
        else if (this.compressor == Compressor.MOV){
            System.out.println("Compress using Mov");
        }
        else if(this.compressor == Compressor.MP4){
            System.out.println("Compress using MP4");
        }

        if (this.overlay == Overlay.BLUR){
            System.out.println("Apply blur overlay");
        }
        else if (this.overlay == Overlay.BLACK_AND_WHITE){
            System.out.println("Apply black and white overlay");
        }
        else if (this.overlay == Overlay.NONE){
            System.out.println("Apply non overlay");
        }
        System.out.println("Storing to file "+filename);
    }
}

/**
 * What is wrong with this design?
 *
 * - It violates the Open/closed Principle: adding new compression algorithms or
 * overlays means that we have to modify the existing VideoStorage class.
 *
 * - Single Responsibility Principle is violated: VideoStorage is responsible for
 * compressing videos, applying overlays, and storing the video. This class will quickly become very bloated with lots of conditionals. Hard to
 * read, hard to maintain – it easily becomes a maintenance nightmare!
 */
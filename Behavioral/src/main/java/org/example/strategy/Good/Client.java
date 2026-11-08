package org.example.strategy.Good;

public class Client {
}

/**
 * compression algorithm
 */
interface Compressor{
    public void compress();
}
class MP4Compressor implements Compressor {
    @Override
    public void compress() {
        System.out.println("MP4 compressor");
    }
}

class WEBMCompressor implements Compressor {
    @Override
    public void compress() {
        System.out.println("WEBM compresor");
    }
}

class MOVCompressor implements Compressor {
    @Override
    public void compress() {
        System.out.println("MOV compressor");
    }
}


/**
 * overlay algorithm
 */
interface Overlay{
    public void apply();
}

class BlurOverlay implements Overlay {

    @Override
    public void apply() {
        System.out.println("Blur Overlay");
    }
}

class BlackAndWhiteOverlay implements Overlay {
    @Override
    public void apply() {
        System.out.println("Black and white overlay");
    }
}

class NoneOverlay implements Overlay {
    @Override
    public void apply() {
        System.out.println("No apply overlay");
    }
}

/**
 * very simple way is to create a VideoStorage that will deploy different compression algorithm based on the video type
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
        this.compressor.compress();
        this.overlay.apply();
        System.out.println("Storing to file "+filename);
    }
}

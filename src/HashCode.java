import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class HashCode {
    static List<Photo> photos = new ArrayList<>();
    static List<Slide> slides = new ArrayList<>();
    static List<Slide> optimizeSlide = new ArrayList<>();

    public static void main (String... args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/input/c_memorable_moments.txt"));
        Decider decider = new Decider();

       // parsing of photos
        int numberOfPhotos = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < numberOfPhotos; i++) {
            String[] photoChars = bufferedReader.readLine().split(" ");
            String charType = photoChars[0];
            int type = 1; //for horizontal photo
            if (charType.equals("V")) type = 2; // for vertical photo
            Photo photo = new Photo(i,type);
            for (int j = 2; j < photoChars.length; j++) {
                photo.tags.add(photoChars[j]);
              }
            photos.add(photo);
            }

         // form slides with photo
        for (Photo currentPhoto: photos)  {
            if (currentPhoto.type == 1) {
                Slide slide = new Slide(currentPhoto);
                slides.add(slide);
            } else {
                if (decider.status == 0) {
                    decider.status = 1;
                    decider.currentPhoto = currentPhoto;
                } else {
                    Slide slide = new Slide(decider.currentPhoto,currentPhoto);
                    slides.add(slide);
                    decider.status = 0;
                }
            }
        }

        //logical sorting of slides
        Slide lastSlide = slides.get(0);
        optimizeSlide.add(lastSlide);
        slides.remove(0);
        while (!slides.isEmpty()) {
            int indexBS =  0;
            int BS = 0;
            for (int i = 0; i < slides.size(); i++) {
                Slide currentSlide = slides.get(i);
                int currentScore = Utils.compare(lastSlide,currentSlide);
                if (currentScore > BS) {
                    indexBS = i;
                    BS = currentScore;
                }
            }
            lastSlide = slides.get(indexBS);
            optimizeSlide.add(lastSlide);
            slides.remove(indexBS);

        }

        // write to file
        FileWriter fileWriter = new FileWriter("c.out");
        fileWriter.write(optimizeSlide.size() + "");
        for (Slide slide: optimizeSlide) {
            fileWriter.write(" \n" + slide.toString() );
        }
        fileWriter.flush();
        fileWriter.close();

    }


}


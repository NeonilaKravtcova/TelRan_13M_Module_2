package de.telran;

import de.telran.entity.Line;
import de.telran.entity.Picture;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.List;

public class ShapeFlow implements ApplicationRunner {

    List<Picture> pictures;
    List<Line> lines;

    public ShapeFlow(List<Picture> pictures, List<Line> lines) {
        this.pictures = pictures;
        this.lines = lines;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        printPictures(pictures);
        printLines(lines);
    }

    public void printPictures(List<Picture> pictures){
        for (Picture picture : pictures) {
            picture.draw();
        }
    }

    public void printLines(List<Line> lines){
        for (Line line : lines) {
            line.draw();
        }
    }
}

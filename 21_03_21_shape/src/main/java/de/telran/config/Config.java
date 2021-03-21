package de.telran.config;

import de.telran.ShapeFlow;
import de.telran.entity.Line;
import de.telran.entity.Picture;
import de.telran.entity.Rectangle;
import de.telran.entity.Shape;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {

    static final String RESET = "\u001B[0m";
    static final String BLACK = "\u001B[30m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String PURPLE = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String BACKGROUND_WHITE = "\u001B[37m";
    static final String BACKGROUND_BLACK = "\u001B[40m";
    static final String BACKGROUND_RED = "\u001B[41m";
    static final String BACKGROUND_GREEN = "\u001B[42m";
    static final String BACKGROUND_BLUE = "\u001B[46m";

    @Bean
    @Qualifier("picture0")
    public Shape line8() {
        return new Line(8, CYAN, RESET, '_');
    }

    @Bean
    @Qualifier("picture0")
    public Shape line10() {
        return new Line(10, BLUE, RESET, '/');
    }

    @Bean
    public Shape line30() {
        return new Line(30, RED, RESET, '\\');
    }

    @Bean
    @Qualifier(value = "picture1")
    public Shape rectangle0() {
        return new Rectangle(3, 4, BACKGROUND_RED, '*');
    }

    @Bean
    @Qualifier("picture1")
    public Shape rectangle1() {
        return new Rectangle(5, 8, BACKGROUND_GREEN, '^');
    }

    @Bean
    @Qualifier("picture1")
    public Shape rectangle2() {
        return new Rectangle(6, 10, BACKGROUND_BLUE, '&');
    }

    @Bean
    public Shape rectangle3() {
        return new Rectangle(10, 30, BACKGROUND_BLACK, ' ');
    }

    @Bean
    @Order(1)
    @Qualifier("picture")
    public Shape picture1(@Qualifier("picture1") List<Shape> shapes) {
        return new Picture("TRI BOGATYRYA", "1898", shapes, '~');
    }

    @Bean
    @Order(0)
    @Qualifier("picture")
    public Shape picture0(@Qualifier("picture0") List<Shape> shapes) {
        return new Picture("Lines", "2020", shapes, '~');
    }

    @Bean
    public List<Shape> shapes2(@Qualifier("picture0") List<Shape> shapes){
        return new ArrayList<>(Arrays.asList(rectangle0(), picture0(shapes), line30()));
    }

    @Bean
    @Qualifier("picture")
    public Shape picture2(Shape rectangle0, Shape picture0, Shape line30, List<Shape> shapes2) {
        return new Picture("COLLAGE", "2020", shapes2, '~');
    }

    @Bean
    @Qualifier("picture")
    public Shape picture3(Shape rectangle3) {
        return new Picture("CHERNIY KVADRAT", "1915", new ArrayList<>(Arrays.asList(rectangle3())), '~');
    }

    @Bean
    public List<Picture> picturesList(@Qualifier("picture") List<Shape> pictures){
        return new ArrayList(Arrays.asList(pictures));
    }

    @Bean
    public List<Line> linesList(){
        return new ArrayList(Arrays.asList(line8(), line10(), line30()));
    }

    @Bean
    public ShapeFlow shapeFlow(List<Picture> picturesList, List<Line> linesList){
        return new ShapeFlow(picturesList, linesList);
    }

}

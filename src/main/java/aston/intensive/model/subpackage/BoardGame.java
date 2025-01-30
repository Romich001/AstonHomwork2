package aston.intensive.model.subpackage;

import aston.intensive.model.TikTokGirl;
import aston.intensive.myLittleSpring.annotations.IntensiveComponent;

@IntensiveComponent
public class BoardGame {

    private final TikTokGirl tikTokGirl;

    public BoardGame(TikTokGirl tikTokGirl) {
        this.tikTokGirl = tikTokGirl;
    }


    public void go() {
        tikTokGirl.run();
        System.out.println("AnotherClass.go() is called");
    }
}

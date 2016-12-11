package xyz.stankovic.lifxcontrol;

import xyz.stankovic.lifxcontrol.api.LifxAPI;
import xyz.stankovic.lifxcontrol.models.Power;
import xyz.stankovic.lifxcontrol.models.SetState;

import java.util.ArrayList;

/**
 * Created by stankovic on 26.11.2016.
 */
public class Fader {

    private static ArrayList<SetState> setStateModels;

    public void start(int minutes) throws Exception {

        LifxAPI lifxAPI = new LifxAPI(
                "cd8f6a2936a618b10dc745286d5a78cd1ed7ef611672f926a82a0b98499a35cb",
                "https://api.lifx.com/v1/lights"
        );

        initSetStateModels(minutes);

        for (SetState setState: setStateModels) {
            synchronized (lifxAPI) {
                lifxAPI.setState(setState);
                System.out.println("Change to color: " + setState.getColor());
            }
            try {
                Thread.sleep(300_000);
            } catch (InterruptedException ex) {
                System.out.println("VERSCHNETZLET");
                Thread.currentThread().interrupt();
            }
        }
    }

    private void initSetStateModels(int minutes) {
        setStateModels = new ArrayList<>();

        String duration = String.valueOf(minutes * 10);

        SetState first = new SetState();
        first.setSelector("all");
        first.setColor("#130069");
        first.setBrightness("0.2");
        first.setPower(Power.ON);
        first.setDuration(duration);
        setStateModels.add(first);

        SetState second = new SetState();
        second.setSelector("all");
        second.setColor("#E89273");
        second.setBrightness("0.4");
        second.setDuration(duration);
        setStateModels.add(second);

        SetState third = new SetState();
        third.setSelector("all");
        third.setColor("#FFB479");
        third.setBrightness("0.6");
        third.setDuration(duration);
        setStateModels.add(third);

        SetState fourth = new SetState();
        fourth.setSelector("all");
        fourth.setColor("#E8D9B6");
        fourth.setBrightness("0.8");
        fourth.setDuration(duration);
        setStateModels.add(fourth);

        SetState fifth = new SetState();
        fifth.setSelector("all");
        fifth.setColor("#FFFDF9");
        fifth.setBrightness("1");
        fifth.setDuration(duration);
        setStateModels.add(fifth);

        SetState sixth = new SetState();
        sixth.setSelector("all");
        sixth.setColorAsKelvin(3500);
        sixth.setBrightness("1");
        sixth.setDuration(duration);
        setStateModels.add(sixth);
    }
}

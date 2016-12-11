package ch;

import org.junit.Test;
import xyz.stankovic.lifxcontrol.api.LifxAPI;

/**
 * Created by nikola on 11.12.16.
 */
public class test {

    @Test
    public void test() throws Exception {
        LifxAPI lifxAPI = new LifxAPI(
                "cd8f6a2936a618b10dc745286d5a78cd1ed7ef611672f926a82a0b98499a35cb",
                "https://api.lifx.com/v1/lights"
        );

        lifxAPI.toggleLight();
        lifxAPI.setDefaultState();


    }
}

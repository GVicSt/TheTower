package io.replay.thetower.managers;

import io.replay.thetower.elements.Floor;

public class LevelManager {

    private Floor floor = new Floor();

    public void setLevel(int id){
        floor.setID(id);
        floor.load();
    }

    public Floor getFloor() {
        return floor;
    }

}

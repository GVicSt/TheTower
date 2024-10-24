package io.replay.thetower.scripts;

import jpize.app.Jpize;
import jpize.glfw.input.Key;
import jpize.util.camera.OrthographicCameraCentered;
import jpize.util.math.vector.Vec2f;

public class Controlls {

    Vec2f move = new Vec2f();
    Vec2f[] move_buffer = new Vec2f[2];

    public Vec2f getMove(){
        move.set(((Key.D.pressed() ? 1 : 0) + (Key.A.pressed()?-1:0)), ((Key.W.pressed() ? 1 : 0) + (Key.S.pressed()?-1:0)));
        return move.nor().mul(Jpize.getDT()*(Key.LSHIFT.pressed()?128:64));
    }

    public Vec2f[] getMoveBuffer(){
        return move_buffer;
    }
}

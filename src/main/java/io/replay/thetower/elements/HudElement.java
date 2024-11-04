package io.replay.thetower.elements;

import jpize.util.math.vector.Vec2f;

public interface HudElement {
    void draw();

    void setPosition(Vec2f position);
}

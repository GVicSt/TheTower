package io.replay.thetower.managers;

import jpize.util.Disposable;

public abstract class IScreen implements Disposable {

    private final String ID;
    private boolean initialized;
    private boolean isLoaded;

    public IScreen(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    protected boolean isInitialized() {
        return initialized;
    }

    protected void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }


    public void init() { }

    public void update() { }

    public void render() { }

    public void show() { }

    public void hide() { }

    public void resize(int width, int height) { }

    @Override
    public void dispose() { }

    public void load() { }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }
}

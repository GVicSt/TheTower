package io.replay.thetower.managers;

import io.replay.thetower.elements.Tile;
import jpize.util.Disposable;

public class TileManager implements Disposable {

    static class Tiles {
        int id;
        Tile tile;

        public Tiles(int id, Tile tile){
            this.id = id;
            this.tile = tile;
        }
    }

    private final Tiles[] tiles;

    public TileManager(){
        this.tiles = new Tiles[]{
                new Tiles(0, new Tile("/tiles/bottom.png")),
                new Tiles(1, new Tile("/tiles/floor0.png")),
                new Tiles(16, new Tile("/tiles/wall0.png")),
                new Tiles(17, new Tile("/tiles/wall1.png")),
                new Tiles(24, new Tile("/tiles/wall7.png")),
                new Tiles(32, new Tile("/tiles/deco0.png")),
                new Tiles(33, new Tile("/tiles/deco1.png")),
        };
    }

    public Tile getTile(int id){
        for (Tiles tile_curr : tiles)
            if (tile_curr.id == id)
                return tile_curr.tile;
        return null;
    }

    @Override
    public void dispose() {
        for (Tiles tile : tiles) {
            tile.tile.dispose();
        }
    }

}
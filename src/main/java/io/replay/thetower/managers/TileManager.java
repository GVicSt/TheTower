package io.replay.thetower.managers;

import io.replay.thetower.elements.Tile;
import jpize.util.Disposable;

public class TileManager implements Disposable {

    static class IdTile {
        int id;
        Tile tile;

        public IdTile(int id, Tile tile){
            this.id = id;
            this.tile = tile;
        }
    }


    private IdTile[] idTile;

    public void init(){
        idTile = new IdTile[7];
        idTile[0]=new IdTile(0, new Tile("/tiles/bottom.png"));
        idTile[1]=new IdTile(1, new Tile("/tiles/floor0.png"));
        idTile[2]=new IdTile(16,new Tile("/tiles/wall0.png"));
        idTile[3]=new IdTile(17,new Tile("/tiles/wall1.png"));
        idTile[4]=new IdTile(24,new Tile("/tiles/wall7.png"));
        idTile[5]=new IdTile(32,new Tile("/tiles/deco0.png"));
        idTile[6]=new IdTile(33,new Tile("/tiles/deco1.png"));
    }

    public Tile getTile(int id){
        for (IdTile idTile_curr : idTile)
            if (idTile_curr.id == id)
                return idTile_curr.tile;
        return null;
    }

    @Override
    public void dispose() {
        for (IdTile tile : idTile) {
            tile.tile.dispose();
        }
    }

}
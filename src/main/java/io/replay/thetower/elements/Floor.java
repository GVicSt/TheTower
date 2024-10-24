package io.replay.thetower.elements;

import io.replay.thetower.managers.TileManager;
import jpize.gl.texture.Texture2D;
import jpize.gl.texture.TextureBatch;
import jpize.util.Disposable;
import jpize.util.math.vector.Vec2f;
import jpize.util.math.vector.Vec2i;
import jpize.util.pixmap.PixmapIO;
import jpize.util.pixmap.PixmapRGBA;

public class Floor implements Disposable {

    private int[][] level_floor_map;
    private int[][] level_wall_map;
    private int[][] level_deco_map;

    private final TileManager tileManager = new TileManager();

    private int floor_id;


    public void load(){
        System.out.println("[DEB] Level "+floor_id);
        tileManager.init();

        level_floor_map = fillLevelTiles("floor");
        level_deco_map = fillLevelTiles("deco");
        level_wall_map = fillLevelTiles("walls");

    }

    public void render(TextureBatch batch, Vec2f pos){
        float player_x = pos.x;
        float player_y = pos.y;
        drawLevelTiles(batch, level_floor_map, player_x, player_y);
        drawLevelTiles(batch, level_deco_map, player_x, player_y);
        drawLevelTiles(batch, level_wall_map, player_x, player_y);
    }

    private void drawLevelTiles(TextureBatch batch, int[][] level_map, float player_x, float player_y) {
        for (int x = (int)(player_x/16f)-17; x < (int)(player_x/16f)+17; x++) {
            for (int y = (int)(player_y/16f)-11; y < (int)(player_y/16f)+11; y++) {
                if (x>=0 && x<80 && y>=0 && y<80)
                    if(player_x>x*16-264 && player_x<x*16+264 && player_y>y*16-167 && player_y<y*16+167) {
                        Tile level_wall_tile = tileManager.getTile(level_map[x][y]);
                        batch.draw(level_wall_tile.getTexture2D(), x * 16, y * 16, level_wall_tile.getTileSizeX(), level_wall_tile.getTileSizeY());
                    }
            }
        }
    }

    private int[][] fillLevelTiles(String map){
        Texture2D level_tex = new Texture2D("/floors/level_"+map+"-" + floor_id + ".png");
        Vec2i level_vec = new Vec2i(level_tex.getWidth(), level_tex.getHeight());
        int[][] level_map = new int[level_vec.x][level_vec.y];
        PixmapRGBA level_img = PixmapIO.load("/floors/level_"+map+"-" + floor_id + ".png");

        for (int x = 0; x < level_vec.x; x++) {
            for (int y = 0; y < level_vec.y; y++) {
                level_map[x][level_vec.y-(y+1)] = (int)(level_img.getPixelColor(x,y).b*255);
            }
        }
        return level_map;
    }

    @Override
    public void dispose() {
        tileManager.dispose();
        System.out.println("[DIS] floor");
    }

    public void setID(int floor_id) {
        this.floor_id = floor_id;
    }
}
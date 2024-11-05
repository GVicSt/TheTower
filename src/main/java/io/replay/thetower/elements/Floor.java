package io.replay.thetower.elements;

import io.replay.thetower.managers.TileManager;
import jpize.gl.texture.Texture2D;
import jpize.util.Disposable;
import jpize.util.camera.Camera2D;
import jpize.util.math.Maths;
import jpize.util.math.vector.Vec2i;
import jpize.util.mesh.TextureBatch;
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

        level_floor_map = fillLevelTiles("floor");
        level_deco_map = fillLevelTiles("deco");
        level_wall_map = fillLevelTiles("walls");
    }

    public void render(TextureBatch batch, Camera2D camera){
        drawLevelTiles(batch, level_floor_map, camera);
        drawLevelTiles(batch, level_deco_map, camera);
        drawLevelTiles(batch, level_wall_map, camera);
    }

    private void drawLevelTiles(TextureBatch batch, int[][] level_map, Camera2D camera) {
        // camera-adaptive tile-draw area
        final int startX = Maths.floor((camera.position().x - camera.getWidth()  * 0.5f / camera.getScale()) / 16f);
        final int startY = Maths.floor((camera.position().y - camera.getHeight() * 0.5f / camera.getScale()) / 16f);
        final int endX    = Maths.ceil((camera.position().x + camera.getWidth()  * 0.5f / camera.getScale()) / 16f);
        final int endY    = Maths.ceil((camera.position().y + camera.getHeight() * 0.5f / camera.getScale()) / 16f);

        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                if (x>=0 && x<80 && y>=0 && y<80) {
                    Tile level_tile = tileManager.getTile(level_map[x][y]);
                    batch.draw(level_tile.getTexture2D(), x * 16, y * 16, level_tile.getTileSizeX(), level_tile.getTileSizeY());
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

    public void setID(int floor_id) {
        this.floor_id = floor_id;
    }

    @Override
    public void dispose() {
        tileManager.dispose();
        System.out.println("[DIS] floor");
    }

}
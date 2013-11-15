package com.dejavu.tdarcade;

import java.util.ArrayList;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class BlockMap implements TileBasedMap {
	public static TiledMap tmap;
	public static int mapWidth;
	public static int mapHeight;
	public static int mapSize;
	public static int blockingLayerId = 0;
	private int square[] = { 1, 1, 15, 1, 15, 15, 1, 15 };
	public static ArrayList<Object> entities;

	public BlockMap(String ref) throws SlickException {
		entities = new ArrayList<Object>();
		tmap = new TiledMap(ref, "data/levels");
		mapWidth = tmap.getWidth() * tmap.getTileWidth();
		mapHeight = tmap.getHeight() * tmap.getTileHeight();
		mapSize = mapWidth * mapHeight;

		for (int x = 0; x < tmap.getWidth(); x++) {
			System.out.println("");
			for (int y = 0; y < tmap.getHeight(); y++) {
				int tileID = tmap.getTileId(x, y, 0);
				if (tileID == 1) {
					//System.out.print("("+(x*15)+","+);
					entities.add(new Block(x * 15, y * 15, square, "sqaure"));
				}
				else {
					System.out.print("0");
				}
			}
		}
	}

	@Override
	public boolean blocked(PathFindingContext ctx, int x, int y) {
		int tileID = tmap.getTileId(x, y, 0);
		return tileID == 1;
	}

	@Override
	public float getCost(PathFindingContext arg0, int arg1, int arg2) {
		return 0;
	}

	@Override
	public int getHeightInTiles() {
		return tmap.getHeight();
	}

	@Override
	public int getWidthInTiles() {
		return tmap.getWidth();
	}

	@Override
	public void pathFinderVisited(int arg0, int arg1) {

	}

	public int getTileId(int x, int y, int i) {
		return tmap.getTileId(x, y, i);

	}
}
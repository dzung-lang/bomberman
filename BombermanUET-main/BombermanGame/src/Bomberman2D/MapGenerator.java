package Bomberman2D;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapGenerator {
    GameWindow gw;
    public int mapTileNum[][][];
    public MapGenerator(GameWindow gw) {
        this.gw = gw;
        mapTileNum = new int[gw.maxMap][gw.maxCol][gw.maxRow];
        loadMap("/maps/map1temp.txt",0);
        loadMap("/maps/map2temp.txt",1);
        loadMap("/maps/map3.txt",2);
    }
    public void loadMap(String path, int map) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while(col < gw.maxCol && row < gw.maxRow) {
                String s = br.readLine();
                while(col < gw.maxCol) {
                    String number[] = s.split(" ");
                    int num = Integer.parseInt(number[col]);
                    mapTileNum[map][col][row] = num;
                    col++;
                }
                if(col == gw.maxCol) {
                    col = 0;
                    row++;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

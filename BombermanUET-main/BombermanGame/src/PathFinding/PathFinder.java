package PathFinding;

import Bomberman2D.GameWindow;

import java.util.ArrayList;

public class PathFinder {
    GameWindow gw;
    Node[][] node;
    public ArrayList<Node> openList = new ArrayList<>();
    public ArrayList<Node> pathList = new ArrayList<>(1000);
    Node startNode, goalNode, currentNode;
    boolean goalReached = false;
    int step = 0;

    public PathFinder(GameWindow gw) {
        this.gw = gw;
        instantiateNodes();
    }
    public void instantiateNodes() {
        node = new Node[gw.maxCol][gw.maxRow];
        int col = 0, row = 0;
        while(col < gw.maxCol && row < gw.maxRow) {
            node[col][row] = new Node(col,row);
            col++;
            if(col == gw.maxCol) {
                col = 0;
                row ++;
            }
        }
    }
    public void resetNode() {
        int col = 0, row = 0;
        while(col < gw.maxCol && row < gw.maxRow) {
            node[col][row].checked = false;
            node[col][row].solid = false;
            node[col][row].open = false;
            col++;
            if(col == gw.maxCol) {
                col = 0;
                row++;
            }
        }
        openList.clear();
        pathList.clear();
        goalReached = false;
        step = 0;
    }
    public void setNode(int startCol, int startRow, int goalCol, int goalRow) {
        try {
        resetNode();

        startNode = node[startCol][startRow];
        currentNode = startNode;
        goalNode = node[goalCol][goalRow];
        openList.add(currentNode);

        int col = 0, row = 0;
        //Check iTile
            while (col < gw.maxCol && row < gw.maxRow) {
                int tileNum = row * gw.maxCol + col;
                if (gw.tileM.mapTileNum[gw.currentMap][col][row] != 0) {
                    node[col][row].solid = true;
                }
                getCost(node[col][row]);
                col++;
                if (col == gw.maxCol) {
                    col = 0;
                    row++;
                }
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {

        }
    }
    public void getCost(Node node) {
        int xDis = Math.abs(node.col - startNode.col);
        int yDis = Math.abs(node.row - startNode.row);
        node.gCost = xDis + yDis;
        xDis = Math.abs(node.col - goalNode.col);
        yDis = Math.abs(node.row - goalNode.row);
        node.hCost = xDis + yDis;
        node.fCost = node.hCost + node.gCost;
    }
    public boolean search() {
        while(!goalReached && step < 500) {
            int col = currentNode.col;
            int row = currentNode.row;
            //Check curNode
            currentNode.checked = true;
            openList.remove(currentNode);
            int[] dx = {0,-1,1,0};
            int[] dy = {-1,0,0,1};

            for(int i = 0; i < 4; i++) {
                int drow = row + dy[i];
                int dcol = col + dx[i];
                if(dcol >= 0 && dcol < gw.maxCol && drow >= 0 && drow < gw.maxRow) {
                    openNode(node[dcol][drow]);
                }
            }
            int bestNodeIdx = 0;
            int bestFCost = 999;
            for(int i = 0; i<openList.size();i++) {
                if(openList.get(i).fCost < bestFCost) {
                    bestFCost = openList.get(i).fCost;
                    bestNodeIdx = i;
                }
                else if(openList.get(i).fCost == bestFCost) {
                    if(openList.get(i).gCost < openList.get(bestNodeIdx).gCost) {
                        bestNodeIdx = i;
                    }
                }
            }
            if(openList.size() == 0) {
                break;
            }
            currentNode = openList.get(bestNodeIdx);
            if(currentNode == goalNode) {
                goalReached = true;
                trackThePath();
            }
            step++;
        }
        return goalReached;
    }
    public boolean searchPass() {
        while(!goalReached && step < 500) {
            int col = currentNode.col;
            int row = currentNode.row;
            //Check curNode
            currentNode.checked = true;
            openList.remove(currentNode);
            int[] dx = {0,-1,1,0};
            int[] dy = {-1,0,0,1};

            for(int i = 0; i < 4; i++) {
                int drow = row + dy[i];
                int dcol = col + dx[i];
                if(dcol >= 0 && dcol < gw.maxCol && drow >= 0 && drow < gw.maxRow) {
                    openNodePass(node[dcol][drow]);
                }
            }
            int bestNodeIdx = 0;
            int bestFCost = 999;
            for(int i = 0; i<openList.size();i++) {
                if(openList.get(i).fCost < bestFCost) {
                    bestFCost = openList.get(i).fCost;
                    bestNodeIdx = i;
                }
                else if(openList.get(i).fCost == bestFCost) {
                    if(openList.get(i).gCost < openList.get(bestNodeIdx).gCost) {
                        bestNodeIdx = i;
                    }
                }
            }
            if(openList.size() == 0) {
                break;
            }
            currentNode = openList.get(bestNodeIdx);
            if(currentNode == goalNode) {
                goalReached = true;
                trackThePath();
            }
            step++;
        }
        return goalReached;
    }
    public void openNode(Node node) {
        if(node.open == false && node.checked == false && node.solid == false) {
            node.open = true;
            node.parent = currentNode;
            openList.add(node);
        }
    }
    public void openNodePass(Node node) {
        if(node.open == false && node.checked == false
                && gw.tileM.mapTileNum[gw.currentMap][node.col][node.row] != 1
                && gw.tileM.mapTileNum[gw.currentMap][node.col][node.row] != 3) {
            node.open = true;
            node.parent = currentNode;
            openList.add(node);
        }
    }
    public void trackThePath() {
        Node cur = goalNode;
        while(cur != startNode) {
            pathList.add(0,cur);
            cur = cur.parent;
        }
    }
}

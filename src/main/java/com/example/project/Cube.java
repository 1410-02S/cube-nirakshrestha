import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cube{

    String[][] cube = {{
        "r","r","r",
        "r","r","r",
        "r","r","r"},{
            "b","b","b",
            "b","b","b",
            "b","b","b"},{
                "o","o","o",
                "o","o","o",
                "o","o","o"},{
                    "g","g","g",
                    "g","g","g",
                    "g","g","g"},{
                        "y","y","y",
                        "y","y","y",
                        "y","y","y"},{
                            "w","w","w",
                            "w","w","w",
                            "w","w","w"}
    };

    class edgedFace{
    public int current_face;
    int[] edge1 = new int[4];
    int[] edge2 = new int[4];
    int[] edge3 = new int[4];
    int[] edge4 = new int[4];

        public edgedFace(int face){
            current_face = face;
            switch(face){
                case 0://R is done
                edge1[0] = 1;// four straight vertically blue
                edge1[1] = 2;// 2 5 8 are adjacent to red
                edge1[2] = 5;
                edge1[3] = 8;


                edge2[0] = 4;// yellow
                edge2[1] = 2;//258 are adjacent to red as well
                edge2[2] = 5;
                edge2[3] = 8;

                edge3[0] = 3;// green
                edge3[1] = 0;// adjeacent to red
                edge3[2] = 3;
                edge3[3] = 6;

                edge4[0] = 5; //white
                edge4[1] = 2;// adjacent to red
                edge4[2] = 5;
                edge4[3] = 8;

                break;
                case 1://U
                edge1[0] = 1;// four straight horizontally blue
                edge1[1] = 0;// 2 5 8 are adjacent to yellow
                edge1[2] = 1;
                edge1[3] = 2;


                edge2[0] = 0;// red
                edge2[1] = 0;//258 are adjacent to yellow as well
                edge2[2] = 1;
                edge2[3] = 2;

                edge3[0] = 3;// green
                edge3[1] = 0;// adjeacent to yellow
                edge3[2] = 1;
                edge3[3] = 2;

                edge4[0] = 2; //orange
                edge4[1] = 0;// adjacent to yelow
                edge4[2] = 1;
                edge4[3] = 2;
                break;

                case 2://D
                edge1[0] = 1;// blue
                edge1[1] = 6;// adjacent to white
                edge1[2] = 7;
                edge1[3] = 8;


                edge2[0] = 2;// orange
                edge2[1] = 6;//adjacent to white
                edge2[2] = 7;
                edge2[3] = 8;

                edge3[0] = 3;// green
                edge3[1] = 6;// adjeacent to white
                edge3[2] = 7;
                edge3[3] = 8;

                edge4[0] = 0; //red
                edge4[1] = 6;// adjacent to white
                edge4[2] = 7;
                edge4[3] = 8;
                break;

                case 3://L
                edge1[0] = 1;// four straight vertically blue
                edge1[1] = 0;// adjacent to oragne
                edge1[2] = 3;
                edge1[3] = 6;


                edge2[0] = 5;// white
                edge2[1] = 0;//adjacent to orange
                edge2[2] = 3;
                edge2[3] = 6;

                edge3[0] = 3;// green
                edge3[1] = 3;// adjeacent to oragne
                edge3[2] = 5;
                edge3[3] = 8;

                edge4[0] = 4; //yellow
                edge4[1] = 0;// adjacent to orange
                edge4[2] = 3;
                edge4[3] = 6;
                break;

                case 4://F
                edge1[0] = 4;// yellow
                edge1[1] = 6;// adj to blue
                edge1[2] = 7;
                edge1[3] = 8;


                edge2[0] = 0;// red
                edge2[1] = 0;//adj to blue
                edge2[2] = 3;
                edge2[3] = 6;

                edge3[0] = 5;// white
                edge3[1] = 0;// adjeacent to blue
                edge3[2] = 1;
                edge3[3] = 2;

                edge4[0] = 2; //orange
                edge4[1] = 2;// adjacent to blue
                edge4[2] = 5;
                edge4[3] = 8;
                break;

                case 5://B
                edge1[0] = 4;// yellow
                edge1[1] = 0;// adj to green
                edge1[2] = 1;
                edge1[3] = 2;


                edge2[0] = 2;// orange
                edge2[1] = 0;//adj to green
                edge2[2] = 3;
                edge2[3] = 6;

                edge3[0] = 5;// white
                edge3[1] = 6;// adjeacent to green
                edge3[2] = 7;
                edge3[3] = 8;

                edge4[0] = 0; //red
                edge4[1] = 2;// adjacent to green
                edge4[2] = 5;
                edge4[3] = 8;
                break;
            }
        }
    
     }

     public void turnFace(int index, String direction){
        edgedFace eFace = new edgedFace(index);
        String[][] copy = new String[6][9];

        for( int i = 0; i<6; i++){
            for (int j = 0; j<9; j++){
                copy[i][j]= cube [i][j];
            }
        }

        switch(direction){
            case "c":
            cube[eFace.current_face][0] = copy[eFace.current_face][2];// when we turn blue cockwise the plalcement for red changes form 0 to2 1 to 5 etc
            cube[eFace.current_face][1] = copy[eFace.current_face][5];
            cube[eFace.current_face][2] = copy[eFace.current_face][8];
            cube[eFace.current_face][3] = copy[eFace.current_face][1];
            cube[eFace.current_face][5] = copy[eFace.current_face][7];
            cube[eFace.current_face][6] = copy[eFace.current_face][0];
            cube[eFace.current_face][7] = copy[eFace.current_face][3];
            cube[eFace.current_face][8] = copy[eFace.current_face][6];
//edge 1 is blue whenwe go c it  is replaced by white which is edge 4
            cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
            cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
            cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

            //edge 2 is yellow whenwe go c it is replaced by blue which is edge 1
            cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
            cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
            cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];
            //edge 3 is green whenwe go c it is replaced by yellow edge 2
            cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
            cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
            cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

            //edge 4 is white which is replaced by green edge 3
            cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
            cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
            cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];
            break;
            case "cc":
            // when we turn blue ccockwise the plalcement for red changes form 0 to6 1 to 3 etc exactly opposite array position of clockwise
            cube[eFace.current_face][0] = copy[eFace.current_face][6];
            cube[eFace.current_face][1] = copy[eFace.current_face][3];
            cube[eFace.current_face][2] = copy[eFace.current_face][0];
            cube[eFace.current_face][3] = copy[eFace.current_face][7];
            cube[eFace.current_face][5] = copy[eFace.current_face][1];
            cube[eFace.current_face][6] = copy[eFace.current_face][8];
            cube[eFace.current_face][7] = copy[eFace.current_face][5];
            cube[eFace.current_face][8] = copy[eFace.current_face][2];
//edge 1 is blue whenwe go cc it  is replaced by yellow which is edge 2
            cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
            cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
            cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

            //edge 2 is yellow whenwe go cc it is replaced by green  which is edge 3
            cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
            cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
            cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];
            //edge 3 is green whenwe go cc it is replaced by white edge 4
            cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
            cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
            cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

            //edge 4 is white which is replaced by blue edge 1
            cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
            cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
            cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];
            break;
        }
     }
    public void showCube(){
    int ind = 0;
    for (int x = 0; x<6; x++){
        for (int y = 0; y<3; y++){
            for (int z = 0; z<3; z++){
                System.out.print(cube[x][ind++]);
            }
            System.out.println();
        }
        ind = 0;
        System.out.println();
    }
   }
    public static void main(String[] args)
        throws IOException {
        
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Cube RubiksCube = new Cube();

            boolean argsCheck = false;
            int argsRunIndex = 0;
            if(args.length > 0){
                argsCheck = true;
            }
            boolean proceed = true;
            while (proceed){
                String input;

                if(!argsCheck){
                    input = reader.readLine();
                }else{
                    if (argsRunIndex == args.length){
                        argsCheck = false;
                        input = "s";
                    }else{
                        input = args[argsRunIndex];
                        argsRunIndex++;
                    }
                }
                switch(input){
                    case "u":
                    RubiksCube.turnFace(1, "c");    
                     RubiksCube.showCube();
                    break;
                    case "d":
                    RubiksCube.turnFace(2, "c");    
                     RubiksCube.showCube();
                    break;
                    case "r":
                    RubiksCube.turnFace(0, "c");    
                    RubiksCube.showCube();
                    break;
                    case "l":
                    RubiksCube.turnFace(3, "c");    
                     RubiksCube.showCube();
                    break;
                    case "f":
                    RubiksCube.turnFace(4, "c");    
                     RubiksCube.showCube();
                    break;
                    case "b":
                    RubiksCube.turnFace(5, "c");    
                     RubiksCube.showCube();
                    break;
                    case "u'":
                    RubiksCube.turnFace(1, "cc");    
                     RubiksCube.showCube();
                    break;
                    case "d'":
                    break;
                    case "r'":
                    RubiksCube.turnFace(0, "cc");    
                    RubiksCube.showCube();
                    break;
                    case "l'":
                    RubiksCube.turnFace(3, "cc");    
                     RubiksCube.showCube();
                    break;
                    case "f'":
                    RubiksCube.turnFace(4, "cc");    
                     RubiksCube.showCube();
                    break;
                    case "b'":
                    RubiksCube.turnFace(5, "cc");    
                     RubiksCube.showCube();
                    break;
                    case "s":
                    break;
                    case "q":
                    proceed = false;
                    break;
                }
            }
    }
}
import TSP.*;


import java.awt.Color;
import java.util.Arrays;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;

import org.knowm.xchart.style.markers.SeriesMarkers;

public class Main {
    
    public static void paint(){
        System.out.println("hey");
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        CityRecorder case1 = new CityRecorder();
        
        City city1 = new City(65, 201, 'A');
        City city2 = new City(189, 222, 'B');
        City city3 = new City(81, 177, 'C');
        City city4 = new City(141, 10, 'D');
        City city5 = new City(129, 166, 'E');
        City city6 = new City(125, 162, 'F');
        City city7 = new City(201, 160, 'G');
        City city8 = new City(145, 110, 'H');
        City city9 = new City(43, 200, 'I');
        City city10 = new City(160, 26, 'J');
        City city11 = new City(11, 1, 'K');
        City city12 = new City(199, 200, 'L');
        City city13 = new City(17, 88, 'M');
        City city14 = new City(64, 96, 'N');
        City city15 = new City(44, 183, 'Ñ'); 
        City city16 = new City(151 , 26 , 'O');
        City city17 = new City(9  , 123  , 'P');
        City city18 = new City(72  , 152  , 'Q');
        City city19 = new City(100 , 87 , 'R');
        City city20 = new City(116 , 96, 'S');
        City city21 = new City(54 , 4, 'T');
        City city22 = new City(46 , 26, 'U');
        City city23 = new City(16 , 1, 'V');
        City city24 = new City(199, 163 , 'W');
        City city25 = new City(122 , 88, 'X');
        City city26 = new City(148 , 96, 'Y');
        City city27 = new City(44, 153 , 'Z');          
        City city28 = new City(102  , 26, '1');
        City city29 = new City(169 , 105 , '2');
        City city30 = new City(46 , 68 , '3');
        City city31 = new City(17, 141 , '4');
        City city32 = new City(16 , 125, '5');
        City city33 = new City(117  , 183, '6');      
        City city34 = new City(106   , 182  , '7');
        City city35 = new City(162  , 53 , '8');
        City city36 = new City(158  , 4  , '9');



        case1.addCity(city1);
        case1.addCity(city2);
        case1.addCity(city3);
        case1.addCity(city4);
        case1.addCity(city5);
        case1.addCity(city6);
        case1.addCity(city7);
        case1.addCity(city8);
        case1.addCity(city9);
        case1.addCity(city10);
        case1.addCity(city11);
        case1.addCity(city12);
        case1.addCity(city13);
        case1.addCity(city14);
        case1.addCity(city15);
        case1.addCity(city16);
        case1.addCity(city17);
        case1.addCity(city18);
        case1.addCity(city19);
        case1.addCity(city20);
        case1.addCity(city21);
        case1.addCity(city22);
        case1.addCity(city23);
        case1.addCity(city24);
        case1.addCity(city25);
        case1.addCity(city26);
        case1.addCity(city27);
        case1.addCity(city28);
        case1.addCity(city29);
        case1.addCity(city30);
        case1.addCity(city31);
        case1.addCity(city32);
        case1.addCity(city33);
        case1.addCity(city34);
        case1.addCity(city35);
        case1.addCity(city36);

        
        //case1.setBaseCity(city5);


/*
        Route r2 = new Route(case1);
        r2.paint(-20,250,-20,250,false,150);
        System.out.println(r2.getDistance());
        
        
        SA a2 = new SA(1000000, 0.00003);
        a2.solve(case1);
        r2 =a2.getBestRoute();
        System.out.println(r2.getDistance());

        r2.paint(-20,250,-20,250,false,150);*/

        
        
        NN a2 = new NN();
        a2.solve(case1);
        
        
        
        
            //System.out.println("best: "+best);


        
        
        
        
        // Show it

        

    }
    
    public static void sleep(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }    
                
    }
   
}

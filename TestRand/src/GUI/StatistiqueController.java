/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.NumberAxisBuilder;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Aziz
 */
public class StatistiqueController implements Initializable {
    //ObservableList<PieChart.Data> pieChart = FXCollections.observableArrayList();

    @FXML
    private ImageView cover;
    @FXML
    private Label titre;
    @FXML
    private Label slogan;
    @FXML
    private ListView<?> view;
    @FXML
    private TitledPane t1;
    //PieChart pieChart = createPieChart();
    @FXML
    private StackedAreaChart<Integer, Integer> stackedAreaChart;
    @FXML
    private TitledPane t2;
    @FXML
    private BarChart<Integer, Integer> barChart;
    @FXML
    private TitledPane t31;
    @FXML
    private PieChart pieChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //createStackedChart();
        // TODO
        stackedAreaChart.setData(createStackedChart());
        barChart.setData(createBarChart());
        //lineChart.setData(createLineChart());
        pieChart.setData(createPieChart());
    }    
    
    
    @FXML
    public ObservableList<StackedAreaChart.Series<Integer,Integer>> createStackedChart() {
        NumberAxis xAxis = NumberAxisBuilder.create()
                .label("Temps en jours")
                .lowerBound(1.0d)
                .upperBound(9.0d)
                .tickUnit(2.0d).build();

        NumberAxis yAxis = NumberAxisBuilder.create()
                .label("Quantité")
                .lowerBound(0.0d)
                .upperBound(30.0d)
                .tickUnit(2.0d).build();

        ObservableList<StackedAreaChart.Series<Integer,Integer>> areaChartData = FXCollections.observableArrayList(
                new StackedAreaChart.Series("Avant", FXCollections.observableArrayList(
                        new StackedAreaChart.Data(0, 4),
                        new StackedAreaChart.Data(2, 5),
                        new StackedAreaChart.Data(4, 4),
                        new StackedAreaChart.Data(6, 2),
                        new StackedAreaChart.Data(8, 6),
                        new StackedAreaChart.Data(10, 8)
                )),
                new StackedAreaChart.Series("Au cours", FXCollections.observableArrayList(
                        new StackedAreaChart.Data(0, 8),
                        new StackedAreaChart.Data(2, 2),
                        new StackedAreaChart.Data(4, 9),
                        new StackedAreaChart.Data(6, 7),
                        new StackedAreaChart.Data(8, 5),
                        new StackedAreaChart.Data(10, 7)
                )),
                new StackedAreaChart.Series("Après", FXCollections.observableArrayList(
                        new StackedAreaChart.Data(0, 2),
                        new StackedAreaChart.Data(2, 5),
                        new StackedAreaChart.Data(4, 8),
                        new StackedAreaChart.Data(6, 6),
                        new StackedAreaChart.Data(8, 9),
                        new StackedAreaChart.Data(10, 7)
                ))
        );
        return areaChartData;
    }
    
    public ObservableList<BarChart.Series<Integer,Integer>> createBarChart(){
         String[] years = {"Juin", "Jouillet", "Aout"};
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));
        NumberAxis yAxis = new NumberAxis("Nbre des propriétées", 0.0d, 3000.0d, 1000.0d);
        
        ObservableList<BarChart.Series<Integer, Integer>> barChartData = FXCollections.observableArrayList(
            new BarChart.Series("Restaurant", FXCollections.observableArrayList(
               new BarChart.Data(years[0], 567d),
               new BarChart.Data(years[1], 1292d),
               new BarChart.Data(years[2], 1292d)
            )),
            new BarChart.Series("Salon de thé", FXCollections.observableArrayList(
               new BarChart.Data(years[0], 956),
               new BarChart.Data(years[1], 1665),
               new BarChart.Data(years[2], 2559)
            )),
            new BarChart.Series("Boutique", FXCollections.observableArrayList(
               new BarChart.Data(years[0], 1154),
               new BarChart.Data(years[1], 1927),
               new BarChart.Data(years[2], 2774)
            ))
        );
        return barChartData;
    }
    
    @FXML
    public ObservableList<PieChart.Data> createPieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
             new PieChart.Data("H&M", 20),
             new PieChart.Data("Blue Islend", 12),
             new PieChart.Data("Celio", 25),
             new PieChart.Data("Bershka", 22),
             new PieChart.Data("Zara", 30)
         );
        return pieChartData;
    }
    
    
    
    
    
    /*@FXML
    private ObservableList<LineChart.Series<Double,Double>> createLineChart() {
       NumberAxis xAxis = new NumberAxis("Semaine", 0, 3, 1);
        NumberAxis yAxis = new NumberAxis("Nbre d'annances ajoutée", 0, 3, 1);
        ObservableList<LineChart.Series<Double,Double>> lineChartData = FXCollections.observableArrayList(
            new LineChart.Series<Double,Double>("Bershka", FXCollections.observableArrayList(
                new LineChart.Data<Double,Double>(0.0, 1.0),
                new LineChart.Data<Double,Double>(1.2, 1.4),
                new LineChart.Data<Double,Double>(2.2, 1.9),
                new LineChart.Data<Double,Double>(2.7, 2.3),
                new LineChart.Data<Double,Double>(2.9, 0.5)
            )),
            new LineChart.Series<Double,Double>("Zara", FXCollections.observableArrayList(
                new LineChart.Data<Double,Double>(0.0, 1.6),
                new LineChart.Data<Double,Double>(0.8, 0.4),
                new LineChart.Data<Double,Double>(1.4, 2.9),
                new LineChart.Data<Double,Double>(2.1, 1.3),
                new LineChart.Data<Double,Double>(2.6, 0.9)
            ))
        );
        return lineChartData;
    }*/
    
    
    
    
    /*public PieChart createPieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
             new PieChart.Data("H&M", 20),
             new PieChart.Data("Blue Islend", 12),
             new PieChart.Data("Celio", 25),
             new PieChart.Data("Bershka", 22),
             new PieChart.Data("Zara", 30)
         );
        return new PieChart(pieChartData);
    }*/

    /*@FXML
    private void createPieChart(MouseEvent event) {
    }*/
    
}

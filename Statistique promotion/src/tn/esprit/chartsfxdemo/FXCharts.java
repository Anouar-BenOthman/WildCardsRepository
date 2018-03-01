/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.chartsfxdemo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.NumberAxisBuilder;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author damine
 */
public class FXCharts extends Application {

    private void init(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root,500,530);
        primaryStage.setScene(scene);

        StackedAreaChart stackedAreaChart = createStackedChart();
        BarChart barChart = createBarChart();
        LineChart lineChart = createLineChart();
        PieChart pieChart = createPieChart();
        ScatterChart scatterChart = createScatterChart();
        
        TitledPane t1 = new TitledPane("Taux d'achats avant, au cours et après les promotions", stackedAreaChart);
        TitledPane t2 = new TitledPane("Taux d'utilisation de l'option promotion", barChart);
        TitledPane t3 = new TitledPane("Top utilisateurs de l'option promotion", lineChart);
        TitledPane t4 = new TitledPane("Promotions sur differents marques", pieChart);
        TitledPane t5 = new TitledPane("Nombre de promotions ajouter dans une semaine pour un shop", scatterChart);


        Accordion accordion = new Accordion();
        accordion.getPanes().add(t1);
        accordion.getPanes().add(t2);
        accordion.getPanes().add(t3);
        accordion.getPanes().add(t4);
        accordion.getPanes().add(t5);
        root.getChildren().add(accordion);
    }

    @Override
    public void start(Stage primaryStage) {
        init(primaryStage);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Statistiques concernant les promotions");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public StackedAreaChart createStackedChart() {
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

        ObservableList<StackedAreaChart.Series> areaChartData = FXCollections.observableArrayList(
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
        return new StackedAreaChart(xAxis, yAxis, areaChartData);
    }
    
    
    public BarChart createBarChart(){
         String[] years = {"Juin", "Jouillet", "Aout"};
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));
        NumberAxis yAxis = new NumberAxis("Nbre des propriétées", 0.0d, 3000.0d, 1000.0d);
        ObservableList<BarChart.Series> barChartData = FXCollections.observableArrayList(
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
        return  new BarChart(xAxis, yAxis, barChartData, 25.0d);
    }

    private LineChart createLineChart() {
       NumberAxis xAxis = new NumberAxis("Semaine", 0, 3, 1);
        NumberAxis yAxis = new NumberAxis("Nbre d'annances ajoutée", 0, 3, 1);
        ObservableList<XYChart.Series<Double,Double>> lineChartData = FXCollections.observableArrayList(
            new LineChart.Series<Double,Double>("Bershka", FXCollections.observableArrayList(
                new XYChart.Data<Double,Double>(0.0, 1.0),
                new XYChart.Data<Double,Double>(1.2, 1.4),
                new XYChart.Data<Double,Double>(2.2, 1.9),
                new XYChart.Data<Double,Double>(2.7, 2.3),
                new XYChart.Data<Double,Double>(2.9, 0.5)
            )),
            new LineChart.Series<Double,Double>("Zara", FXCollections.observableArrayList(
                new XYChart.Data<Double,Double>(0.0, 1.6),
                new XYChart.Data<Double,Double>(0.8, 0.4),
                new XYChart.Data<Double,Double>(1.4, 2.9),
                new XYChart.Data<Double,Double>(2.1, 1.3),
                new XYChart.Data<Double,Double>(2.6, 0.9)
            ))
        );
        return new LineChart(xAxis, yAxis, lineChartData);
    }
    
    
     public PieChart createPieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
             new PieChart.Data("H&M", 20),
             new PieChart.Data("Blue Islend", 12),
             new PieChart.Data("Celio", 25),
             new PieChart.Data("Bershka", 22),
             new PieChart.Data("Zara", 30)
         );
        return new PieChart(pieChartData);
    }

    private ScatterChart createScatterChart() {
        NumberAxis xAxis = new NumberAxis("Jour", 0d, 8.0d, 1.0d);
        NumberAxis yAxis = new NumberAxis("Nbre de promotions", 0.0d, 5.0d, 1.0d);
        ObservableList<XYChart.Series> data = FXCollections.observableArrayList(
            new ScatterChart.Series("Pull and Bear", FXCollections.<ScatterChart.Data>observableArrayList(
                new XYChart.Data(0.2, 3.5),
                new XYChart.Data(0.7, 4.6),
                new XYChart.Data(1.8, 1.7),
                new XYChart.Data(2.1, 2.8),
                new XYChart.Data(4.0, 2.2),
                new XYChart.Data(4.1, 2.6),
                new XYChart.Data(4.5, 2.0),
                new XYChart.Data(6.0, 3.0),
                new XYChart.Data(7.0, 2.0),
                new XYChart.Data(7.8, 4.0)
            ))
        );
        return new ScatterChart(xAxis, yAxis, data);
    }
     
}

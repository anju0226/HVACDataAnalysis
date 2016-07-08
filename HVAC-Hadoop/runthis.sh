#!/bin/bash
hadoop fs -mkdir -p input
hadoop fs -put /home/anju/Downloads/HVACDataAnalysis-master/HVAC-Hadoop/data/firstResult.csv input/
hadoop jar /home/anju/Downloads/HVACDataAnalysis-master/HVAC-Hadoop/target/HVAC-1.0-SNAPSHOT.jar HadoopDemo


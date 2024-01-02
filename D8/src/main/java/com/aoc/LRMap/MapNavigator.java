package com.aoc.LRMap;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class MapNavigator {
    Map<String,LRPoint> map=new HashMap<>();
    Map<String,Circle> circles=new HashMap<>();
    char[] instructions;

    public MapNavigator(String path) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))){
          instructions = br.readLine().toCharArray();
          br.readLine();
          String line;
          while((line= br.readLine())!=null){
              LRPoint p = new LRPoint(line);
              map.put(p.getValue(),p);
          }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int howManyStepsFromAAAToZZZ(){

        String[] points= map.keySet().stream().filter(s->s.charAt(2)=='A').toArray(String[]::new);
        //String point = "AAA";
        int steps=0;
        int lrIndex=-1;
        while(!haveWeArrived(points)){
            lrIndex=(lrIndex+1)%instructions.length;
            steps++;
            for(int i=0;i<points.length;++i){
                points[i]=map.get(points[i]).turn(instructions[lrIndex]);
            }

        }
        return steps;
    }

    private boolean haveWeArrived(String[] points){
        for(String s : points){
            if(s.charAt(2)!='Z'){
                return false;
            }
        }
        return true;
    }

    private void calculateAllCircles(){
        circles = map.keySet().stream().filter(s->s.charAt(2)=='A').collect(Collectors.toMap(s->s,this::calculateCircle));
    }

    public long calculateSteps(){
        calculateAllCircles();
        List<Circle> circleList = new ArrayList<>(circles.values());
        Collections.sort(circleList);
        Circle maxCircle = circleList.remove(circleList.size()-1);
        boolean allCircleMeets=false;
        long steps=maxCircle.offset;
        while(!allCircleMeets){
            steps+=maxCircle.length;
            for(Circle c: circleList){
                allCircleMeets = ((steps - c.offset) % c.length) == 0;
                if(!allCircleMeets){
                    break;
                }
            }
        }
        return steps;
    }

    public Circle calculateCircle(String from){
        Map<String, List<Integer>> zPoints =  new HashMap<>();
        String point = from;
        int steps=0;
        int lrIndex=-1;
        while(point.charAt(2)!='Z' || getCircle(zPoints.get(point))==null ){
            lrIndex=(lrIndex+1)%instructions.length;
            steps++;
            point=map.get(point).turn(instructions[lrIndex]);
            if(point.charAt(2)=='Z'){
                if(!zPoints.containsKey(point)){
                    zPoints.put(point,new ArrayList<>());
                }
                zPoints.get(point).add(steps);
            }
        }
        return getCircle(zPoints.get(point));
    }

    private Circle getCircle(List<Integer> steps) {
        if(steps==null || steps.size()<2){
            return null;
        }

        int lastStep=steps.get(steps.size()-1);
        for(int i=steps.size()-2;i>-1;i--){
            int step=steps.get(i);
            if(step%instructions.length==lastStep%instructions.length){
                return new Circle(step,lastStep-step);
            }
        }
        return null;
    }

}

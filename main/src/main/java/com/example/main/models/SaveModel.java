package com.example.main.models;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaveModel {
    public void writeToFile(List<ShapeModel> list){
        File file = new File(".");
        try {
            System.out.println(file.getAbsolutePath());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<svg width=\"800\" height=\"600\" xmlns=\"http://www.w3.org/2000/svg\"> ");
            getShapePositionsToDraw(stringBuilder, list);
            stringBuilder.append("</svg>");
            PrintWriter myWriter = new PrintWriter("Saved-Picture.svg");
            myWriter.write(stringBuilder.toString());
            myWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void getShapePositionsToDraw(StringBuilder stringBuilder, List<ShapeModel> list){
        list.forEach(shapeModel -> {
            if (shapeModel instanceof CircleModel) {
                stringBuilder.append(" <circle cx=");
                stringBuilder.append("\"").append((int) shapeModel.getStartX()).append("\"");
                stringBuilder.append(" ");
                stringBuilder.append("cy=");
                stringBuilder.append("\"").append((int) shapeModel.getStartY()).append("\"");
                stringBuilder.append(" r=");
                stringBuilder.append("\"").append((int) shapeModel.getWidth() / 2).append("\"");
                stringBuilder.append(" ");
                stringBuilder.append("fill= ");
                stringBuilder.append("\"" + "#" + shapeModel.getColor().toString().substring(2, 8)+ "\"");
                stringBuilder.append(" ");
                stringBuilder.append(" />");

            }
            else{
                stringBuilder.append(" <rect x=");
                stringBuilder.append("\"").append((int) shapeModel.getStartX()).append("\"");
                stringBuilder.append(" ");
                stringBuilder.append("y= ");
                stringBuilder.append("\"").append((int) shapeModel.getStartY()).append("\"");
                stringBuilder.append(" ");
                stringBuilder.append("width= ");
                stringBuilder.append("\"").append((int) shapeModel.getWidth()).append("\"");
                stringBuilder.append(" ");
                stringBuilder.append("height= ");
                stringBuilder.append("\"").append((int) shapeModel.getHeight()).append("\"");
                stringBuilder.append(" ");
                stringBuilder.append("fill= ");
                stringBuilder.append("\"" + "#" + shapeModel.getColor().toString().substring(2, 8) + "\"");
                stringBuilder.append(" ");
                stringBuilder.append(" />");
            }

        });
    }

}

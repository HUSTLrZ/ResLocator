package com.lrz;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;

/**
 * 利用模板匹配来匹配电容加号，返回加号位置
 * @Author HustLrz
 * @Date Created in 13:49 2017/11/20
 */
public class TemplateMatch {

    public static Point match(Mat src, Mat template) {
        Mat result = Mat.zeros(src.rows(), src.cols(), CvType.CV_32FC1);
        Imgproc.matchTemplate(src, template, result, Imgproc.TM_SQDIFF_NORMED);
        Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1);
        Core.MinMaxLocResult mlr = Core.minMaxLoc(result);
        Point matchLoc = mlr.minLoc;
//        Imgproc.rectangle(src, matchLoc, new Point(matchLoc.x + template.width(), matchLoc.y + template.height()), new Scalar(255, 0, 255, 255), 5);
//        Imgcodecs.imwrite("res/img/capacity/templateMatch.jpg", src);
        return matchLoc;
    }
}

package com.zker.common.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


/**
 * zker 图友网模拟项目
 * FileName:ImageUtil
 * <p>图片相关的工具类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-7 Dulk
 */
public final class ImageUtil {
    private static final char[] chars = { '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
    private static final int SIZE = 4;
    private static final int LINES = 5;
    private static final int WIDTH = 80;
    private static final int HEIGHT = 40;
    private static final int FONT_SIZE = 30;

    /**
     * 创建一个随机的验证码图片
     * @return Map，key为生成的验证码字符串，value为BufferedImage的流
     */
    public static Map<String, BufferedImage> createImage() {
        StringBuffer sb = new StringBuffer();
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphic = image.getGraphics();
        graphic.setColor(Color.LIGHT_GRAY);
        graphic.fillRect(0, 0, WIDTH, HEIGHT);
        Random ran = new Random();
        // 画随机字符
        for (int i = 1; i <= SIZE; i++) {
            int r = ran.nextInt(chars.length);
            graphic.setColor(getRandomColor());
            graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
            graphic.drawString(chars[r] + "", (i - 1) * WIDTH / SIZE,
                    HEIGHT / 2);
            sb.append(chars[r]);// 将字符保存，存入Session
        }
        // 画干扰线
        for (int i = 1; i <= LINES; i++) {
            graphic.setColor(getRandomColor());
            graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT),
                    ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
        }
        Map<String, BufferedImage> map = new HashMap<String, BufferedImage>();
        map.put(sb.toString(), image);
        return map;
    }

    /**
     * 获取一个随机的颜色
     * @return 随机的颜色
     */
    public static Color getRandomColor() {
        Random ran = new Random();
        Color color = new Color(ran.nextInt(256), ran.nextInt(256),
                ran.nextInt(256));
        return color;
    }

    /**
     * 根据一个BufferedImage获取一个输入流对象
     * @param image
     * @return InputStream
     */
    public static InputStream getInputStream(BufferedImage image) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
        try {
            encoder.encode(image);
        } catch (ImageFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] imageBts = bos.toByteArray();
        InputStream in = new ByteArrayInputStream(imageBts);
        return in;
    }

}

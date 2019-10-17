package utils;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * <img src="cache/barcode/barcode.png"/>
 */
public class BarCodeUtil {
    public static void GenerateBarCode(String msg, String fileName, HttpServletRequest request) {
        String tomcatRoot = request.getSession().getServletContext().getRealPath("");
        tomcatRoot = tomcatRoot.replace("\\", "/");
        File filePath = new File(tomcatRoot + "/cache/barcode/");
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        File barCodeImg = new File(filePath, fileName);
        try {
            generate(msg, new FileOutputStream(barCodeImg));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static byte[] generate(String msg) {
        ByteArrayOutputStream ous = new ByteArrayOutputStream();
        generate(msg, ous);
        return ous.toByteArray();
    }

    /**
     * 生成到流
     *
     * @param msg
     * @param ous
     */
    private static void generate(String msg, OutputStream ous) {
        if (msg.isEmpty() || ous == null) {
            return;
        }

        Code128Bean bean = new Code128Bean();

        // 精细度
        final int dpi = 200;
        // module宽度
        final double moduleWidth = UnitConv.in2mm(3.0f / dpi);
        // 配置对象
        bean.setModuleWidth(moduleWidth);

        bean.setBarHeight(10);
        // 白边显示
        bean.doQuietZone(true);

        String format = "image/png";
        try {

            // 输出到流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous, format, dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

            // 生成条形码
            bean.generateBarcode(canvas, msg);

            // 结束绘制
            canvas.finish();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

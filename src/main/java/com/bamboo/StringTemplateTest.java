package com.bamboo;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

import static java.lang.StringTemplate.RAW;
import static java.util.FormatProcessor.FMT;

/**
 * @author wangsaisai
 * @date 2023/10/2
 */
public class StringTemplateTest {

  private static String convertToUpperCase(String value) {
    return value.toUpperCase();
  }

  // StringTemplate.STR
  public static void strTest() {
    //java: 字符串模板 是预览功能，默认情况下禁用。
    //  （请使用 --enable-preview 以启用 字符串模板）
    int x = 10, y = 20;
    String s = STR. "\{ x } + \{ y } = \{ x + y }" ;
    System.out.println(s);  // 10 + 20 = 30

    // 在当前类中查找方法
    String text = STR. "The value is \{ convertToUpperCase("foo") }" ;  // The value is FOO
    System.out.println(text);
  }

  public static void rawTest() {
    String name = "world";
    StringTemplate template = RAW. "hello \{ name }" ;

    String text = STR.process(template);
    System.out.println(text); // hello world

    String text2 = template.process(STR);
    System.out.println(text2); // hello world
  }

  public static void fmtTest() {
    record Rectangle(String name, double width, double height) {
      double area() {
        return width * height;
      }
    }
    Rectangle[] zone = new Rectangle[]{
      new Rectangle("Alfa", 17.8, 31.4),
      new Rectangle("Bravo", 9.6, 12.4),
      new Rectangle("Charlie", 7.1, 11.23),
    };
    String table = FMT. """
    Description     Width    Height     Area
    %-12s\{ zone[0].name }  %7.2f\{ zone[0].width }  %7.2f\{ zone[0].height }     %7.2f\{ zone[0].area() }
    %-12s\{ zone[1].name }  %7.2f\{ zone[1].width }  %7.2f\{ zone[1].height }     %7.2f\{ zone[1].area() }
    %-12s\{ zone[2].name }  %7.2f\{ zone[2].width }  %7.2f\{ zone[2].height }     %7.2f\{ zone[2].area() }
    \{ " ".repeat(28) } Total %7.2f\{ zone[0].area() + zone[1].area() + zone[2].area() }
    """ ;

    /*
      Description     Width    Height     Area
      Alfa            17.80    31.40      558.92
      Bravo            9.60    12.40      119.04
      Charlie          7.10    11.23       79.73
                                   Total  757.69
     */
    System.out.println(table);
  }

  public static void jsonTest() {
    var JsonTemplate = StringTemplate.Processor.of(
      (StringTemplate st) -> Json.createReader(new StringReader(st.interpolate())).readObject()
    );
    JsonObject jsonObject = JsonTemplate."{\"a\":\"b\"}";
    System.out.println(jsonObject);
  }

  public static void main(String[] args) {
    strTest();
    rawTest();
    fmtTest();
    jsonTest(); // {"a":"b"}
  }

}

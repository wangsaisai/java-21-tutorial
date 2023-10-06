package com.bamboo;

/**
 * @author wangsaisai
 * @date 2023/10/6
 */
public class TextBlockTest {

  public static void main(String[] args) {
    String textBlock = """  
    This is a text block.  
    It can span multiple lines.  
    每行文本最后的空格不会打印出来。           
    """;
    System.out.println(textBlock);
  }
}

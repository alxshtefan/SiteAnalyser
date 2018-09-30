package com.site.analyser.jsoup.worker;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Analyser {

  private static final Logger log = Logger.getLogger(Analyser.class);

  private static final String TEST_URI = "http://www.vogella.com";
  private static final String URI = "http://cs.joensuu.fi/sipu/datasets/";

  public void analyse() {
    Document doc;
    try {
      doc = Jsoup.connect(TEST_URI).get();
      String title = doc.title();
      System.out.println(title);
      Elements links = doc.select("a[href]");
      System.out.println(links.size());
      for (Element link : links) {
        System.out.println("Link : " + link.attr("href") + ". Text: " + link.text());
      }
    } catch (IOException e) {
      log.error("IOException occurs.");
    }

  }

}

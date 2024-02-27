package br.com.dbccompany.vemser.utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Properties;

public class Manipulation {

  @SneakyThrows
  public static Properties getProp() {
    Properties props = new Properties();

    FileInputStream file = new FileInputStream("src/main/resources/credentials.properties");
    props.load(file);

    return props;
  }

  public static BigInteger transformToBigInteger(Integer number) {
    return BigInteger.valueOf(number);
  }
}

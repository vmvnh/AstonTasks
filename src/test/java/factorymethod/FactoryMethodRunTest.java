package factorymethod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactoryMethodRunTest {

  @Test
  void createDateByCountry() {
    // Создание объекта актуальной даты.
    var result = FactoryMethodRun.createDateByCountry("russia");

    // Создание ожидаемого результата
    var expectedResult = new RussianDateFactory();

    // Сравнение результатов
    Assertions.assertEquals(expectedResult, result);
  }
}
package factorymethod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AmericanDateFactoryTest {

  @Test
  void createDateValidateObject() {
    // Создание объекта актуальной даты.
    DateFactory dateFactory = new AmericanDateFactory();
    var result = dateFactory.createDate();

    // Создание ожидаемого результата
    var expectedResult = new AmericanDate();

    // Сравнение результатов
    Assertions.assertEquals(expectedResult, result);
  }
}
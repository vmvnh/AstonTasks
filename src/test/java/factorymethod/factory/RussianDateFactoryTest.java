package factorymethod.factory;

import factorymethod.date.RussianDate;
import factorymethod.factory.DateFactory;
import factorymethod.factory.RussianDateFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RussianDateFactoryTest {

  @Test
  void createDateRightObject() {
    // Создание объекта актуальной даты.
    DateFactory dateFactory = new RussianDateFactory();
    var result = dateFactory.createDate();

    // Создание ожидаемого результата
    var expectedResult = new RussianDate();

    // Сравнение результатов
    Assertions.assertEquals(expectedResult, result);
  }
}
package factorymethod.date;

import factorymethod.date.AmericanDate;
import factorymethod.date.Date;
import factorymethod.date.RussianDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class AmericanDateTest {

  @Test
  void dateRightFormat() {
    // Создание объекта актуальной даты.
    Date date = new AmericanDate();
    var result = date.getDate();

    // Создание ожидаемого результата
    LocalDate localDate = LocalDate.now();
    var expectedResult =
        localDate.getMonthValue() + "/" +
        localDate.getDayOfMonth() + "/" +
        localDate.getYear();

    // Сравнение результатов
    Assertions.assertEquals(expectedResult, result);
  }

  @Test
  void dateValidEquals() {
    // Создание равных объектов даты.
    Date date = new AmericanDate();
    Date dateSecond = new AmericanDate();
    var result = date.equals(dateSecond);

    // Создание ожидаемого результата
    var expectedResult = true;

    // Сравнение результатов
    Assertions.assertEquals(expectedResult, result);
  }

  @Test
  void dateNotValidEquals() {
    // Создание не равных объектов даты.
    Date date = new AmericanDate();
    Date dateSecond = new RussianDate();
    var result = date.equals(dateSecond);

    // Создание ожидаемого результата
    var expectedResult = false;

    // Сравнение результатов
    Assertions.assertEquals(expectedResult, result);
  }
}
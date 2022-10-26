package decorator.salary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PayrollTest {

  @Test
  void validateGetSalary() {
    // Создание объекта зарплаты
    Salary salary = new Payroll(10000);
    var result = salary.getSalary();

    // Создание ожидаемого результата
    var expectedResult = 8000;

    // Сравнение результатов
    Assertions.assertEquals(expectedResult, result);
  }
}
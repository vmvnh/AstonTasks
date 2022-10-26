package decorator.decorators;

import decorator.salary.Payroll;
import decorator.salary.Salary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnionDecoratorTest {

  @Test
  void validateGetSalary() {
    // Создание объекта зарплаты
    Salary salary = new Payroll(10000);
    // Создание базового декоратора
    salary = new UnionDecorator(salary);
    var result = salary.getSalary();

    // Создание ожидаемого результата
    var expectedResult = 7000;

    // Сравнение результатов
    Assertions.assertEquals(expectedResult, result);
  }
}
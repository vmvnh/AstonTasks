package decorator.decorators;

import decorator.salary.Payroll;
import decorator.salary.Salary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SalaryDecoratorTest {

  @Test
  void validateGetSalary() {
    // Создание объекта зарплаты
    Salary salary = new Payroll(10000);
    // Создание базового декоратора
    Salary salaryDecorator = new SalaryDecorator(salary);
    var result = salaryDecorator.getSalary();

    // Создание ожидаемого результата
    var expectedResult = 8000;

    // Сравнение результатов
    Assertions.assertEquals(expectedResult, result);
  }
}
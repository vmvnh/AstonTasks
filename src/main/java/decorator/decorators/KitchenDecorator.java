package decorator.decorators;

import decorator.salary.Salary;

/**
 * Вычет взноса для кухни.
 */
public class KitchenDecorator extends SalaryDecorator {

  // Размер взноса на содержание кухни
  int payment = 1000;

  @Override
  public int getSalary() {
    return donation(super.getSalary());
  }

  /**
   * Вычетает взнос для кухни из зарплаты.
   *
   * @param salary Зарплата.
   * @return Возвращает зарплату.
   */
  public int donation(int salary) {
    return salary - payment;
  }

  public KitchenDecorator(Salary salary) {
    super(salary);
  }
}

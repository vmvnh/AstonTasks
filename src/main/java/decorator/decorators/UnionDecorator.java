package decorator.decorators;

import decorator.salary.Salary;

/**
 * Вычет взноса на профсоюз.
 */
public class UnionDecorator extends SalaryDecorator {

  // Размер взноса на профсоюз
  int payment = 1000;

  @Override
  public int getSalary() {
    return donation(super.getSalary());
  }

  /**
   * Вычитает взнос в профсоюз из зарплаты.
   *
   * @param salary Зарплата.
   * @return Возвращает зарплату.
   */
  public int donation(int salary) {
    return salary - payment;
  }

  public UnionDecorator(Salary salary) {
    super(salary);
  }
}

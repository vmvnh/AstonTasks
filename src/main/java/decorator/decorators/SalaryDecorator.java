package decorator.decorators;

import decorator.salary.Salary;

/**
 * Базовый декоратор.
 */
public class SalaryDecorator implements Salary {

  private Salary wrap;
  @Override
  public int getSalary() {
    return wrap.getSalary();
  }

  public SalaryDecorator(Salary salary) {
    this.wrap = salary;
  }
}

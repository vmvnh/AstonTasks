package decorator.salary;

/**
 * Расчет зарплаты после вычета налога.
 */
public class Payroll implements Salary{
  int salary;

  // Размер налога
  int tax = 2000;

  // Возвращает зарплату после вычета налога
  @Override
  public int getSalary() {
    return this.salary - tax;
  }

  public Payroll(int salary) {
    this.salary = salary;
  }
}

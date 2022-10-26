package decorator;

import decorator.decorators.KitchenDecorator;
import decorator.decorators.UnionDecorator;
import decorator.salary.Payroll;
import decorator.salary.Salary;

public class DecoratorRun {
  public static void main(String[] args) {
    // Производим рассчет зарплаты после вычета налога
    Salary salary = new Payroll(10000);
    System.out.println(salary.getSalary());

    // Производим рассчет зарплаты после вычета взноса на профсоюз
    salary = new UnionDecorator(salary);
    System.out.println(salary.getSalary());

    // Производим рассчет зарплаты после вычета взноса на содержания кухни
    salary = new KitchenDecorator(salary);
    System.out.println(salary.getSalary());
  }
}

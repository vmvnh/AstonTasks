package factorymethod;

import java.time.LocalDate;

/**
 * Американский формат даты.
 */
public class AmericanDate implements Date {
  int day, month, year;

  /**
   * Вывод актуальной даты.
   */
  @Override
  public void printDate() {
    // Формат американской даты мм/дд/гггг
    System.out.println("Актуальная дата: " + month + "/" + day + "/" + year);
  }

  /**
   * Конструктор класса.
   */
  public AmericanDate() {
    LocalDate date = LocalDate.now();
    this.day = date.getDayOfMonth();
    this.month = date.getMonthValue();
    this.year = date.getYear();
  }
}
